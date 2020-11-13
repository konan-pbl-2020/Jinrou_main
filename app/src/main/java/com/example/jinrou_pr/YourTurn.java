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
    public static Yakuwari yaku_main[];
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_turn);

        EditText edittext = (EditText)findViewById(R.id.editTextNumber_y);
        Button buttony = (Button)findViewById((R.id.button_y));
        edittext.setEnabled(false);
        buttony.setEnabled(false);


        yaku_main = kettei();

        Button buttonnext = (Button)findViewById(R.id.button_next);
        buttonnext.setOnClickListener(new View.OnClickListener() {
            int n = Ninzyu.num;
            @Override
            public void onClick(View v) {
                hyouzi(yaku_main,i);
                i++;
                if (i == Ninzyu.num) {
                    Intent intentyc = new Intent(YourTurn.this,CountSecondActivity.class);
                    startActivity(intentyc);
                }

//                Intent intenty = new Intent(YourTurn.this,Touhyou.class);

            }
        });
    }
/*
    public int get_num(){
        Intent intentyn = getIntent();

        int g_num = intentyn.getIntExtra("Data_num",0);
        return g_num;
    }
*/
    public Yakuwari[] kettei(){

        int i;
        int num1 = Ninzyu.num;
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
            }else  if(d > 4){
                d = 2;
            }
        //    sent_d[i] = d;
            yaku_k[i] = new Yakuwari(i,d,0);
        }
        //Intent intentyk = new Intent(YourTurn.this,Touhyou.class);
        //intentyk.putExtra("Data",sent_d);
        return yaku_k;

    }

    public void hyouzi(Yakuwari[] yak_h,int n){ ///配列　役のid 　配列のインデックス
        int g = Ninzyu.num;
        int y;

        TextView text_ban = (TextView)findViewById(R.id.textView4);
        EditText edittext = (EditText)findViewById(R.id.editTextNumber_y);
        Button buttony = (Button)findViewById((R.id.button_y));
        final Button buttonn = (Button)findViewById((R.id.button_next));

        y = yak_h[n].yaku;

        if(n <g){
            switch (y){
                    //村人
                case 0:
                    text_ban.setText(n+"番目の方ですね？");
                    buttonn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            murabito();
                        }

                    });

                    break;
                    //人狼
                case 1:
                    text_ban.setText(n+"番目の方ですね？");
                    buttonn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            zinrou();
                        }

                    });

                    break;
                    //占い師
                case 2:
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
        TextView text_ban = (TextView)findViewById(R.id.textView4);
        final EditText edittext = (EditText)findViewById(R.id.editTextNumber_y);
        final Button buttony = (Button)findViewById((R.id.button_y));
        final Button buttonn = (Button)findViewById((R.id.button_next));

        text_ban.setText("あなたは村人です。\n適当な数字を入れて決定を押して\n 次へを押してください");

        buttony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonn.setEnabled(true);
                edittext.getEditableText().clear();
            }
        });
        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext.setEnabled(false);
                buttony.setEnabled(false);
            }
        });


    }
    void zinrou(){
        TextView text_ban = (TextView)findViewById(R.id.textView4);
        final EditText edittext = (EditText)findViewById(R.id.editTextNumber_y);
        final Button buttony = (Button)findViewById((R.id.button_y));
        final Button buttonn = (Button)findViewById((R.id.button_next));

        text_ban.setText("あなたは人狼です。\n適当な数字を入れて決定を押して\n 次へを押してください");

        buttony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonn.setEnabled(true);
                edittext.getEditableText().clear();
            }
        });
        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext.setEnabled(false);
                buttony.setEnabled(false);
            }
        });


    }
    void uranai(){
        final TextView text_ban = (TextView)findViewById(R.id.textView4);
        final EditText edittext = (EditText)findViewById(R.id.editTextNumber_y);
        final Button buttony = (Button)findViewById((R.id.button_y));
        final Button buttonn = (Button)findViewById((R.id.button_next));

        text_ban.setText("あなたは怪盗です。\n入れ替えたい人の番号\nを入れて決定を押して\n 次へを押してください");

        buttony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edittext.getText().toString();
                int k = Integer.parseInt(str);

                text_ban.getEditableText().clear();

                int y = yaku_main[i].yaku;

                if(y == 0){
                    text_ban.setText(k+"番目の人は村人です。");
                }else if(y == 1){
                    text_ban.setText(k+"番目の人は人狼です。");
                }else if(y ==2){
                    text_ban.setText(k+"番目の人は占い師です。");
                }

                buttonn.setEnabled(true);
            }
        });
        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext.setEnabled(false);
                buttony.setEnabled(false);
            }
        });


    }

}

