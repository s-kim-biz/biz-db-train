package jp.co.bizreach

data class SchemaInfo(
    val TABLE_NAME: String,
    val COLUMN_NAME: String,
    val DATA_TYPE: String,
    val IS_NULLABLE: Boolean
)

fun main() {
    val information = """
select t.TABLE_NAME,
       c.COLUMN_NAME,
       c.DATA_TYPE,
       c.IS_NULLABLE
from TABLES t
         inner join COLUMNS c using (TABLE_NAME)
where t.TABLE_SCHEMA = 'maihamadb'
order by t.TABLE_NAME;
    """.fetch()

    val tables = information
        .groupBy({ it["TABLE_NAME"] }, { it })
        .map { (table, columns) ->
            fun kType(info: Map<String, Any>) = when (info["DATA_TYPE"]) {
                "int" -> "Int"
                "bigint" -> "Long"
                "decimal" -> "Double"
                "char", "varchar", "text" -> "String"
                "date" -> "LocalDate"
                "datetime" -> "LocalDateTime"
                else -> throw IllegalArgumentException("${info["TABLE_NAME"]}.${info["COLUMN_NAME"]} - ${info["DATA_TYPE"]}")
            }

            fun nullability(info: Map<String, Any>) = if (info["IS_NULLABLE"].toString().toBoolean()) "?" else ""

            """
data class $table (
${columns.joinToString(",\n") { "var ${it["COLUMN_NAME"]}: ${kType(it)}${nullability(it)}" }}
)
""".trimIndent()
        }.joinToString("\n")
    println(tables)
}