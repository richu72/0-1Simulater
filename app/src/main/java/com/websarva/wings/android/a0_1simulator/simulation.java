package com.websarva.wings.android.a0_1simulator;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        int d = current_number;
        for (int j = 0; j < 12; j++) {
            images[j] = d % 2;
            d /= 2;
        }
        return images;
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
    }
}