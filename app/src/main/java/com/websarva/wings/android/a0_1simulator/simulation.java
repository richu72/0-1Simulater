package com.websarva.wings.android.a0_1simulator;

import android.content.Context;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class simulation implements Serializable {
    File file;

    int[] images = new int[12];
    int[] answers = new int[4096];
    int current_number;

    public simulation(File file_) {
        file = file_;
        current_number = 0;
        for (int i = 0; i < 12; i++) {
            images[i] = 0;
        }
    }

    public int[] getNextImages() {
        current_number++;
        calcImages();
        return images;
    }
    public void calcImages(){
        int d = current_number;
        for (int j = 0; j < 12; j++) {
            images[j] = d % 2;
            d /= 2;
        }
    }

    public void load_from_file() {
        String text = null;
        try (
                BufferedReader br = new BufferedReader(new FileReader(file))
        ) {
            while (true) {
                text = br.readLine();
                if (text == null) {
                    break;
                }
                String[] nums = text.split("\t");
                answers[current_number++] = Integer.parseInt(nums[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        calcImages();
    }
    public void save(){
        String str ="";
        for(int i=0;i< current_number;i++){
            str+=String.valueOf(i)+"\t"+String.valueOf(answers[i])+"\n";
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(str);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
