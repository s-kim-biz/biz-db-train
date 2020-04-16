package jp.co.bizreach

import org.sql2o.*
import org.sql2o.Connection
import org.sql2o.converters.*
import org.sql2o.quirks.*
import java.sql.*
import java.sql.Date
import java.time.*
import java.util.*


class LocalDateConverter : Converter<LocalDate?> {
    override fun convert(value: Any?): LocalDate? =
        if (value is Date) value.toLocalDate()
        else null

    override fun toDatabaseParam(value: LocalDate?): Any? =
        value?.let { Date(it.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()) }
}

class LocalDateTimeConverter : Converter<LocalDateTime?> {
    override fun convert(value: Any?): LocalDateTime? =
        if (value is Timestamp) value.toLocalDateTime()
        else null

    override fun toDatabaseParam(value: LocalDateTime?): Any? =
        value?.let { Timestamp.valueOf(it) }
}

object DB {
    val sql2o: Sql2o
    val con: ThreadLocal<Connection> = ThreadLocal.withInitial { throw IllegalStateException("transaction not started") }

    init {
        sql2o = javaClass.getResourceAsStream("/config.properties")
            .use { prop -> Properties().apply { load(prop) } }
            .let {
                Sql2o(
                    it.getProperty("db.url"),
                    it.getProperty("db.user"),
                    null,
                    NoQuirks(mapOf(
                        LocalDate::class.java to LocalDateConverter(),
                        LocalDateTime::class.java to LocalDateTimeConverter()
                    ))
                )
            }
    }

    fun begin(block: () -> Unit) {
        sql2o.beginTransaction().use {
            con.set(it)
            block()
            con.remove()
        }
    }

    fun execute(sql: String) {
        con.get().createQuery(sql).executeUpdate()
    }

    fun select(sql: String, params: Map<String, Any>) =
        con.get().let {
            val query = it.createQuery(sql)
            params.forEach { p -> query.addParameter(p.key, p.value) }
            query.executeAndFetchTable().asList().also { result ->
                println(result.joinToString("\n").ifEmpty { "[<EMPTY>]" })
            }
        }
}

fun String.fetch(vararg params: Pair<String, Any>) = DB.select(this, params.toMap())
fun String.execute() = DB.execute(this)