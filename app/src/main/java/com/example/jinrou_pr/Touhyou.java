package com.example.jinrou_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Arrays;

public class Touhyou extends AppCompatActivity {
    public static int max_id;
//    int[] num_nyu = new int[0];
    public int[] num_touhyou;

    public int nyuryoku = 0;
    private int it;
    private int n = Ninzyu.num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touhyou);

        TextView text_ban = (TextView) findViewById(R.id.textViewt);
        num_touhyou = new int[n];
        Arrays.fill(num_touhyou, 0);
        Button kettei = (Button) findViewById(R.id.buttont);

        it = 0;
        touhyou(it);

        kettei.setOnClickListener(new View.OnClickListener() {
            TextView text_ban = (TextView) findViewById(R.id.textViewt);
            EditText editText = (EditText) findViewById(R.id.nyuryokut);
            int ne = n - 1;
            @Override
            public void onClick(View v) {
                String inputStrT = editText.getText().toString();
                if(inputStrT.matches("")){
                    editText.getText().clear();
                    return;
                }
                if (it == ne) {
                    editText.getText().clear();
                    max_id = max_value(num_touhyou);
                    text_ban.setText(String.valueOf(max_id));
                    Intent intentT = new Intent(Touhyou.this, Kekka.class);
                    startActivity(intentT);
                }else {
                    //String inputStrT = editText.getText().toString();
                    int input_id = Integer.parseInt(inputStrT);
                    num_touhyou[input_id] += 1;
                    editText.getText().clear();

                    it++;
                    touhyou(it);
                }
            }
        });
    }

    void touhyou(int to) {
        TextView text_ban = (TextView) findViewById(R.id.textViewt);

        text_ban.setText(to + "番さんが人狼だと思う人の番号を入力してください");
        //num_touhyou[nyuryoku]++;
    }


    public int max_value(int[] values){
        int max_i;
        int max = 0;
        max_i = 0;

        for (int im = 0; im < n; im++) {
            if (values[im] > max) {
                max = values[im];
                max_i = im;
            }
        }

        return  max_i;

    }

}

