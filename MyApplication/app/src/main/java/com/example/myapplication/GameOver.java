package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    Button tekraroyna,cikis;

    TextView text;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        text=findViewById(R.id.textView6);

/*
        preferences=this.getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
        String a=preferences.getString("score","0");*/

        String a=getApplicationContext().getSharedPreferences(getApplicationContext().getPackageName(), Context.MODE_PRIVATE).getString("score", "0");

        text.setText(a);


        tekraroyna=findViewById(R.id.buttontekrar);
        cikis=findViewById(R.id.buttoncikis);

        tekraroyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GameOver.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


    }
}