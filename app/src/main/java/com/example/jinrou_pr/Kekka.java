package com.example.jinrou_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Kekka extends AppCompatActivity {
    Yakuwari yaku_kettei[] = Kakunin.yaku_main;
    int sisya = Touhyou.max_id;
    int Ke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kekka);

        TextView text_ban = (TextView)findViewById(R.id.textView_ke);
        int k = yaku_kettei[sisya].yaku;

        if(k == 1){
            text_ban.setText("村人の勝利です");
        }else{
            text_ban.setText("人狼の勝利です");
        }
        Button button = (Button)findViewById(R.id.button_km);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentrs = new Intent(Kekka.this,MainActivity.class);
                startActivity(intentrs);
            }
        });
    }
}