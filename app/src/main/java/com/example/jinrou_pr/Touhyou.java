package com.example.jinrou_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class Touhyou extends AppCompatActivity {
    int[] num_nyu = new int[0];
    public static int[] num_touhyou = new int[100];
    public static int nyuryoku = 0;
    public static int max_i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touhyou);

        Button kettei = (Button) findViewById(R.id.buttont);
        kettei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.nyuryokut);
                String inputStr = editText.getText().toString();
                TextView textView1 = (TextView)findViewById(R.id.textViewt);
                textView1.setText(inputStr);


            }
        });
        int n = Ninzyu.num;
        int[] num_touhyou = new int[n];
        int i;
        int nyuryoku = 0;
        int max;

        for (i = 1; i <= n; i++) {
            TextView text_ban = (TextView) findViewById(R.id.textViewt);
            text_ban.setText(i + "番目の方ですね？");

            num_touhyou[nyuryoku]++;
        }
        max = num_touhyou[1];
        max_i = 1;
        for(i = 1; i <= n; i++){
            if(max < num_touhyou[i+1]){
                max = num_touhyou[i+1];
                max_i = i+1;
            }
        }
    }


}

