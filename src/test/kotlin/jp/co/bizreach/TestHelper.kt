package jp.co.bizreach

import org.junit.jupiter.api.Assertions.*
import org.opentest4j.*
import java.sql.*
import java.time.*

fun <U> List<U>.shouldNotEmpty() = this.also {
    if (this.isEmpty())
        throw AssertionError("result set should not be empty")
}

fun Map<String, Any>.shouldHaveColumn(column: String): Any? {
    val alias = column.toLowerCase()
    if (this.containsKey(alias).not()) {
        throw AssertionError("$column ==> expected: <exists> but was: <not exists>")
    }
    return this[alias]
}
fun Map<String, Any>.shouldNotHaveColumn(column: String): Any? {
    val alias = column.toLowerCase()
    if (this.containsKey(alias)) {
        throw AssertionError("$column ==> expected: <not exists> but was: <exists>")
    }
    return this[alias]
}

inline fun <reified O> Map<String, Any>.getAs(column: String): O? {
    val value = this.shouldHaveColumn(column)

    if (value is O?) {
        return value
    } else {
        throw AssertionError("$column ==> expected: <type ${O::class.simpleName}> but was: <type ${value!!::class.simpleName}>")
    }
}

data class RecordValue<V>(val column: String, val value: V) {
    fun fail(expected: Any) {
        throw AssertionFailedError(
            "$column ==> expected: <$expected> but was: <$value>",
            expected,
            value
        )
    }

    fun notNull() {
        assertNotNull(value, column)
    }

    fun isNull() {
        assertNull(value, column)
    }

    fun eq(expected: V) {
        assertEquals(expected, value, column)
    }
}

fun RecordValue<String?>.shouldStartsWith(s: String): RecordValue<String?> {
    this.notNull()
    if (this.value!!.startsWith(s).not())
        this.fail("start with $s")
    return this
}

fun RecordValue<String?>.contains(s: String): RecordValue<String?> {
    this.notNull()
    if (this.value!!.contains(s).not())
        this.fail("contains $s")
    return this
}

fun RecordValue<String?>.oneOf(vararg values: String): RecordValue<String?> {
    this.notNull()
    if (values.none { s -> s == this.value })
        this.fail("one of [${values.joinToString(" ,")}]")
    return this
}

fun RecordValue<String?>.greaterThanEq(value: String): RecordValue<String?> {
    this.notNull()
    if (this.value!! < value)
        this.fail("greater than or equal to $value")
    return this
}

fun RecordValue<LocalDateTime?>.isBefore(d: LocalDateTime): RecordValue<LocalDateTime?> {
    this.notNull()
    if (this.value!!.isBefore(d).not())
        this.fail("before $d")
    return this
}

fun RecordValue<LocalDateTime?>.isBeforeEq(d: LocalDateTime): RecordValue<LocalDateTime?> {
    this.notNull()
    if (this.value!!.isBefore(d).not() && this.value.isEqual(d).not())
        this.fail("before or equal $d")
    return this
}

fun RecordValue<LocalDateTime?>.isAfter(d: LocalDateTime): RecordValue<LocalDateTime?> {
    this.notNull()
    if (this.value!!.isAfter(d).not())
        this.fail("after $d")
    return this
}

fun RecordValue<LocalDate?>.isBefore(d: LocalDate): RecordValue<LocalDate?> {
    this.notNull()
    if (this.value!!.isBefore(d).not())
        this.fail("before $d")
    return this
}

fun RecordValue<LocalDate?>.isBeforeEq(d: LocalDate): RecordValue<LocalDate?> {
    this.notNull()
    if (this.value!!.isEqual(d).not() && this.value.isBefore(d).not())
        this.fail("before or equal $d")
    return this
}

fun RecordValue<LocalDate?>.isAfterEq(d: LocalDate): RecordValue<LocalDate?> {
    this.notNull()
    if (this.value!!.isAfter(d).not() && this.value.isEqual(d).not())
        this.fail("after or equal $d")
    return this
}

fun Map<String, Any>.datetime(key: String) = RecordValue(key, getAs<Timestamp>(key)?.toLocalDateTime())
fun Map<String, Any>.date(key: String) = RecordValue(key, getAs<Date>(key)?.toLocalDate())
fun Map<String, Any>.string(key: String) = RecordValue(key, getAs<String>(key))
fun Map<String, Any>.int(key: String) = RecordValue(key, getAs<Int>(key))
fun Map<String, Any>.long(key: String) = RecordValue(key, getAs<Long>(key))

// ______________________________________________________
//
// @ Composite Assertions
fun Map<String, Any>.shouldHaveMemberTable() = this.also {
    int("MEMBER_ID").notNull()
    string("MEMBER_NAME").notNull()
    string("MEMBER_ACCOUNT").notNull()
    string("MEMBER_STATUS_CODE").notNull()
    datetime("FORMALIZED_DATETIME")
    date("BIRTHDATE")
}

fun Map<String, Any>.shouldHaveMemberStatusTable() = this.also {
    string("MEMBER_STATUS_CODE").notNull()
    string("MEMBER_STATUS_NAME").notNull()
    string("DESCRIPTION").notNull()
}

fun Map<String, Any>.shouldHaveMemberSecurityTable() = this.also {
    string("LOGIN_PASSWORD").notNull()
    string("REMINDER_QUESTION").notNull()
    string("REMINDER_ANSWER").notNull()
}

fun Map<String, Any>.shouldHaveMemberWithdrawTable() = this.also {
    string("WITHDRAWAL_REASON_CODE")
    string("WITHDRAWAL_REASON_INPUT_TEXT")
    datetime("WITHDRAWAL_DATETIME").notNull()
}

fun Map<String, Any>.shouldHavePurchaseTable() = this.also {
    long("PURCHASE_ID").notNull()
    int("MEMBER_ID").notNull()
    int("PRODUCT_ID").notNull()
    datetime("PURCHASE_DATETIME").notNull()
    int("PURCHASE_COUNT").notNull()
    int("PURCHASE_PRICE").notNull()
    int("PAYMENT_COMPLETE_FLG").notNull()
}
