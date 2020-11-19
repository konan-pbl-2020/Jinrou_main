package com.example.jinrou_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class YourTurn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_turn);

        Button buttonh = (Button) findViewById((R.id.button_h));
        TextView textViewy = (TextView) findViewById(R.id.textView4);

        textViewy.setText(Kakunin.pointa_i + "番目の方ですね？");

        buttonh.setOnClickListener(new View.OnClickListener() {
            int n = Ninzyu.num;

            @Override
            public void onClick(View v) {
                Intent intentys = new Intent(YourTurn.this, Setumei.class);
                startActivity(intentys);
            }
        });
    }
}

