package jp.co.bizreach

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.time.*

class Section2 {

    /**
     * ## Question
     * - 会員名称がSで始まる1968年1月1日以前に生まれた会員を検索
     *
     * ## Requirements
     * - 会員ステータスも取得する
     * - 生年月日の昇順で並べる
     *
     * ## Remarks
     * - ※"以前" の解釈は、"その日ぴったりも含む" で。
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#cbsilver">DBFlute ハンズオンセクション03 - Silverストレッチ </a>
     */
    @DisplayName("""会員名称がSで始まる1968年1月1日以前に生まれた会員を検索""")
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

    /**
     * ## Question
     * - 会員ステータスと会員セキュリティ情報も取得して会員を検索
     *
     * ## Requirements
     * - 若い順で並べる。生年月日がない人は会員IDの昇順で並ぶようにする
     *
     * ## Remarks
     * - ※カージナリティを意識しましょう
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#cbsilver">DBFlute ハンズオンセクション03 - Silverストレッチ </a>
     */
    @DisplayName("""会員ステータスと会員セキュリティ情報も取得して会員を検索""")
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
     * - 会員セキュリティ情報のリマインダ質問で2という文字が含まれている会員を検索
     *
     * ## Requirements
     * - 会員セキュリティ情報のデータ自体は要らない
     * - Actでの検索は本番でも実行されることを想定し、テスト都合でパフォーマンス劣化させないこと
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#cbsilver">DBFlute ハンズオンセクション03 - Silverストレッチ </a>
     */
    @DisplayName("""会員セキュリティ情報のリマインダ質問で2という文字が含まれている会員を検索""")
    @Test
    fun step3() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select MEMBER.*
from MEMBER
        """.fetch()

        // Assert:
        assertStep3(results)
    }

    /**
     * ## Question
     * - 会員ステータスの表示順カラムで会員を並べて検索
     *
     * ## Requirements
     * - 会員ステータスの "表示順" カラムの昇順で並べる
     * - 会員ステータスのデータ自体は要らない
     * - その次には、会員の会員IDの降順で並べる
     * - 会員ステータスのデータが取れていないことをアサート
     * - 会員が会員ステータスごとに固まって並んでいることをアサート (順序は問わない)
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#cbgold">DBFlute ハンズオンセクション03 - Goldストレッチ </a>
     */
    @DisplayName("""会員ステータスの表示順カラムで会員を並べて検索""")
    @Test
    fun step4() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select MEMBER.*
from MEMBER
        """.fetch()

        // Assert:
        assertStep4(results)
    }

    /**
     * ## Question
     * - 生年月日が存在する会員の購入を検索
     *
     * ## Requirements
     * - 会員名称と会員ステータス名称と商品名を取得する
     * - 購入日時の降順、購入価格の降順、商品IDの昇順、会員IDの昇順で並べる
     * - OrderBy がたくさん追加されていることをログで目視確認すること
     * - 購入に紐づく会員の生年月日が存在することをアサート
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#cbgold">DBFlute ハンズオンセクション03 - Goldストレッチ </a>
     */
    @DisplayName("""生年月日が存在する会員の購入を検索""")
    @Test
    fun step5() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select PURCHASE.*
from PURCHASE
        """.fetch()

        // Assert:
        assertStep5(results)
    }

    /**
     * ## Question
     * - 2005年10月の1日から3日までに正式会員になった会員を検索
     *
     * ## Requirements
     * - 名前付きパラメーターを使用する
     * - 会員ステータスも一緒に取得
     * - ただし、会員ステータス名称だけ取得できればいい (説明や表示順カラムは不要)
     * - 会員名称に "vi" を含む会員を検索
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#cbgold">DBFlute ハンズオンセクション03 - Goldストレッチ </a>
     */
    @DisplayName("""2005年10月の1日から3日までに正式会員になった会員を検索""")
    @Test
    fun step6() = DB.begin {
        // Arrange:
        val fromParam = LocalDate.of(2005, 10, 1)
        val toParam = LocalDate.of(2005, 10, 4)

        // Act:
        // language=SQL
        val results = """
select MEMBER.*
from MEMBER 
where :from <= UPDATE_DATETIME
""".fetch("from" to fromParam)

        // Assert:
        assertStep6(results)
    }

    /**
     * ## Question
     * - 正式会員になってから一週間以内の購入を検索
     *
     * ## Requirements
     * - 商品カテゴリ、さらに上位の商品カテゴリも一緒に取得
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#cbplatinum">DBFlute ハンズオンセクション03 - Platinumストレッチ </a>
     */
    @DisplayName("""正式会員になってから一週間以内の購入を検索""")
    @Test
    fun step7() = DB.begin {
        // Arrange:

        // Act:
        // language=SQL
        val results = """
