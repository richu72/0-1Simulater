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

        setImages(sm.images);

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
        setImages(images);

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
    public  void setImages(int[] images){
        if(images[0]==0){
            ImageView by = findViewById(R.id.imageView1);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView1);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[1]==0){
            ImageView by = findViewById(R.id.imageView2);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView2);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[2]==0){
            ImageView by = findViewById(R.id.imageView3);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView3);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[3]==0){
            ImageView by = findViewById(R.id.imageView4);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView4);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[4]==0){
            ImageView by = findViewById(R.id.imageView5);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView5);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[5]==0){
            ImageView by = findViewById(R.id.imageView6);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView6);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[6]==0){
            ImageView by = findViewById(R.id.imageView7);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView7);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[7]==0){
            ImageView by = findViewById(R.id.imageView8);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView8);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[8]==0){
            ImageView by = findViewById(R.id.imageView9);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView9);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[9]==0){
            ImageView by = findViewById(R.id.imageView10);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView10);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[10]==0){
            ImageView by = findViewById(R.id.imageView11);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView11);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
        if(images[11]==0){
            ImageView by = findViewById(R.id.imageView12);
            by.setBackgroundColor(Color.rgb(0xff, 0xff,0xff));
        }
        else{
            ImageView by = findViewById(R.id.imageView12);
            by.setBackgroundColor(Color.rgb(0x00, 0x00,0x00));
        }
    }
}