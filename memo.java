- JDK（Open JDK）
JDKとはJava Development Kitの略で、その中には実行環境であるJREや
JAVAを動作させるための仮想マシンであるJVMも含まれる。

- JRE
JREとはJava Runtime Environmentの略

- JVM
Java Virtual Machineの略


Javaのファイルの拡張子は.javaで、そのままだと動作しないので
コンパイルする必要がある。

コンパイル後の拡張子が.classで、.classファイルであればJRE上で動作させることができる。

Javaでは一度コードを書けばどの環境でも動作するということを目指して、WindowsやMacなど他の環境でもJREさえ用意できれば
.classファイルをコピーして動作させることができる。 - "Write once, run anywhere"

-------------------------------------------------

$ javac [ファイル名].javaでコンパイル
    ↓
.classファイルができる
    ↓
java [ファイル名]で実行

-------------------------------------------------

- 変数
変数を使うには必ず宣言が必要
宣言するにはそこに入れるデータの型と変数名を書く

例) String msg;
    msg = "hello world";

    上記の宣言は以下のように書くこともできる

    String msg = "hello world";

-------------------------------------------------

- さまざまなデータ型

・文字列 - String
  例)  String msg = "hello world"; //ダブルクォーテーションで囲む


・単数文字 - char
  例)  char a = 'a'; //シングルクォーテーションで囲む


・整数 - byte short int long //全て整数(右に行くほど桁が大きい ※通常はintを使う)
  例)  int x = 10;
       long y = 555555555555L; //longの場合のみ末尾にLをつける(小文字でも構わないが大文字が慣習)


・浮動小数点数 - float double //通常は扱える桁数の大きいdoubleを使う
  例)  double d = 23423.344;
       float f = 32.33F; //floatの場合のみ末尾にFをつける(小文字でも構わないが大文字が慣習)


・論理値(真偽値) - boolean
  例)  boolean flag = true;

・特殊文字 - (\n = 改行,  \t = タブ)
  例)  String msg = "hello wo\nrld again\t!";
           ↓
       hello wo
       rld again       !
   といったように出力される

  ===========================
    public class MyApp {
      public static void main(String[] args) {

        String msg = "hello world again!";
        System.out.println(msg);

        String message = "hello wo\nrld again\t!";
        System.out.println(message);
      }
    }
  ===========================

-------------------------------------------------

 - 演算
 - 四則演算
 -> + - * / %
 => ++(1を足す) --(1を引く)

 ===========================
    public class MyApp {
      public static void main(String[] args) {

        int i; //intはあくまでも整数型なので10を3で割っても小数点以下は切り捨てられて3が返ってくる
        i = 10 / 3;
        System.out.println(i); //=3

        i = 10 % 3; //%はあまりを返す
        System.out.println(i); //=1

        int x = 5;
        x++; //++は1を足すなので今回は6
        System.out.println(x); //=6

        x--; //--は1を引くなので上で足された1を再度引いて今回は5が返ってくる
        System.out.println(x); //=5
      }
    }
  ===========================

 - 代入を伴う演算子

  ===========================
    public class MyApp {
      public static void main(String[] args) {

        int x = 5;
        // x = x + 12; //よくある処理だが、下記のようなより短い書き方が用意されている

        x += 12; //もちろん+以外にも*など他の記号にも使用できる
        System.out.println(x);
      }
    }
  ===========================

 - 文字列の連結

  ===========================
      public class MyApp {
        public static void main(String[] args) {

          String s;
          s = "hello" + "world";
          System.out.println(s);
        }
      }
  ===========================

-------------------------------------------------

 - データ型の変換
    以下のような他のデータ型への変換を「キャストする」という

  ===========================
  public class MyApp {
    public static void main(String[] args) {

      double d = 52343.231;
      // int i = d; //型の違うデータを代入したい場合は以下のように明示的に変換したい型を記載する必要がある
      int i = (int)d;

      System.out.println(i); //52343
    }
  }
  ===========================

 - よくある間違い

  ===========================
  public class MyApp {
    public static void main(String[] args) {

      int i = 10;
      // double d = i / 4; //i / 4が計算された時点ではiは整数型なので整数の10を4で割っても
                        //小数点以下が切り捨てられた2が返り、dに代入されるのは2.0であるため
      //System.out.println(d); //この場合は2.5ではなく2.0が返される

      double d = (double)i /4; //このように2.5を返してほしい場合はiの前に
                               //明示的に変換する型である(double)を記述する必用がある
      System.out.println(d); //2.5
    }
  }
  ===========================

