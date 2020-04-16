package jp.co.bizreach

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.time.*

class Section3 {

    /**
     * ## Question
     * - 退会会員の未払い購入を検索
     *
     * ## Requirements
     * - 退会会員のステータスコードは "WDL"。
     * - 支払完了フラグは "0" で未払い。
     * - 購入日時の降順で並べる
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section04.html#plainway">DBFlute ハンズオンセクション04 - ベタベタのやり方 </a>
     */
    @DisplayName("""退会会員の未払い購入を検索""")
    @Test
    fun step1() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select PURCHASE.*
from PURCHASE
        """.fetch()

        // Assert:
        assertStep1(results)
    }


    /**
     * ## Question
     * - 会員退会情報も取得して会員を検索
     *
     * ## Requirements
     * - 退会会員のステータスコードは "WDL"
     * - 不意のバグや不意のデータ不備でもテストが(できるだけ)成り立つこと
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section04.html#plainway">DBFlute ハンズオンセクション04 - ベタベタのやり方 </a>
     */
    @DisplayName("""会員退会情報も取得して会員を検索""")
    @Test
    fun step2() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select MEMBER.*
from MEMBER
        """.fetch()

        // Assert:
        assertStep2(results)
    }

    /**
     * ## Question
     * - 一番若い仮会員の会員を検索
     *
     * ## Requirements
     * - ーーー
     * ## Remarks
     * - ※できれば、検索回数は一回で...
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section04.html#morecls">DBFlute ハンズオンセクション04 - さらに区分値を活用して実装 </a>
     */
    @DisplayName("""一番若い仮会員の会員を検索""")
    @Test
    fun step3() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select *
from MEMBER
        """.fetch()

        // Assert:
        assertStep3(results)
    }

    /**
     * ## Question
     * - 支払済みの購入の中で一番若い正式会員のものだけ検索
     *
     * ## Requirements
     * - 購入日時の降順で並べる
     *
     * ## Remarks
     * - ※これ難しい...かも!? (解釈に "曖昧さ" あり、実際にデータが存在している方を優先)
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section04.html#morecls">DBFlute ハンズオンセクション04 - さらに区分値を活用して実装 </a>
     */
    @DisplayName("""支払済みの購入の中で一番若い正式会員のものだけ検索""")
    @Test
    fun step4() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select PURCHASE.*
from PURCHASE
        """.fetch()

        // Assert:
        assertStep4(results)
    }

    /**
     * ## Question
     * - 生産販売可能な商品の購入を検索
     *
     * ## Requirements
     * - 商品ステータス名称、退会理由テキスト (退会理由テーブル) も取得する(ログに出力) ※1
     * - 購入価格の降順で並べる
     * - 購入の紐づいている商品が生産販売可能であることをアサート
     *
     * ## Remarks
     * - ---
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section04.html#morecls">DBFlute ハンズオンセクション04 - さらに区分値を活用して実装 </a>
     */
    @DisplayName("""生産販売可能な商品の購入を検索""")
    @Test
    fun step5() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select *
from PURCHASE
        """.fetch()

        // Assert:
        assertStep5(results)
    }

    /**
     * ## Question
     * - 銀行振込で購入を支払ったことのある、会員ステータスごとに一番若い会員を検索
     *
     * ## Requirements
     * - 正式会員で一番若い、仮会員で一番若い、という風にそれぞれのステータスで若い会員を検索
     * - 一回の検索で会員たちを検索すること
     * - ログのSQLを見て、検索が妥当であることを目視で確認すること
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section04.html#morecls">DBFlute ハンズオンセクション04 - さらに区分値を活用して実装 </a>
     */
    @DisplayName("""銀行振込で購入を支払ったことのある、会員ステータスごとに一番若い会員を検索""")
    @Test
    fun step6() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select * 
from MEMBER
        """.fetch()

        // Assert:
        assertStep6(results)
    }

    /**
     * ## Question
     * - 未払い購入のある会員を検索
     *
     * ## Requirements
     * - 正式会員日時の降順(nullを後に並べる)、会員IDの昇順で並べる
     * - 会員が未払いの購入を持っていることをアサート
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section04.html#sistercode">DBFlute ハンズオンセクション04 - 姉妹コードの利用 </a>
     */
    @DisplayName("""未払い購入のある会員を検索""")
    @Test
    fun step7() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select * 
from MEMBER
        """.fetch()

        // Assert:
        assertStep7(results)
    }

    // ______________________________________________________
    //
    // @ Assertions

    private fun assertStep1(results: List<Map<String, Any>>) {

        results.shouldNotEmpty().forEach { result ->
            result.shouldHavePurchaseTable()
            result.int("PAYMENT_COMPLETE_FLG").eq(0)

            val memberId = result.int("MEMBER_ID").also { it.notNull() }.value!!
            val check = "select * from MEMBER where MEMBER_ID = :id".fetch("id" to memberId).first()
            check.string("MEMBER_STATUS_CODE").eq("WDL")
        }
    }

    private fun assertStep2(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().forEach { result ->
            result.shouldHaveMemberTable()

            result.string("MEMBER_NAME").notNull()
            if (result.string("MEMBER_STATUS_CODE").value == "WDL")
                result.shouldHaveMemberWithdrawTable()
            else
                result.datetime("WITHDRAWAL_DATETIME").isNull()
        }
    }

    private fun assertStep3(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().forEach { result ->
            result.shouldHaveMemberTable()
            result.string("MEMBER_STATUS_CODE").eq("PRV")
            result.date("BIRTHDATE").eq(LocalDate.of(1968, 1, 1))
        }
    }

    private fun assertStep4(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().forEach { result ->
            result.shouldHavePurchaseTable()
            // TODO(手抜き)
            result.int("MEMBER_ID").eq(4)
        }
    }

    private fun assertStep5(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().forEach { result ->
            result.shouldHavePurchaseTable()
            result.string("PRODUCT_STATUS_CODE").eq("ONS")
        }
    }

    private fun assertStep6(results: List<Map<String, Any>>) {
        assertEquals(3, results.size)
        results.forEach { result ->
            result.shouldHaveMemberTable()
            result.date("BIRTHDATE").notNull()
            result.string("MEMBER_STATUS_CODE").oneOf("FML", "WDL", "PRV")
        }
    }

    private fun assertStep7(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().forEach { result ->
            result.int("MEMBER_ID").notNull()
            val memberId = result.int("MEMBER_ID").value!!
            val unpaidPurchase = "select * from PURCHASE where MEMBER_ID = :id and PAYMENT_COMPLETE_FLG = 0".fetch("id" to memberId)
            assertTrue(unpaidPurchase.isNotEmpty(), "member should have unpaid purchase")
        }
    }
}