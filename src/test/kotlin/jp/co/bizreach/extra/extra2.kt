package jp.co.bizreach.extra

import jp.co.bizreach.*
import org.junit.jupiter.api.*

class Extra6 {

    /**
     * ## Question
     * - ロジックのメソッド
     *
     * ## Requirements
     * - サービスポイントカウントを会員IDで割った値の大きい順で会員を検索
     * - その割った値の先頭からの合計値が 24000 より小さい人だけのリストを戻す
     * - その絞り込みは SQL でなくてもいいが、できるだけ効率よく
     *
     * ## Assertions
     * - その通りの順序で検索されていることをアサート
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section12.html#orderby">DBFlute ハンズオンセクション12 - Dream Order </a>
     */
    @DisplayName("""対応テストメソッド""")
    @Test
    fun step1() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select * 
from MEMBER
        """.fetch()

        // Assert:

        results.shouldNotEmpty().forEach { result ->

        }
    }


    /**
     * ## Question
     * - ロジックのメソッド
     *
     * ## Requirements
     * - 会員名称と会員アカウントを連結して部分一致させて、会員を検索
     *
     * ## Assertions
     * - 連結した文字列に "cP" を含む会員を検索
     * - その通りの文字列を含んでいることをアサート
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section12.html#likesearch">DBFlute ハンズオンセクション12 - Dream LikeSearch </a>
     */
    @DisplayName("""対応テストメソッド""")
    @Test
    fun step2() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select * 
from MEMBER
        """.fetch()

        // Assert:

        results.shouldNotEmpty().forEach { result ->

        }
    }


    /**
     * ## Question
     * - ロジックのメソッド
     *
     * ## Requirements
     * - サービスポイント数ランキング(1始まり)付きの会員を会員IDの昇順で検索
     *
     * ## Assertions
     * - ランキングが正しいことをアサート
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section12.html#ranking">DBFlute ハンズオンセクション12 - Dream DerivedRanking </a>
     */
    @DisplayName("""対応テストメソッド""")
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

        results.shouldNotEmpty().forEach { result ->

        }
    }


    /**
     * ## Question
     * - ロジックのメソッド
     *
     * ## Requirements
     * - 舞浜にある海パーク開業日にサービスポイント数を日数として足した日が、正式会員日時を越える会員
     *
     * ## Assertions
     * - そのレコードが検索されることをアサート
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section12.html#mystic">DBFlute ハンズオンセクション12 - Dream AddedBoundDate </a>
     */
    @DisplayName("""対応テストメソッド""")
    @Test
    fun step4() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select * 
from MEMBER
        """.fetch()

        // Assert:

        results.shouldNotEmpty().forEach { result ->

        }
    }
}