-------------------------------------------------

 - ifによる条件分岐

 if / else if/ elseによって条件を分岐させて処理させることができる。
 その際に下記のような比較演算子、論理演算子を用いる

 比較演算子 =>  > >= < <= == != //より大きい、以上、未満、以下、等しい、等しくない
 論理演算子 =>  && || ! //and , or , not

   ===========================
   public class MyApp {
    public static void main(String[] args) {

      score = 90;
      if (score > 85) {
        System.out.println("great!");
      } else if (score > 70) {
        System.out.println("good!");
      } else {
        System.out.println("so so...");
      }

    }
   }
   ===========================

 - 条件演算子
   ?で真偽値を返し、偽であるなら:以降の処理に誘導する

   ===========================
   public class MyApp {
    public static void main(String[] args) {

      score = 90;
      String msg = score > 80 ? "Great!" : "so so...";
      System.out.println(msg); //Great!
    }
   }
   ===========================

-------------------------------------------------

 - switch文
   変数が取り得る値が既に決まっていて、それに対して処理を振り分けたい時に使う

   ===========================
   public class MyApp {
     public static void main(String[] args) {

       String signal = "red"; //signal変数に入る値
       switch (signal) { //signalの中身によって処理をcase文で振り分ける
          case "red":
            System.out.println("stop!");
            break; //breakがないとそこで処理が止まらず、不要な処理までされてしまう
          case "blue":
            System.out.println("go!");
            break;
          case "yellow":
            System.out.println("caution!");
            break;
          default:
            System.out.println("wrong signal!");
            break;
       }

     }
   }
   ===========================

-------------------------------------------------

 - while文で繰り返し処理

   ===========================
    public class MyApp {
      public static void main(String[] args) {

        int i = 0; //0で初期化
        while (i < 10) { //括弧内で処理を続ける条件を記述
          System.out.println(i);
          i++; //1ずつ増やす(++や--などを単項演算子と呼ぶ。)
        }

      }
    }
   ===========================

 - do while文で繰り返し処理
    条件を後ろに書く

    ===========================
    public class MyApp {
      public static void main(String[] args) {

        int i = 0;
        do {
          System.out.println(i);
          i++;
        } while (i < 10);

      }
    }
   ===========================

 - do whileとwhileの違い
 do whileは条件が後に来るため
 最初にiに条件から逸脱している値が入っていたとしても
 一回は処理が実行される。

 対してwhileはまず条件を満たさないと処理がされないので
 条件から逸脱していると一回も実行されない。

 -------------------------------------------------

  - for文
  指定した回数分処理を実行させる

   ===========================
   public class MyApp {
     public static void main(String[] args) {

       for (int i = 0; i < 10; i++) { //括弧内に最初にループが始まる前の初期化処理と
          System.out.println(i);      //ループが続く条件、ループが終わるごとにさせたい処理を書く
       }

     }
   }
   ===========================

 - break
  処理を中断させたい時に使う

   ===========================
   public class MyApp {
     public static void main(String[] args) {

       for (int i = 0; i < 10; i++) {

         if (i == 5) { //for文中でiが5と等しくなる時、処理を中断する
           break;
         }

         System.out.println(i);
       }

     }
   }
   ===========================

 - continue
  処理をスキップさせたい時に使う

   ===========================
   public class MyApp {
     public static void main(String[] args) {

       for (int i = 0; i < 10; i++) {

         if (i == 5) { //for文中でiが5と等しくなる時、処理をスキップする
           continue;   //つまり表示されるのは5以外の0〜9の数全て
         }

         System.out.println(i);
       }

     }
   }
   ===========================

 -------------------------------------------------

 - 配列
   複数のデータをまとめて管理するのに有用

  ===========================
  public class MyApp {
    public static void main(String[] args) {

      int[] sales; //配列の宣言は変数と同様データ型と変数名を記述。
                   //ただし配列であることを示すために[]を型のあとに書く。
      sales = new int[3]; //宣言後、データ領域を確保するためnewを使う。
                           //intを三つ確保するには[]に3を入れる
      sales[0] = 100;//そうすることで左のようなsales[0]のような変数を使うことができる。
      sales[1] = 200; //[]内の数字を添字(そえじ)やインデックスと呼ぶ
      sales[2] = 300;
      System.out.println(sales[1]); //200 変数名と添字を一緒に()に入れれば使用することができる

      sales[1] = 1000; //変数の上書きもできる
      System.out.println(sales[1]); //1000

    }
  }
  ===========================

 - 配列をまとめて初期化

  ===========================
  public class MyApp {
    public static void main(String[] args) {

      int[] sales;
      sales = new int[] {100, 200, 300}; //{}内で値は3個とわかりきっているので
                                         //[]は空白で良い
      System.out.println(sales[2]);

    }
  }

 - もしくは,以下のように宣言から値の初期化までを省略して記述することもできる

  public class MyApp {
    public static void main(String[] args) {

      int[] sales = {100, 200, 300};
      System.out.println(sales[2]);

    }
  }
  ===========================

