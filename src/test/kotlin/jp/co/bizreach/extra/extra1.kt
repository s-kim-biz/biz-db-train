package jp.co.bizreach.extra

import jp.co.bizreach.*
import org.junit.jupiter.api.*

class Extra5 {

    /**
     * ## Question
     * - ロジックのメソッド
     *
     * ## Requirements
     * - 会員ステータス、会員サービス、サービスランク、購入、購入支払、会員ステータス経由の会員ログインも取得
     * - (基点テーブルごとの)モバイルからのログイン回数も導出して取得する
     * - 未払い購入の存在しない会員だけを検索
     * - 購入は商品の定価の高い順、購入価格の高い順で並べる
     * - 購入支払は、最も推奨されている方法のみ検索
     *
     * ## Assertions
     * - 未払い購入が存在しないことをアサート
     * - 会員ステータス経由の会員ログインが取得できていることをアサート
     * - 購入支払が最も推奨されている方法のみ検索されていることをアサート
     * - その他、ロジックの中で出力したログを見て期待通りであることを確認
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section11.html#onparadereferrer">DBFlute ハンズオンセクション11 - 子テーブルからみまくりの検索 </a>
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
     * - 会員ステータス、購入と商品と購入商品種類数(*1)を一緒に検索
     * - 商品ステータスが "生産中止" の商品を買ったことのある会員...もしくは(続く)
     * - (続き)手渡しだけでも払い過ぎてるのに未払いになっている購入を持ってる会員にフォローされている会員
     * - 購入は商品ステータスの表示順の昇順、購入日時の降順で並べる
     *
     * ## Assertions
     * - 商品も取得できることをアサート
     * - 購入商品種類数が妥当であることをアサート
     * - 生産中止の商品を買ったことのある会員が(一人でも)検索されていることをアサート
     * - どんな手段でもいいので、手渡しだけでも...(略)ている会員が(一人でも)検索されていることを目視確認
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section11.html#onparadereferrer">DBFlute ハンズオンセクション11 - 子テーブルからみまくりの検索 </a>
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
     * - 正式会員のときにログインした最終ログイン日時とログイン回数を導出して会員を検索
     * - さらに、支払済み購入の最大購入価格を導出して取得
     * - もっとさらに、購入と商品と商品ステータスと商品カテゴリと親商品カテゴリ(*1)も取得
     * - もっともっとさらに、会員ログイン情報も取得
     * - 正式会員のときにログインした最終ログイン日時の降順、会員IDの昇順で並べる
     * - ログイン回数が指定された回数以上で絞り込み
     * - 仮会員のときにログインをしたことのある会員を検索
     * - 自分だけが購入している商品を買ったことのある会員を検索
     * - 購入は商品カテゴリ(*1)の親カテゴリ名称の昇順、子カテゴリ名称の昇順、購入日時の降順
     * - 会員ログイン情報はログイン日時の降順
     *
     * ## Assertions
     * - ログイン回数が 2 回より多い会員を検索し、結果がその通りであることをアサート
     * - 最終ログイン日時の降順と会員IDの昇順で並んでいることをアサート
     * - 支払済み購入の最大購入価格が妥当であることをアサート
     * - 仮会員のときにログインをしたことのある会員であることをアサート
     * - 自分だけが購入している商品を買ったことのある会員であることをアサート
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section11.html#onparadereferrer">DBFlute ハンズオンセクション11 - 子テーブルからみまくりの検索 </a>
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
     * - サービスランクごとの会員数、合計購入価格、平均最大購入価格(*1)、ログイン数を検索
     * - 紐付く会員とその会員に紐付く購入と会員ログインも取得する
     * - 会員数の多い順に並べる
     *
     * ## Assertions
     * - 会員数が妥当であることをアサート
     * - 検索した内容をログに綺麗に出して目視で確認すること
     *
     * ## Remarks
     * - (nullにならないようにすること)
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section11.html#onparadereferrer">DBFlute ハンズオンセクション11 - 子テーブルからみまくりの検索 </a>
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


    /**
     * ## Question
     * - ロジックのメソッド
     *
     * ## Requirements
     * - それぞれの会員の平均購入価格の会員全体での最大値を検索
     *
     * ## Assertions
     * - 平均の最大価格に該当する会員が存在することをアサート
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section11.html#onparadereferrer">DBFlute ハンズオンセクション11 - 子テーブルからみまくりの検索 </a>
     */
    @DisplayName("""対応テストメソッド""")
    @Test
    fun step5() = DB.begin {
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