select PURCHASE.*
from PURCHASE
        """.fetch()

        // Assert:
        assertStep7(results)
    }

    /**
     * ## Question
     * - 1974年までに生まれた、もしくは不明の会員を検索
     *
     * ## Requirements
     * - 画面からの検索条件で1974年がリクエストされたと想定
     * - parameter の値を、名前付きパラメーターとして使って検索(SQLで日付の演算にTRY)
     * - 若い順だが生年月日が null のデータを最初に並べる
     *
     * ## Remarks
     * - 1974年12月31日生まれの人、1975年1月1日生まれの人。前者は検索に含まれて、後者は含まれない。
     *       テストデータに存在しない、もしくは、存在に依存するのがためらうほどのピンポイントのデータは、自分で作っちゃうというのも一つの手。
     * - ※今後、"きわどいデータ" を作ってアサートを確かなものにするかどうかは自分の判断で。
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#cbplatinum">DBFlute ハンズオンセクション03 - Platinumストレッチ </a>
     */
    @DisplayName("""1974年までに生まれた、もしくは不明の会員を検索""")
    @Test
    fun step8() = DB.begin {
        // Arrange:
        // language=SQL
        """
insert into MEMBER (MEMBER_NAME, MEMBER_ACCOUNT, MEMBER_STATUS_CODE, BIRTHDATE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO) 
values ('南壮一郎', 'swimmy', 'FML', '1976-09-09', current_date, 'manual:test', current_date, 'manual:test', 0) 
        """.execute()

        val parameter = LocalDate.of(1974, 1, 1)

        // Act:
        // language=SQL
        val results = """
select *
from MEMBER
where MEMBER_ACCOUNT = 'swimmy'
        """.fetch( /* "date" to parameter */)

        // Assert:
        assertStep8(results)
    }

    /**
     * ## Question
     * - 2005年6月に正式会員になった会員を先に並べて生年月日のない会員を検索
     *
     * ## Requirements
     * - 画面からの検索条件で2005年6月がリクエストされたと想定
     * - parameter の値を、名前付きパラメーターとして使って検索(SQLで日付の演算にTRY)
     * - 第二ソートキーは会員IDの降順
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#cbplatinum">DBFlute ハンズオンセクション03 - Platinumストレッチ </a>
     */
    @DisplayName("""2005年6月に正式会員になった会員を先に並べて生年月日のない会員を検索""")
    @Test
    fun step9() = DB.begin {
        // Arrange:
        val parameter = LocalDate.of(2005, 6, 1)

        // Act:
        // language=SQL
        val results = """
