package jp.co.bizreach

import java.time.*

data class MEMBER(
    var MEMBER_ID: Int,
    var MEMBER_NAME: String,
    var MEMBER_ACCOUNT: String,
    var MEMBER_STATUS_CODE: String,
    var FORMALIZED_DATETIME: LocalDateTime?,
    var BIRTHDATE: LocalDate?,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long
)

data class MEMBER_ADDRESS(
    var MEMBER_ADDRESS_ID: Int,
    var MEMBER_ID: Int,
    var VALID_BEGIN_DATE: LocalDate,
    var VALID_END_DATE: LocalDate,
    var ADDRESS: String,
    var REGION_ID: Int,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long
)

data class MEMBER_LOGIN(
    var MEMBER_LOGIN_ID: Long,
    var MEMBER_ID: Int,
    var LOGIN_DATETIME: LocalDateTime,
    var MOBILE_LOGIN_FLG: Int,
    var LOGIN_MEMBER_STATUS_CODE: String
)

data class MEMBER_SECURITY(
    var MEMBER_ID: Int,
    var LOGIN_PASSWORD: String,
    var REMINDER_QUESTION: String,
    var REMINDER_ANSWER: String,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long
)

data class MEMBER_SERVICE(
    var MEMBER_ID: Int,
    var AKIRAKANI_OKASHII_KARAMU_MEI: Int,
    var SERVICE_RANK_CODE: String,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long
)

data class MEMBER_STATUS(
    var MEMBER_STATUS_CODE: String,
    var MEMBER_STATUS_NAME: String,
    var DESCRIPTION: String,
    var DISPLAY_ORDER: Int
)

data class MEMBER_WITHDRAWAL(
    var MEMBER_ID: Int,
    var WITHDRAWAL_REASON_CODE: String?,
    var WITHDRAWAL_REASON_INPUT_TEXT: String?,
    var WITHDRAWAL_DATETIME: LocalDateTime,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String
)

data class PRODUCT(
    var PRODUCT_ID: Int,
    var PRODUCT_NAME: String,
    var PRODUCT_HANDLE_CODE: String,
    var PRODUCT_CATEGORY_CODE: String,
    var PRODUCT_STATUS_CODE: String,
    var REGULAR_PRICE: Int?,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long
)

data class PRODUCT_CATEGORY(
    var PRODUCT_CATEGORY_CODE: String,
    var PRODUCT_CATEGORY_NAME: String,
    var PARENT_CATEGORY_CODE: String?
)

data class PRODUCT_STATUS(
    var PRODUCT_STATUS_CODE: String,
    var PRODUCT_STATUS_NAME: String
)

data class PURCHASE(
    var PURCHASE_ID: Long,
    var MEMBER_ID: Int,
    var PRODUCT_ID: Int,
    var PURCHASE_DATETIME: LocalDateTime,
    var PURCHASE_COUNT: Int,
    var PURCHASE_PRICE: Int,
    var PAYMENT_COMPLETE_FLG: Int,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long
)

data class PURCHASE_PAYMENT(
    var PURCHASE_PAYMENT_ID: Long,
    var PURCHASE_ID: Long,
    var PAYMENT_AMOUNT: Double,
    var PAYMENT_DATETIME: LocalDateTime,
    var PAYMENT_METHOD_CODE: String,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String
)

data class REGION(
    var REGION_ID: Int,
    var REGION_NAME: String
)

data class SERVICE_RANK(
    var SERVICE_RANK_CODE: String,
    var SERVICE_RANK_NAME: String,
    var SERVICE_POINT_INCIDENCE: Double,
    var NEW_ACCEPTABLE_FLG: Int,
    var DESCRIPTION: String,
    var DISPLAY_ORDER: Int
)

data class WITHDRAWAL_REASON(
    var WITHDRAWAL_REASON_CODE: String,
    var WITHDRAWAL_REASON_TEXT: String,
    var DISPLAY_ORDER: Int
)