-------------------------------------------------

 - 配列の要素を操作

以下のようなfor文との連携が多い
  ===========================
  public class MyApp {
    public static void main(String[] args) {

      int[] sales = {700, 400, 500};

      for (int i = 0; i > 3; i++) {
        System.out.pritnln(sales[i]); //iは3より大きくなるまで回数を繰り返す
      }

    }
  }
  ===========================

 - length
  もしくは以下のような記述で配列の個数をlengthで取得することもできる

  ===========================
  public class MyApp {
    public static void main(String[] args) {

      int[] sales = {700, 400, 500};

      for (int i = 0; i < sales.length; i++) { //sales.lengthで配列内の個数を取得
        System.out.println(sales[i]);
      }

    }
  }
  ===========================

  for文を使った別の方法

  ===========================
  public class MyApp {
    public static void main(String[] args) {

      int[] sales = {700, 400, 500};

      for (int sale : sales) { //salesの配列の中から一つずつ取り出し、int型のseleに代入しなさい
        System.out.println(sale); //配列の要素がなくなるまでその処理を実行し続けなさいの意
      }                           //右のsalesが左のint saleに代入されている
    }
  }
  ===========================

-------------------------------------------------

 - データ型とメモリの関係

 データ型は8種類の基本データ型とそれ以外の参照型に分かれる

 |基本データ型(プリミティブ型)|
 ・byte, short, int, long,
 ・float, double,
 ・boolean,
 ・char

 |参照型|
 ・String(代表的なもの)
 ・Array (int[])
 ・Class
 …など

 プログラムはコンピューターのメモリ上に展開される。
 メモリとは番地のついた連続した領域になっており、
 そこにデータを置くことでさまざまな計算ができるようになっている。

【基本データ型】
  - 例) int i;
 上記を例に変数は宣言するとメモリ上にint構造を格納する領域を確保し、
 そこに対してiというラベルが貼られる。
 領域の大きさはデータ型によって決まっていて、intならこれくらい
 longならこれくらいと決まっている。

 そのあとに i = 10;とするとiのラベルがついた領域に10という値が格納される

【参照型】
 - 例) int[] a;
       a = new int[] {3, 5, 7};
上記のint[] a;の時点では配列にいくつ要素が入るかわからないため
一旦番地のみ入れられるように領域が確保され、まずaと名前だけつけられる

そして離れた場所に実際の値は格納され、aにはその値の先頭の番地が入る。
つまり、基本データ型はデータそのものがメモリに入るのに対し、
参照型にはデータが入っている箇所の番地がメモリに入る

-------------------------------------------------

 - 基本データ型と参照型を理解する

