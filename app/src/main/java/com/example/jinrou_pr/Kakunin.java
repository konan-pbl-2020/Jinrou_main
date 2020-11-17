package com.example.jinrou_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Kakunin extends AppCompatActivity {
    public static Yakuwari yaku_main[];
    public static int pointa_i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pointa_i = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakunin);

        TextView textViewkaku = (TextView)findViewById(R.id.textView_kaku);
        textViewkaku.setText(Ninzyu.num+"人ですね？");

        yaku_main =  kettei();

        Button buttonkaku = (Button)findViewById(R.id.button_kaku);
        buttonkaku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentky = new Intent(Kakunin.this,YourTurn.class);
                startActivity(intentky);
            }
        });

        Button buttonkn = (Button)findViewById(R.id.button_modo);
        buttonkn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentkn = new Intent(Kakunin.this,Ninzyu.class);
                startActivity(intentkn);
            }
        });
    }

    public Yakuwari[] kettei(){

        int i;
        int num1 = Ninzyu.num;
        int d;
        //int sent_d[] = new int[1000];


        Yakuwari[] yaku_k = new Yakuwari[num1];
        ArrayList<Integer> list = new ArrayList<Integer>();

        // listに値を入れる。この段階では昇順
        for(i = 0 ; i < num1 ; i++) {
            list.add(i);
        }

        // シャッフルして、順番を変える
        Collections.shuffle(list);

        for(i = 0;i<num1;i++) {
            d = list.get(i) % 6;
            if(d <=2){
                d = 0;
            }else if(d == 3){
                d = 1;
            }else  if(d >= 4){
                d = 2;
            }
            //    sent_d[i] = d;
            yaku_k[i] = new Yakuwari(i,d,0);
        }
        //Intent intentyk = new Intent(YourTurn.this,Touhyou.class);
        //intentyk.putExtra("Data",sent_d);
        return yaku_k;

    }
}