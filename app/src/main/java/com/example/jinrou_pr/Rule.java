package com.example.jinrou_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        Button buttonrs = (Button)findViewById(R.id.Button_rs);
        buttonrs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentrs = new Intent(Rule.this,MainActivity.class);
                startActivity(intentrs);
            }
        });
    }
}