select *
from MEMBER
        """.fetch(/* "date" to parameter */)

        // Assert:
        assertStep9(results)
    }

    // ______________________________________________________
    //
    // @ Extra Stage

    /**
     * ## Question
     * - 全ての会員をページング検索
     *
     * ## Requirements
     * - 会員ステータス名称も取得
     * - 会員IDの昇順で並べる
     * - ページサイズは 3、ページ番号は 1 で検索すること
     * - 会員ID、会員名称、会員ステータス名称をログに出力
     * - SQLのログでカウント検索時と実データ検索時の違いを確認
     * - 総レコード件数が会員テーブルの全件であることをアサート
     * - 総ページ数が期待通りのページ数(計算で導出)であることをアサート
     * - 検索結果のページサイズ、ページ番号が指定されたものであることをアサート
     * - 検索結果が指定されたページサイズ分のデータだけであることをアサート
     * - PageRangeを 3 にして PageNumberList を取得し、[1, 2, 3, 4]であることをアサート
     * - 前のページが存在しないことをアサート
     * - 次のページが存在することをアサート
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#paging">DBFlute ハンズオンセクション03 - CBでページングしてみよう </a>
     */
    @Disabled
    @DisplayName("""全ての会員をページング検索""")
    @Test
    fun step10() = DB.begin {
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
     * - 会員ステータスの表示順カラムで会員を並べてカーソル検索
     *
     * ## Requirements
     * - 会員ステータスの "表示順" カラムの昇順で並べる
     * - 会員ステータスのデータも取得
     * - その次には、会員の会員IDの降順で並べる
     * - 会員ステータスが取れていることをアサート
     * - 会員が会員ステータスごとに固まって並んでいることをアサート
     * - 検索したデータをまるごとメモリ上に持ってはいけない
     * - (要は、検索結果レコード件数と同サイズのリストや配列の作成はダメ)
     *
     * ## Remarks
     * - ーーー
     *
     * @see <a href="http://dbflute.seasar.org/ja/tutorial/handson/section03.html#cursor">DBFlute ハンズオンセクション03 - CBでカーソル検索ってみよう </a>
     */
    @Disabled
    @DisplayName("""会員ステータスの表示順カラムで会員を並べてカーソル検索""")
    @Test
    fun step11() = DB.begin {
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

    // ______________________________________________________
    //
    // @ Assertions

    private fun assertStep1(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().reduce { prev, current ->
            current.also {
                it.shouldHaveMemberTable()
                    .shouldHaveMemberStatusTable()
                it.string("MEMBER_NAME").shouldStartsWith("S")
                it.date("BIRTHDATE")
                    .isBeforeEq(LocalDate.of(1968, 1, 1))
                    .isAfterEq(prev.date("BIRTHDATE").value!!)
            }
        }
    }

    private fun assertStep2(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().reduce { prev, current ->
            current.also {
                it.shouldHaveMemberTable()
                    .shouldHaveMemberStatusTable()
                    .shouldHaveMemberSecurityTable()
                if (it.date("BIRTHDATE").value != null) {
                    it.date("BIRTHDATE").isBeforeEq(prev.date("BIRTHDATE").value!!)
                }
            }
        }
    }

    private fun assertStep3(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().forEach { result ->
            result.shouldHaveMemberTable()
            result.string("MEMBER_NAME").notNull()
            result.string("REMINDER_QUESTION").notNull()
            result.string("REMINDER_QUESTION").contains("2")
        }
    }

    private fun assertStep4(results: List<Map<String, Any>>) {
        val history = linkedSetOf(results[0].string("MEMBER_STATUS_CODE").value!!)
        results.forEach { result ->
            result.shouldHaveMemberTable()
            result.shouldNotHaveColumn("MEMBER_STATUS_NAME")
            result.shouldNotHaveColumn("DESCRIPTION")

            if (history.last() != result.string("MEMBER_STATUS_CODE").value!!) {
                if (history.add(result.string("MEMBER_STATUS_CODE").value!!).not()) {
                    throw AssertionError("illegal order")
                }
            }
        }
    }

    private fun assertStep5(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().forEach { result ->
            result.shouldHavePurchaseTable()
            result.string("MEMBER_NAME").notNull()
            result.string("MEMBER_STATUS_NAME").notNull()
            result.string("PRODUCT_NAME").notNull()
            result.date("BIRTHDATE").notNull()
        }
    }

    private fun assertStep6(results: List<Map<String, Any>>) {
        val fromParam = LocalDate.of(2005, 10, 1)
        val toParam = LocalDate.of(2005, 10, 3)

        assertEquals(results.size, 1)
        results.forEach { result ->
            result.shouldHaveMemberTable()
            result.string("MEMBER_NAME").contains("vi")
            result.string("MEMBER_STATUS_NAME").notNull()
            result.datetime("FORMALIZED_DATETIME").notNull()
            result.datetime("FORMALIZED_DATETIME")
                .isAfter(fromParam.atStartOfDay())
                .isBefore(toParam.plusDays(1).atStartOfDay())
        }
    }

    private fun assertStep7(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().forEach { result ->
            result.shouldHavePurchaseTable()
            result.int("MEMBER_ID").notNull()
            result.string("CHILD_CATEGORY_CODE").notNull()
            result.string("PARENT_CATEGORY_CODE").notNull()
            result.string("CHILD_CATEGORY_NAME").notNull()
            result.string("PARENT_CATEGORY_NAME").notNull()
            val sub = "select FORMALIZED_DATETIME from MEMBER where MEMBER_ID = :id".fetch("id" to result.int("MEMBER_ID").value!!).first()
            result.datetime("PURCHASE_DATETIME")
                .isAfter(sub.datetime("FORMALIZED_DATETIME").value!!)
                .isBefore(sub.datetime("FORMALIZED_DATETIME").value!!.plusDays(7))
        }
    }

    private fun assertStep8(results: List<Map<String, Any>>) {
        results.shouldNotEmpty().forEach { result ->
            result.shouldHaveMemberTable()
            result.date("BIRTHDATE").let {
                if (it.value != null)
                    it.isBefore(LocalDate.of(1975, 1, 1))
            }
        }
    }

    private fun assertStep9(results: List<Map<String, Any>>) {
        val parameter = LocalDate.of(2005, 6, 1)

        var isInFirstBlock = true
        val isInMonth = { r: Map<String, Any> ->
            r.datetime("FORMALIZED_DATETIME").value?.let {
                val from = parameter.atStartOfDay()
                val to = parameter.plusMonths(1).withDayOfMonth(1).atStartOfDay()
                it.isAfter(from).and(it.isBefore(to))
            } ?: false
        }
        results.shouldNotEmpty().forEach { result ->
            result.shouldHaveMemberTable()
            result.date("BIRTHDATE").isNull()
            if (isInMonth(result)) {
                assertTrue(isInFirstBlock, "FORMALIZED_DATETIME")
            } else {
                isInFirstBlock = false
            }
        }
    }
}