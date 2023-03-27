package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button butonbasla,butonoynanis,butoncikis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        butonbasla=findViewById(R.id.button);
        butonoynanis=findViewById(R.id.button2);
        butoncikis=findViewById(R.id.button3);

        butonbasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        butonoynanis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(i);
                finish();

            }
        });

        butoncikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}