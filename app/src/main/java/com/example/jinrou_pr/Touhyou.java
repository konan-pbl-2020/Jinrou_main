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
    int i;
    int n = Ninzyu.num;
    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touhyou);

        Button kettei = (Button) findViewById(R.id.buttont);
        kettei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.nyuryokut);
                String inputStrT = editText.getText().toString();
                TextView textView1 = (TextView)findViewById(R.id.textViewt);
                textView1.setText(inputStrT);
                nyuryoku = Integer.parseInt("inputStrT");
                i++;
            }
        });

        int[] num_touhyou = new int[n];
        for (i = 0; i < n; ) {
            TextView text_ban = (TextView) findViewById(R.id.textViewt);
            text_ban.setText(i + "番目の方ですね？");

            num_touhyou[nyuryoku]++;
        }
        max = num_touhyou[0];
        max_i = 0;
        for(i = 0; i < n; i++){
            if(max < num_touhyou[i]){
                max = num_touhyou[i];
                max_i = i;
            }
        }
        if(i == Ninzyu.num){
            Intent intentT = new Intent(Touhyou.this, Kekka.class);
            startActivity(intentT);
        }
    }


}

