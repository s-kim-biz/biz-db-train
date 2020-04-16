package jp.co.bizreach

import org.junit.jupiter.api.*

class Section4 {

    /**
     * ## Question
     * - 最終ログイン時の会員ステータスを取得して会員を検索
     *
     * ## Requirements
     * - 会員名称と最終ログイン日時と最終ログイン時の会員ステータス名称を取得
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section05.html#impl">DBFlute ハンズオンセクション05 - 導出的one-to-oneを利用した実装 </a>
     */
    @DisplayName("""最終ログイン時の会員ステータスを取得して会員を検索""")
    @Test
    fun step1() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select MEMBER.*
from MEMBER
        """.fetch()

        // Assert:
        assertStep1(results)
    }

    private fun assertStep1(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().forEach { result ->
            result.int("MEMBER_ID").notNull()
            result.string("MEMBER_NAME").notNull()
            result.datetime("LOGIN_DATETIME").notNull()
            result.string("LOGIN_MEMBER_STATUS_NAME").oneOf("正式会員", "仮会員")
        }
    }
}