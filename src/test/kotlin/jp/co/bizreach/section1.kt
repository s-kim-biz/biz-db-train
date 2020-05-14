package jp.co.bizreach

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class Section1 {

    /**
     * ## Question
     * - 会員名称がSで始まる会員を検索 (これはタイトル、この中にも要件が含まれている)
     *
     * ## Requirements
     * - 会員名称の昇順で並べる (これは実装要件、Arrange or Act でこの通りに実装すること)
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section02.html#watchdata">DBFlute ハンズオンセクション02 - テストデータの閲覧 </a>
     */
    @DisplayName("""会員名称がSで始まる会員を検索 (これはタイトル、この中にも要件が含まれている)""")
    @Test
    fun step1() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select *
from MEMBER
where MEMBER.MEMBER_NAME like 'S%'
order by MEMBER.MEMBER_NAME asc
        """.fetch()

        // Assert:
        assertStep1(results)
    }


    /**
     * ## Question
     * - 会員IDが1の会員を検索
     *
     * ## Requirements
     * - ーーー
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section02.html#watchdata">DBFlute ハンズオンセクション02 - テストデータの閲覧 </a>
     */
    @DisplayName("""会員IDが1の会員を検索""")
    @Test
    fun step2() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select * 
from MEMBER
where MEMBER.MEMBER_ID = 1
        """.fetch()

        // Assert:
        assertStep2(results)
    }

    /**
     * ## Question
     * - 生年月日がない会員を検索
     *
     * ## Requirements
     * - 更新日時の降順で並べる
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section02.html#watchdata">DBFlute ハンズオンセクション02 - テストデータの閲覧 </a>
     */
    @DisplayName("""生年月日がない会員を検索""")
    @Test
    fun step3() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select * 
from MEMBER
where MEMBER.BIRTHDATE is null
        """.fetch()

        // Assert:
        assertStep3(results)
    }

    // ______________________________________________________
    //
    // @ Assertions
    private fun assertStep1(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().reduce { prev, current ->
            current.also {
                it.shouldHaveMemberTable()
                it.string("MEMBER_NAME").shouldStartsWith("S")
                it.string("MEMBER_NAME").greaterThanEq(prev.string("MEMBER_NAME").value!!)
            }
        }
    }

    private fun assertStep2(results: List<Map<String, Any>>) {
        assertEquals(1, results.size)
        results[0].int("MEMBER_ID").eq(1)
    }

    private fun assertStep3(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().reduce { prev, current ->
            current.also {
                current.shouldHaveMemberTable()
                current.date("BIRTHDATE").isNull()
                current.datetime("UPDATE_DATETIME").isBeforeEq(prev.datetime("UPDATE_DATETIME").value!!)
            }
        }
    }
}