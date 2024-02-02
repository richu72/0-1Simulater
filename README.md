# 0-1Simulater
## アプリの使い方
### メイン画面
#### スタートButton
シミュレーション画面にジャンプ  
＊間違えて押した場合は、シミュレーション画面の"戻る"を押すこと
#### 続きからButton
シミュレーション画面で一時保存したところからスタート
#### 設定Button
今は未完成
### シミュレーション画面
#### 一時保存Button
一時保存する
#### 戻るButoon
ひとつ前に戻る。問題が０の場合はメイン画面に戻る
#### 0~9,分からないButton
画像を見て、最も適しているボタンを押す
### 終了画面
4096問解き終わると現れる。お疲れ様です。
## コード内容
### end
```layout.activity_end.xml``` 画面に移行する
### MainActivity
アプリ起動時に行われる動作
#### protected void onCreate(Bundle savedInstanceState)
```
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//1

        Context context = getApplicationContext();//2
        String fileName = "TestFile.txt";
        File file = new File(context.getFilesDir(), fileName);//3
        //File file = new File(context.getExternalFilesDir(null), fileName);//*
        sm=new simulation(file);
    }
```
1.layout.activity_mainを立ち上げる    
2.アプリケーションの情報を取得し、```Context context``` に渡すことで画像等へのアクセスを可能にする    
3.File型オブジェクトを作成し、アプリの内部ストレージに```TestFile.txt```という名前のファイルを作成
*android studioがバージョンアップしたせいなのか、3ではファイルの生成がされなくなりました。
ですので、ver.2023.1ではこちらを使っています。

#### public void start (View v)
simulatorクラスを実行する

#### public void from_cont (View v)
前回一時保存したfileを呼び出し、simulatorクラスを実行する
```sm.load_from_file()```で前回保存したファイルを読み込んでいる

#### public void setting (View v)
menuクラスを実行する

### menu
```layout.activity_menu.xml``` に移行する
それ以外の機能は未完成

### simulation
dataの処理で扱う関数をまとめている    
各クラスでsmとして用いている
#### 変数
```
File file;//新しく書き込むファイル

    int[] images = new int[12];//白黒画像の各配列
    int[] answers = new int[4096];//それぞれの回答を保存する配列
    int current_number;//問題の数を表す変数
```
#### public simulation(File file_)
```file_```を新しくする    
初期化し、すべての画像を白にする

#### public int[] getNextImages()
二進数の処理を呼び出し、それに合わせた画像を返す

#### public void calcImages()
二進数の処理

#### public void load_from_file()
```
public void load_from_file() {
    String text = null;
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        while (true) {
            text = br.readLine();
            if (text == null) {
                break;
            }
            String[] nums = text.split("\t");
            answers[current_number++] = Integer.parseInt(nums[1]);
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    calcImages();
}
```
#### public void save()
### simulator
```layout.activity_smulator.xml``` に初期化の状態で、移行する    
```layout.activity_smulator.xml``` での各buttonが押されたときに画面が切り替わるcode
### YesNoDialog
アプリ作成時にどこからのサイトから取り出してきた    
詳細は不明で、このアプリには使用されていない
## Android studioについて
### JavaからKotlinへ
Android studioではkotlinの拡張ファイルであるktで、javaのコードをコピペすると自動でkotlinの形式に変更される.
