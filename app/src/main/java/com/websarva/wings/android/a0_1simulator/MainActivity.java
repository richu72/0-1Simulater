package com.websarva.wings.android.a0_1simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    simulation sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        String fileName = "TestFile.txt";
        File file = new File(context.getFilesDir(), fileName);
        sm=new simulation(file);
    }
    public void start (View v) {
        Intent intent = new Intent(this, simulator.class);//開く画面

        intent.putExtra("sm", sm);//入力データをセット
        startActivity(intent);//イベントハンドラ
    }

    public void from_cont (View v) {
        Intent intent = new Intent(this, simulator.class);//開く画面
        sm.load_from_file();

        intent.putExtra("sm", sm);//入力データをセット
        startActivity(intent);//イベントハンドラ
    }

    public void setting (View v) {
        Intent intent = new Intent(this, menu.class);//開く画面
        startActivity(intent);//イベントハンドラ
    }
}