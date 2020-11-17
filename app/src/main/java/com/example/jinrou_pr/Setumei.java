package com.example.jinrou_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Setumei extends AppCompatActivity {
    Yakuwari yaku_setu[] = Kakunin.yaku_main;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setumei);
        Kakunin.pointa_i++;
        point = Kakunin.pointa_i - 1;

        TextView text_se = (TextView) findViewById(R.id.textView_se);
        EditText edittext = (EditText) findViewById(R.id.editTextNumber_y);
        final Button buttonhai = (Button) findViewById((R.id.button_hai));
        final Button buttonnext = (Button) findViewById((R.id.button_next));
        buttonnext.setEnabled(false);

        hyouzi(yaku_setu, point);
        buttonhai.setOnClickListener(new View.OnClickListener() {
            TextView text_se = (TextView) findViewById(R.id.textView_se);
            EditText edittext = (EditText) findViewById(R.id.editTextNumber_y);

            @Override
            public void onClick(View v) {
                switch (yaku_setu[point].yaku) {
                    case 0:
                    case 1:
                        buttonnext.setEnabled(true);
                        break;
                    case 2:
                        String str = edittext.getText().toString();
                        int k = Integer.parseInt(str);



                        int y = yaku_setu[k].yaku;

                        if (y == 0) {
                            text_se.setText(k+ "番目の人は村人です。");
                        } else if (y == 1) {
                            text_se.setText(k+ "番目の人は人狼です。");
                        } else if (y == 2) {
                            text_se.setText(k + "番目の人は占い師です。");
                        }else {
                            text_se.setText(k+"番目の人は存在しません。");
                        }

                        buttonnext.setEnabled(true);
                        break;
                    default:
                        text_se.setText("エラー");
                        break;
                }
            }
        });



        //画面移動
        buttonnext.setOnClickListener(new View.OnClickListener() {
            int n = Ninzyu.num - 1;

            @Override
            public void onClick(View v) {

                if (point == n) {
                    Intent intentsc = new Intent(Setumei.this, CountSecondActivity.class);
                    startActivity(intentsc);
                } else {
                    Intent intentsy = new Intent(Setumei.this, YourTurn.class);
                    startActivity(intentsy);
                }

//                Intent intenty = new Intent(YourTurn.this,Touhyou.class);

            }
        });

    }

    public void hyouzi(Yakuwari[] yak_h, int n) { ///配列　役のid 　配列のインデックス
        TextView text_se = (TextView) findViewById(R.id.textView_se);
        int g = Ninzyu.num;
        int y;

        y = yak_h[n].yaku;

        if (n < g) {
            switch (y) {
                //村人
                case 0:
                    text_se.setText("あなたは村人です。\n適当な数字を入れて決定を押して\n 次へを押してください");
                    break;
                //人狼
                case 1:
                    text_se.setText("あなたは人狼です。\n適当な数字を入れて決定を押して\n 次へを押してください");
                    break;
                //占い師
                case 2:
                    text_se.setText("あなたは占い師です。\n役職を知りたい人の番号\nを入れて決定を押して\n 次へを押してください");
                    break;
                //
                default:
                    text_se.setText("ERRORです。");
                    break;
            }
        }


    }
}


/*
    void murabito(){
        TextView text_se = (TextView)findViewById(R.id.textView_se);
        final EditText edittext = (EditText)findViewById(R.id.editTextNumber_y);
        final Button buttony = (Button)findViewById((R.id.button_h));
        final Button buttonn = (Button)findViewById((R.id.button_next));

        text_se.setText("あなたは村人です。\n適当な数字を入れて決定を押して\n 次へを押してください");

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
        TextView text_se = (TextView)findViewById(R.id.textView_se);
        final EditText edittext = (EditText)findViewById(R.id.editTextNumber_y);
        final Button buttony = (Button)findViewById((R.id.button_h));
        final Button buttonn = (Button)findViewById((R.id.button_next));

        text_se.setText("あなたは人狼です。\n適当な数字を入れて決定を押して\n 次へを押してください");

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
        final TextView text_se = (TextView)findViewById(R.id.textView_se);
        final EditText edittext = (EditText)findViewById(R.id.editTextNumber_y);
        final Button buttonhai = (Button)findViewById((R.id.button_hai));
        final Button buttonn = (Button)findViewById((R.id.button_next));

        text_se.setText("あなたは占い師です。\n役職を知りたい人の番号\nを入れて決定を押して\n 次へを押してください");

        buttonhai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edittext.getText().toString();
                int k = Integer.parseInt(str);

                text_se.getEditableText().clear();

                int y = yaku_setu[k].yaku;

                if(y == 0){
                    text_se.setText(k+"番目の人は村人です。");
                }else if(y == 1){
                    text_se.setText(k+"番目の人は人狼です。");
                }else if(y ==2){
                    text_se.setText(k+"番目の人は占い師です。");
                }

                buttonn.setEnabled(true);
            }
        });
        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext.setEnabled(false);
                buttonhai.setEnabled(false);
            }
        });


    }

}

 */