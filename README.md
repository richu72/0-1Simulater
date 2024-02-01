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
        sm=new simulation(file);
    }
```
1.layout.activity_mainを立ち上げる    
2.アプリケーションの情報を取得し、```Context context``` に渡すことで画像等へのアクセスを可能にする    
3.File型オブジェクトを作成し、アプリの内部ストレージに```TestFile.txt```という名前のファイルを表しています。

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
### simulator
```layout.activity_smulator.xml``` に初期化の状態で、移行する
### YesNoDialog

## Android studioについて
### JavaからKotlinへ
Android studioではkotlinの拡張ファイルであるktで、javaのコードをコピペすると自動でkotlinの形式に変更される.
