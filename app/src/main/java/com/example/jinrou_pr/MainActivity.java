package com.example.jinrou_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonsn = (Button)findViewById(R.id.button_sn);
        buttonsn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentsn = new Intent(MainActivity.this,Ninzyu.class);
                startActivity(intentsn);
            }
        });

        Button buttonsr = (Button)findViewById(R.id.button_sr);
        buttonsr.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intentsr = new Intent(MainActivity.this,Rule.class);
                startActivity(intentsr);
            }
        });

    }
}