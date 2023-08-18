package com.websarva.wings.android.a0_1simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class simulator extends AppCompatActivity {

    simulation sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_smulator);

        Intent intent = getIntent();
        sm = (simulation) intent.getSerializableExtra("sm");


        TextView tv = findViewById(R.id.tvQuestionNo);
        tv.setText("問題 "+String.valueOf(sm.current_number));

        ImageView i1 = findViewById(R.id.imageView1);
        i1.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i2 = findViewById(R.id.imageView2);
        i2.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i3 = findViewById(R.id.imageView3);
        i3.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i4 = findViewById(R.id.imageView4);
        i4.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i5 = findViewById(R.id.imageView5);
        i5.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i6 = findViewById(R.id.imageView6);
        i6.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i7 = findViewById(R.id.imageView7);
        i7.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i8 = findViewById(R.id.imageView8);
        i8.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i9 = findViewById(R.id.imageView9);
        i9.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i10 = findViewById(R.id.imageView10);
        i10.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i11 = findViewById(R.id.imageView11);
        i11.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        ImageView i12 = findViewById(R.id.imageView12);
        i12.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
    }
    public void back (View v) {
        Intent intent = new Intent(this,MainActivity.class);//開く画面
        startActivity(intent);//イベントハンドラ
    }

    public void answer (View v) {
        Button b =(Button) v;
        if(b.getText().equals("0")){
            sm.answers[sm.current_number]=0;
        }
        else if (b.getText().equals("1")) {
            sm.answers[sm.current_number]=1;
        }
        else if (b.getText().equals("分からない")) {
            sm.answers[sm.current_number]=-1;
        }

        if(sm.current_number==4095){
            //end//終わった画面に遷移する
        }
        int[] images = sm.getNextImages();
        TextView tv = findViewById(R.id.tvQuestionNo);
        tv.setText("問題 "+String.valueOf(sm.current_number));

        if(images[0]==0){
            ImageView by = findViewById(R.id.imageView1);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else if(images[1]==0){
            ImageView by = findViewById(R.id.imageView2);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView1);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        for(int i=0;i<12;i++){
            System.out.println(images[i]);
        }
    }

    public void saveTemporarily(View view){
        String str ="";
        for(int i=0;i< sm.current_number;i++){
            str+=String.valueOf(i)+"\t"+String.valueOf(sm.answers[i])+"\n";
        }
        try (FileWriter writer = new FileWriter(sm.file)) {
            writer.write(str);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}