package com.example.jinrou_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collections;

public class YourTurn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_turn);

        Yakuwari yaku_main[] = kettei();
        Intent intentyt = new Intent(YourTurn.this,Touhyou.class);
        intentyt.putExtra("Yakuwari_main",yaku_main);
        hyouzi(yaku_main,0,0);


    }
    public int get_num(){
        Intent intentyn = getIntent();

        int g_num = intentyn.getIntExtra("Data_num",0);
        return g_num;
    }

    public Yakuwari[] kettei(){

        int i;
        int num1 = get_num();
        int d;
        //int sent_d[] = new int[1000];


        Yakuwari[] yaku_k = new Yakuwari[num1];
        ArrayList<Integer> list = new ArrayList<Integer>();

        // listに値を入れる。この段階では昇順
        for(i = 0 ; i <= num1 ; i++) {
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
            }else  if(d == 4){
                d = 2;
            }else if(d == 5){
                d = 3;
            }
        //    sent_d[i] = d;
            yaku_k[i] = new Yakuwari(i,d,0);
        }
        //Intent intentyk = new Intent(YourTurn.this,Touhyou.class);
        //intentyk.putExtra("Data",sent_d);
        return yaku_k;

    }

    public void hyouzi(Yakuwari[] yak_h,int y,int n){
        int g = get_num();

        TextView text_ban = (TextView)findViewById(R.id.textView4);
        EditText edittext = (EditText)findViewById(R.id.editTextNumber_y);
        Button buttony = (Button)findViewById((R.id.button_y));
        Button buttonn = (Button)findViewById((R.id.button_next));

        y = yak_h[n].yaku;

        if(n <g){
            switch (y){
                    //村人
                case 0:
                    text_ban.setText(String.valueOf(g)+"番目の方ですね？");
                    murabito();

                    break;
                    //人狼
                case 1:
                    text_ban.setText(n+"番目の方ですね？");
                    zinrou();

                    break;
                    //怪盗
                case 2:
                    text_ban.setText(n+"番目の方ですね？");
                    kaitou();

                    break;
                    //占い師
                case 3:
                    text_ban.setText(n+"番目の方ですね？");
                    uranai();

                    break;
                    //
                default:
                    text_ban.setText(n+"番目の方ですね？");
                    break;
            }

            //hyouzi(yak_h,yak_h[n+1].yaku,n+1);

        }else{
            //画面移動
        }


    }

    void murabito(){

    }
    void zinrou(){

    }
    void kaitou(){

    }
    void uranai(){

    }
}

