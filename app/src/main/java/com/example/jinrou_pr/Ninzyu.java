package com.example.jinrou_pr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import androidx.appcompat.app.AppCompatActivity;

public class Ninzyu extends AppCompatActivity {
    public static int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninzyu);

        Button buttonna = (Button)findViewById(R.id.button_na);
        buttonna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick();
                Intent intentnk = new Intent(Ninzyu.this, Kakunin.class);
                startActivity(intentnk);
            }
        });



    }

    public  void onButtonClick(){
        EditText num_text = (EditText)findViewById(R.id.editTextNumber_n);
//        TextView editText2 = (TextView)findViewById(R.id.textView5);


        String str = num_text.getText().toString();

        num = Integer.parseInt(str);

 //       String str3 = String.valueOf(num);
 //       editText2.setText("完了"+str3);


    }
}