【基本データ型】
  ===========================
  public class MyApp {
    public static void main(String[] args) {

      int x = 10;
      int y = x;
      y = 5;

      System.out.println(x); //10
      System.out.println(y); //5

    }
  }
  ===========================

【参照型】
  ===========================
  public class MyApp {
    public static void main(String[] args) {

      int[] a = {3, 5, 7};
      int[] b = a; //この時点でbにはaのメモリ上の番地が格納される
      b[1] = 8; //そのためbの値を変えるということはaの値を変えるということでもある

      System.out.println(a[1]); //8 だからa[1]とb[1]は同じ値になる
      System.out.println(b[1]); //8

    }
  }
  ===========================

  public class MyApp {
    public static void main(String[] args) {

      String s = "hello";
      String t = s;
      t = "world";

      /*上記の例から参照型のデータ時は変数の中身を上書きすると、
      番地を上書きして同じ内容になってしまうと考えがちだが、
      string型に関しては文字列の変更は基本的にできないので
      違う文字列が割り当てられると別の領域に新しくデータを確保するため
      以下はworld worldではなく、hello worldが表示される*/

      System.out.println(s); //hello
      System.out.println(t); //world

    }
  }

  ===========================

-------------------------------------------------

 - メソッド
 実は定型文となっているpublic static void mainはmainメソッドのこと

  ===========================
  public class MyApp {
    public static void sayHi() { //メソッド名の後ろには()が必用
      System.out.println("Hi!");
    }

    public static void main(String[] args) {
      sayHi(); // Hi!
    }
  }
  ===========================

 - メソッドにはオプションを渡すこともできる
 =>sayHi() //括弧内に記述する

  ===========================
  public class MyApp {
    public static void sayHi(String name) { //変数のオプションをStringで渡しているので
      System.out.println("Hi! " + name);    //受け取る側もStringを指定 + 格納する変数名(今回はname)
    }

    public static void main(String[] args) {
      sayHi("Tom");
      sayHi("Bob");
    }
  }
  ===========================

 - メソッドに値を返してほしい場合

  ===========================
  public class MyApp {
    public static String sayHi(String name) { //voidではなく返してほしいデータ型を記述
                                              //ちなみにvoidは何も返さないという意味
      return "Hi! " + name; //返してほしい内容を記述
    }

    public static void main(String[] args) {
      String msg = sayHi("Steve");
      System.out.println(msg); //Hi! Steve
    }
  }
  ===========================

-------------------------------------------------

 - メソッド内での変数の有効範囲

  ===========================
  public class MyApp {

    public static void sayHi(String name) {
      int x = 10; //この行のxや下記のnameという変数はこのsayHiメソッド内でのみ使用できる
      System.out.println("Hi! " + name);
    }

    public static void main(String[] args) {
      sayHi("Steve"); //()内の値を引数と呼ぶ
      System.out.println(x); //エラー(変数が扱える範囲外であるため)
      System.out.println(name); //エラー(変数が扱える範囲外であるため)
    }

  }
  ===========================

 - メソッドのオーバーロード
  メソッドの引数は引数の型や個数が違えば同じ名前で何個でも作れる
  (今回はsayHiメソッドを複製して試す)

  ===========================
  public class MyApp {

    //引数あり
    public static void sayHi(String name) {
      System.out.println("Hi! " + name);
    }

    //引数なし
    public static void sayHi() { //上記と違い引数がない場合
      System.out.println("Hi! Nobody!"); //その場合表示する内容
    }

    public static void main(String[] args) {
      sayHi("Steve"); //Hi! Steve
      sayHi(); //Hi! Nobody!
    }

  }
  ===========================

