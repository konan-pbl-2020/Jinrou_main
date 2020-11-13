package com.example.jinrou_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Touhyou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touhyou);

        Intent intentyt = getIntent();
        Yakuwari[] yaku_to = (Yakuwari[]) intentyt.getSerializableExtra("Yakuwari_main");
    }
}