// ______________________________________________________
//
// @ Joined Table

data class MEMBER_WITH_STATUS(
    var MEMBER_ID: Int,
    var MEMBER_NAME: String,
    var MEMBER_ACCOUNT: String,
    var MEMBER_STATUS_CODE: String,
    var FORMALIZED_DATETIME: LocalDateTime?,
    var BIRTHDATE: LocalDate?,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long,
    // MEMBER_STATUS
    var MEMBER_STATUS_NAME: String?,
    var DESCRIPTION: String?,
    var DISPLAY_ORDER: Int?
)

data class MEMBER_WITH_STATUS_WITH_SECURITY(
    var MEMBER_ID: Int,
    var MEMBER_NAME: String,
    var MEMBER_ACCOUNT: String,
    var MEMBER_STATUS_CODE: String,
    var FORMALIZED_DATETIME: LocalDateTime?,
    var BIRTHDATE: LocalDate?,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long,
    // MEMBER_STATUS
    var MEMBER_STATUS_NAME: String?,
    var DESCRIPTION: String?,
    var DISPLAY_ORDER: Int?,
    // MEMBER_SECURITY
    var LOGIN_PASSWORD: String?,
    var REMINDER_QUESTION: String?,
    var REMINDER_ANSWER: String?
)

data class MEMBER_WITH_REMINDER_QUESTION(
    var MEMBER_ID: Int,
    var MEMBER_NAME: String,
    var MEMBER_ACCOUNT: String,
    var MEMBER_STATUS_CODE: String,
    var FORMALIZED_DATETIME: LocalDateTime?,
    var BIRTHDATE: LocalDate?,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long,
    // MEMBER SECURITY
    var REMINDER_QUESTION: String?
)

data class MEMBER_WITH_WITHDRAWAL(
    var MEMBER_ID: Int,
    var MEMBER_NAME: String,
    var MEMBER_ACCOUNT: String,
    var MEMBER_STATUS_CODE: String,
    var FORMALIZED_DATETIME: LocalDateTime?,
    var BIRTHDATE: LocalDate?,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long,
    // MEMBER_WITHDRAWAL
    var WITHDRAWAL_REASON_CODE: String?,
    var WITHDRAWAL_REASON_INPUT_TEXT: String?,
    var WITHDRAWAL_DATETIME: LocalDateTime?
)

data class PURCHASE_BY_MEMBER(
    var PURCHASE_ID: Long,
    var MEMBER_ID: Int,
    var PRODUCT_ID: Int,
    var PURCHASE_DATETIME: LocalDateTime,
    var PURCHASE_COUNT: Int,
    var PURCHASE_PRICE: Int,
    var PAYMENT_COMPLETE_FLG: Int,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long,
    // MEMBER
    var MEMBER_NAME: String?,
    var MEMBER_ACCOUNT: String?,
    var MEMBER_STATUS_CODE: String?,
    var FORMALIZED_DATETIME: LocalDateTime?,
    var BIRTHDATE: LocalDate?
)

data class PURCHASE_BY_CATEGORY(
    // PURCHASE
    var PURCHASE_ID: Long,
    var MEMBER_ID: Int,
    var PRODUCT_ID: Int,
    var PURCHASE_DATETIME: LocalDateTime,
    var PURCHASE_COUNT: Int,
    var PURCHASE_PRICE: Int,
    var PAYMENT_COMPLETE_FLG: Int,
    var REGISTER_DATETIME: LocalDateTime,
    var REGISTER_USER: String,
    var UPDATE_DATETIME: LocalDateTime,
    var UPDATE_USER: String,
    var VERSION_NO: Long,
    // PRODUCT_CATEGORY
    var CHILD_CATEGORY_CODE: String?,
    var CHILD_CATEGORY_NAME: String?,
    // PARENT_PRODUCT_CATEGORY
    var PARENT_CATEGORY_CODE: String?,
    var PARENT_CATEGORY_NAME: String?
)