-------------------------------------------------

 - クラス①
 より複雑なデータ型を使いたい場合など
 =>ユーザーに関するデータ型が欲しかった場合、classを使ってデータ型を作れば
   User tom;のように宣言ができるようになる

 =>さらに、classには変数とメソッドを持たせることができるので
   「System.out.println(tom.name);」というようにクラスが持つ変数の値を表示したり、
   「tom.sayHi();」としてtomのクラスが持つメソッドを実行したりできる。

  ===========================
  class User {
    String name = "Me!"; //Userクラスの変数。とりあえずMeで初期化
                        //クラスに属する変数を"フィールド"と呼ぶ
    void sayHi() { //Userクラスが持つメソッド
      System.out.println("hi!");
    }
  }

  public class MyApp {

    public static void main(String[] args) {
      User tom; //classも参照型のため、宣言しただけではメモリ領域にデータは作らない
      tom = new User(); //なので実際に領域にデータを置くには配列同様newする必要がある
                        //newするとそのclassがもつ変数やメソッドを持った領域を確保して
                        //tomにはその領域の番地が格納される。
                        //newして領域を確保することをインスタンスを作るという
                        //実際に作られたtomはUserクラスのインスタンスと呼ぶ
      System.out.println(tom.name);
      tom.sayHi();
    }

  }
  ===========================

-------------------------------------------------

 - クラス②
  - コンストラクタ
  クラスがインスタンス化される時に必ず呼ばれる特殊なメソッド

  ===========================
  class User {
    // String name = "Me!"; //もう初期化する必要がなくなる
    String name;

    //コンストラクタ
    User(String name) { //コンストラクタ(クラスと同じ名前で作ったメソッド)
      this.name = name; //Userクラスのnameフィールドに設定するため
    }                   //メソッド内からクラスのフィールドにthisを使ってアクセスさせる

    //引数なしでインスタンス化された場合のコンストラクタ(メソッドのオーバーロード)
    User() {
      // this.name = "Me!";
      this("Me!");
    }

    void sayHi() {
      System.out.println("hi! " + this.name); //メソッド内からクラスのフィールドにアクセスする為
    }                                         //ここでもthisを
  }

  public class MyApp {
    public static void main(String[] args) {
      User tom;
      tom = new User("Tom"); //インスタンス化される時に名前を渡す
      tom = new User(); //インスタンス化される時に名前を渡さない場合

      System.out.println(tom.name);
      tom.sayHi();
    }
  }
  ===========================

-------------------------------------------------

 - クラス③
 クラスの継承


  ===========================
  //継承元のクラスを親クラス、もしくはスーパークラスという
  class User {
    String name;

    //今回は親クラスのコンストラクタに引数があるため、
    //子クラスのコンストラクタにも同じ引数を渡す
    User(String name) {
      this.name = name;
    }

    void sayHi() {
      System.out.println("hi! " + this.name);
    }
  }

  //継承するクラスを子クラスまたはサブクラスという
  class AdminUser extends User { //extendsで指定したクラスの継承ができる
                          //継承したことでAdminUserクラスがUserクラスのメソッドや変数を使えるようになる
    //コンストラクタ
    AdminUser(String name) {
    //コンストラクタを作ると自動的に親クラスのコンストラクタが呼ばれる
    //親クラスのコンストラクタはsuper();という特殊なメソッドで、
    //親クラスのコンストラクタに引数がなければこれを省略することもできる
    super(name);
    }

    void sayHello() {
      System.out.println("hello! " + this.name);
    }

    //メソッドのオーバーライド
    @Override //アノテーション(オーバーライドしていることを明示的に示せるので、
              //メソッド名を間違えていたり引数を間違えているとエラーにしてくれる)
    void syHi() {
      System.out.println("[admin] hi! " + this.name);
    }
  }

  public class MyApp {
    public static void main(String[] args) {
      User tom = new User("tom"); //クラスの宣言とインスタンス化はこのように1行で書くこともできる
      System.out.println(tom.name);
      tom.sayHi();

      AdminUser bob = new AdminUser("bob");
      System.out.println(bob.name);
      bob.sayHi();
      bob.sayHello();
    }
  }
  ===========================

-------------------------------------------------

 - パッケージとアクセス権の理解
  --パッケージ=> 関連するクラスをまとめたり名前の衝突を避けられる
              -> パッケージの名前は他の人と被らないほうがいいので
              -> 組織のドメインを逆にしたものを使うことが推奨される

              　※詳細はドットインストールのJava8入門の#21を参照

-------------------------------------------------