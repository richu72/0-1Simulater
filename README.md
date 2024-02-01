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
layoutのactivity_end.xml画面に移行する
### MainActivity
アプリ起動時に行われる動作
```
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        String fileName = "TestFile.txt";
        File file = new File(context.getFilesDir(), fileName);
        sm=new simulation(file);
    }
```
### menu
### simulation
### simulator
### YesNoDialog

## Android studioについて
### JavaからKotlinへ
Android studioではkotlinの拡張ファイルであるktで、javaのコードをコピペすると自動でkotlinの形式に変更される.
