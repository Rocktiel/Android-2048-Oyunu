package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static TextView textskor, text00, text01, text02, text03, text10, text11, text12, text13, text20, text21, text22, text23, text30, text31, text32, text33;
    Button butonsag;
    Button butonsol;
    Button butonyukari;
    Button butonasagi;
    Button butonrestart;
    static Button butonexit;
    static int[][] a = new int[4][4];
    static int skor = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butonsag = findViewById(R.id.buttonsag);
        butonsol = findViewById(R.id.buttonsol);
        butonyukari = findViewById(R.id.buttonyukari);
        butonasagi = findViewById(R.id.buttonasagi);

        butonrestart = findViewById(R.id.buttonrestart);
        butonexit = findViewById(R.id.buttonexit);

        butonrestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetle();

            }
        });

        butonexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("ÇIKIŞ");
                builder.setMessage("Çıkmak istediğinize emin misiniz?");

                builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        finish();

                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        textskor = findViewById(R.id.textView);
        text00 = findViewById(R.id.textView00);
        text01 = findViewById(R.id.textView01);
        text02 = findViewById(R.id.textView02);
        text03 = findViewById(R.id.textView03);
        text10 = findViewById(R.id.textView10);
        text11 = findViewById(R.id.textView11);
        text12 = findViewById(R.id.textView12);
        text13 = findViewById(R.id.textView13);
        text20 = findViewById(R.id.textView20);
        text21 = findViewById(R.id.textView21);
        text22 = findViewById(R.id.textView22);
        text23 = findViewById(R.id.textView23);
        text30 = findViewById(R.id.textView30);
        text31 = findViewById(R.id.textView31);
        text32 = findViewById(R.id.textView32);
        text33 = findViewById(R.id.textView33);

        rastgelesayi();
        rastgelesayi();
        esitle();

        butonsag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sag();
                rastgelesayi();
                esitle();
                oyunbittimi();

            }
        });

        butonsol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sol();
                rastgelesayi();
                esitle();
                oyunbittimi();

            }
        });

        butonyukari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yukari();
                rastgelesayi();
                esitle();
                oyunbittimi();

            }
        });

        butonasagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                asagı();
                rastgelesayi();
                esitle();
                oyunbittimi();

            }
        });


    }

    public static void rastgelesayi() {

        //Önce tabloda boş yer olup olmadığını kontrol diyoruz.Eğer boş yer varsa 2 veya 4 sayısını rastgele koyuyoruz.

        int kontrol=0;
        for(int m=0;m<4;m++){
            for(int n=0;n<4;n++){
                if(a[m][n]==0){
                    kontrol=1;
                }
            }
        }
        if(kontrol==1){

            Random rand = new Random();
            int b, c;
            do {
                b = rand.nextInt(4);
                c = rand.nextInt(4);
            } while (a[b][c] != 0);
            a[b][c] = rand.nextInt(2) * 2 + 2;

        }

    }


    public void sol() {

        //İlk önce sayıları kaydırıyoruz sonra eşit sayılar varsa topluyoruz sonra boşluk kalmaması için bir daha kaydırıyoruz.

        for (int i = 0; i < 4; i++) {
            for (int c = 0; c < 4; c++) {
                for (int j = 3; j > 0; j--) {
                    if (a[i][j - 1] == 0) {
                        a[i][j - 1] = a[i][j];
                        a[i][j] = 0;

                    }
                }
            }
            for (int k = 1; k < 4; k++) {
                if (a[i][k] == a[i][k - 1]) {
                    a[i][k - 1] *= 2;
                    a[i][k] = 0;
                    skor += a[i][k - 1];


                }
            }
            for (int c = 0; c <= 4; c++) {
                for (int j = 3; j > 0; j--) {
                    if (a[i][j - 1] == 0) {
                        a[i][j - 1] = a[i][j];
                        a[i][j] = 0;

                    }
                }
            }

        }
    }
    public void sag() {

        for (int i = 0; i < 4; i++) {
            for (int c = 0; c < 4; c++) {
                for (int j = 3; j > 0; j--) {
                    if (a[i][j] == 0) {
                        a[i][j] = a[i][j - 1];
                        a[i][j - 1] = 0;

                    }
                }
            }
            for (int k = 3; k > 0; k--) {
                if (a[i][k - 1] == a[i][k]) {
                    a[i][k] *= 2;
                    a[i][k - 1] = 0;
                    skor += a[i][k];

                }

            }
            for (int c = 0; c < 4; c++) {
                for (int j = 3; j > 0; j--) {
                    if (a[i][j] == 0) {
                        a[i][j] = a[i][j - 1];
                        a[i][j - 1] = 0;

                    }
                }
            }
        }

    }
    public void yukari() {

        for (int j = 0; j < 4; j++) {
            for (int c = 0; c < 4; c++) {
                for (int i = 3; i > 0; i--) {
                    if (a[i - 1][j] == 0) {
                        a[i - 1][j] = a[i][j];
                        a[i][j] = 0;


                    }
                }
            }
            for (int k = 1; k < 4; k++) {
                if (a[k - 1][j] == a[k][j]) {
                    a[k][j] *= 2;
                    a[k - 1][j] = 0;
                    skor += a[k][j];


                }

            }
            for (int c = 0; c < 4; c++) {
                for (int i = 3; i > 0; i--) {
                    if (a[i - 1][j] == 0) {
                        a[i - 1][j] = a[i][j];
                        a[i][j] = 0;


                    }
                }
            }
        }

    }
    public void asagı(){

        for(int j=0;j<4;j++){

            for(int c=0;c<4;c++){
                for(int i=1;i<4;i++){
                    if(a[i][j]==0){
                        a[i][j]=a[i-1][j];
                        a[i-1][j]=0;


                    }
                }
            }

            for(int k=3;k>0;k--){
                if(a[k-1][j]==a[k][j]){
                    a[k-1][j]*=2;
                    a[k][j]=0;
                    skor+=a[k-1][j];

                }

            }


            for(int c=0;c<4;c++){
                for(int i=1;i<4;i++){
                    if(a[i][j]==0){
                        a[i][j]=a[i-1][j];
                        a[i-1][j]=0;

                    }
                }
            }


        }

    }


    //TextView'leri dizideki sayılara eşitliyor ve sayıya göre rengini değiştiriyor.
    public void esitle() {

        textskor.setText(String.valueOf(skor));

        text00.setText(String.valueOf(a[0][0]));
        if (text00.getText().equals("0")) {
            text00.setText("");
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text00.getText().equals("2")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text00.setTextColor(Color.parseColor("#030000"));
        } else if (text00.getText().equals("4")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text00.setTextColor(Color.parseColor("#030000"));
        } else if (text00.getText().equals("8")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text00.setTextColor(Color.parseColor("#ffffff"));
        } else if (text00.getText().equals("16")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text00.setTextColor(Color.parseColor("#ffffff"));
        } else if (text00.getText().equals("32")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text00.setTextColor(Color.parseColor("#ffffff"));
        } else if (text00.getText().equals("64")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text00.setTextColor(Color.parseColor("#ffffff"));
        } else if (text00.getText().equals("128")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text00.setTextColor(Color.parseColor("#ffffff"));
        } else if (text00.getText().equals("256")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text00.setTextColor(Color.parseColor("#ffffff"));
        } else if (text00.getText().equals("512")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text00.setTextColor(Color.parseColor("#ffffff"));
        } else if (text00.getText().equals("1024")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text00.setTextColor(Color.parseColor("#ffffff"));
        } else if (text00.getText().equals("2048")) {
            text00.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text00.setTextColor(Color.parseColor("#ffffff"));
        }

        text01.setText(String.valueOf(a[0][1]));
        if (text01.getText().equals("0")) {
            text01.setText("");
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text01.getText().equals("2")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text01.setTextColor(Color.parseColor("#030000"));
        } else if (text01.getText().equals("4")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text01.setTextColor(Color.parseColor("#030000"));
        } else if (text01.getText().equals("8")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text01.setTextColor(Color.parseColor("#ffffff"));
        } else if (text01.getText().equals("16")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text01.setTextColor(Color.parseColor("#ffffff"));
        } else if (text01.getText().equals("32")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text01.setTextColor(Color.parseColor("#ffffff"));
        } else if (text01.getText().equals("64")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text01.setTextColor(Color.parseColor("#ffffff"));
        } else if (text01.getText().equals("128")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text00.setTextColor(Color.parseColor("#ffffff"));
        } else if (text01.getText().equals("256")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text01.setTextColor(Color.parseColor("#ffffff"));
        } else if (text01.getText().equals("512")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text01.setTextColor(Color.parseColor("#ffffff"));
        } else if (text01.getText().equals("1024")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text01.setTextColor(Color.parseColor("#ffffff"));
        } else if (text01.getText().equals("2048")) {
            text01.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text01.setTextColor(Color.parseColor("#ffffff"));
        }

        text02.setText(String.valueOf(a[0][2]));
        if (text02.getText().equals("0")) {
            text02.setText("");
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text02.getText().equals("2")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text02.setTextColor(Color.parseColor("#030000"));
        } else if (text02.getText().equals("4")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text02.setTextColor(Color.parseColor("#030000"));
        } else if (text02.getText().equals("8")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text02.setTextColor(Color.parseColor("#ffffff"));
        } else if (text02.getText().equals("16")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text02.setTextColor(Color.parseColor("#ffffff"));
        } else if (text02.getText().equals("32")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text02.setTextColor(Color.parseColor("#ffffff"));
        } else if (text02.getText().equals("64")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text02.setTextColor(Color.parseColor("#ffffff"));
        } else if (text02.getText().equals("128")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text02.setTextColor(Color.parseColor("#ffffff"));
        } else if (text02.getText().equals("256")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text02.setTextColor(Color.parseColor("#ffffff"));
        } else if (text02.getText().equals("512")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text02.setTextColor(Color.parseColor("#ffffff"));
        } else if (text02.getText().equals("1024")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text02.setTextColor(Color.parseColor("#ffffff"));
        } else if (text02.getText().equals("2048")) {
            text02.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text02.setTextColor(Color.parseColor("#ffffff"));
        }

        text03.setText(String.valueOf(a[0][3]));
        if (text03.getText().equals("0")) {
            text03.setText("");
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text03.getText().equals("2")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text03.setTextColor(Color.parseColor("#030000"));
        } else if (text03.getText().equals("4")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text03.setTextColor(Color.parseColor("#030000"));
        } else if (text03.getText().equals("8")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text03.setTextColor(Color.parseColor("#ffffff"));
        } else if (text03.getText().equals("16")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text03.setTextColor(Color.parseColor("#ffffff"));
        } else if (text03.getText().equals("32")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text03.setTextColor(Color.parseColor("#ffffff"));
        } else if (text03.getText().equals("64")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text03.setTextColor(Color.parseColor("#ffffff"));
        } else if (text03.getText().equals("128")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text03.setTextColor(Color.parseColor("#ffffff"));
        } else if (text03.getText().equals("256")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text03.setTextColor(Color.parseColor("#ffffff"));
        } else if (text03.getText().equals("512")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text03.setTextColor(Color.parseColor("#ffffff"));
        } else if (text03.getText().equals("1024")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text03.setTextColor(Color.parseColor("#ffffff"));
        } else if (text03.getText().equals("2048")) {
            text03.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text03.setTextColor(Color.parseColor("#ffffff"));
        }

        text10.setText(String.valueOf(a[1][0]));
        if (text10.getText().equals("0")) {
            text10.setText("");
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text10.getText().equals("2")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text10.setTextColor(Color.parseColor("#030000"));
        } else if (text10.getText().equals("4")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text10.setTextColor(Color.parseColor("#030000"));
        } else if (text10.getText().equals("8")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text10.setTextColor(Color.parseColor("#ffffff"));
        } else if (text10.getText().equals("16")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text10.setTextColor(Color.parseColor("#ffffff"));
        } else if (text10.getText().equals("32")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text10.setTextColor(Color.parseColor("#ffffff"));
        } else if (text10.getText().equals("64")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text10.setTextColor(Color.parseColor("#ffffff"));
        } else if (text10.getText().equals("128")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text10.setTextColor(Color.parseColor("#ffffff"));
        } else if (text10.getText().equals("256")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text10.setTextColor(Color.parseColor("#ffffff"));
        } else if (text10.getText().equals("512")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text10.setTextColor(Color.parseColor("#ffffff"));
        } else if (text10.getText().equals("1024")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text10.setTextColor(Color.parseColor("#ffffff"));
        } else if (text10.getText().equals("2048")) {
            text10.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text10.setTextColor(Color.parseColor("#ffffff"));
        }

        text11.setText(String.valueOf(a[1][1]));
        if (text11.getText().equals("0")) {
            text11.setText("");
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text11.getText().equals("2")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text11.setTextColor(Color.parseColor("#030000"));
        } else if (text11.getText().equals("4")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text11.setTextColor(Color.parseColor("#030000"));
        } else if (text11.getText().equals("8")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text11.setTextColor(Color.parseColor("#ffffff"));
        } else if (text11.getText().equals("16")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text11.setTextColor(Color.parseColor("#ffffff"));
        } else if (text11.getText().equals("32")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text11.setTextColor(Color.parseColor("#ffffff"));
        } else if (text11.getText().equals("64")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text11.setTextColor(Color.parseColor("#ffffff"));
        } else if (text11.getText().equals("128")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text11.setTextColor(Color.parseColor("#ffffff"));
        } else if (text11.getText().equals("256")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text11.setTextColor(Color.parseColor("#ffffff"));
        } else if (text11.getText().equals("512")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text11.setTextColor(Color.parseColor("#ffffff"));
        } else if (text11.getText().equals("1024")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text11.setTextColor(Color.parseColor("#ffffff"));
        } else if (text11.getText().equals("2048")) {
            text11.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text11.setTextColor(Color.parseColor("#ffffff"));
        }

        text12.setText(String.valueOf(a[1][2]));
        if (text12.getText().equals("0")) {
            text12.setText("");
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text12.getText().equals("2")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text12.setTextColor(Color.parseColor("#030000"));
        } else if (text12.getText().equals("4")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text12.setTextColor(Color.parseColor("#030000"));
        } else if (text12.getText().equals("8")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text12.setTextColor(Color.parseColor("#ffffff"));
        } else if (text12.getText().equals("16")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text12.setTextColor(Color.parseColor("#ffffff"));
        } else if (text12.getText().equals("32")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text12.setTextColor(Color.parseColor("#ffffff"));
        } else if (text12.getText().equals("64")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text12.setTextColor(Color.parseColor("#ffffff"));
        } else if (text12.getText().equals("128")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text12.setTextColor(Color.parseColor("#ffffff"));
        } else if (text12.getText().equals("256")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text12.setTextColor(Color.parseColor("#ffffff"));
        } else if (text12.getText().equals("512")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text12.setTextColor(Color.parseColor("#ffffff"));
        } else if (text12.getText().equals("1024")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text12.setTextColor(Color.parseColor("#ffffff"));
        } else if (text12.getText().equals("2048")) {
            text12.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text12.setTextColor(Color.parseColor("#ffffff"));
        }

        text13.setText(String.valueOf(a[1][3]));
        if (text13.getText().equals("0")) {
            text13.setText("");
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text13.getText().equals("2")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text13.setTextColor(Color.parseColor("#030000"));
        } else if (text13.getText().equals("4")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text13.setTextColor(Color.parseColor("#030000"));
        } else if (text13.getText().equals("8")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text13.setTextColor(Color.parseColor("#ffffff"));
        } else if (text13.getText().equals("16")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text13.setTextColor(Color.parseColor("#ffffff"));
        } else if (text13.getText().equals("32")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text13.setTextColor(Color.parseColor("#ffffff"));
        } else if (text13.getText().equals("64")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text13.setTextColor(Color.parseColor("#ffffff"));
        } else if (text13.getText().equals("128")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text13.setTextColor(Color.parseColor("#ffffff"));
        } else if (text13.getText().equals("256")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text13.setTextColor(Color.parseColor("#ffffff"));
        } else if (text13.getText().equals("512")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text13.setTextColor(Color.parseColor("#ffffff"));
        } else if (text13.getText().equals("1024")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text13.setTextColor(Color.parseColor("#ffffff"));
        } else if (text13.getText().equals("2048")) {
            text13.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text13.setTextColor(Color.parseColor("#ffffff"));
        }

        text20.setText(String.valueOf(a[2][0]));
        if (text20.getText().equals("0")) {
            text20.setText("");
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text20.getText().equals("2")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text20.setTextColor(Color.parseColor("#030000"));
        } else if (text20.getText().equals("4")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text20.setTextColor(Color.parseColor("#030000"));
        } else if (text20.getText().equals("8")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text20.setTextColor(Color.parseColor("#ffffff"));
        } else if (text20.getText().equals("16")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text20.setTextColor(Color.parseColor("#ffffff"));
        } else if (text20.getText().equals("32")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text20.setTextColor(Color.parseColor("#ffffff"));
        } else if (text20.getText().equals("64")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text20.setTextColor(Color.parseColor("#ffffff"));
        } else if (text20.getText().equals("128")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text20.setTextColor(Color.parseColor("#ffffff"));
        } else if (text20.getText().equals("256")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text20.setTextColor(Color.parseColor("#ffffff"));
        } else if (text20.getText().equals("512")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text20.setTextColor(Color.parseColor("#ffffff"));
        } else if (text20.getText().equals("1024")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text20.setTextColor(Color.parseColor("#ffffff"));
        } else if (text20.getText().equals("2048")) {
            text20.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text20.setTextColor(Color.parseColor("#ffffff"));
        }

        text21.setText(String.valueOf(a[2][1]));
        if (text21.getText().equals("0")) {
            text21.setText("");
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text21.getText().equals("2")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text21.setTextColor(Color.parseColor("#030000"));
        } else if (text21.getText().equals("4")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text21.setTextColor(Color.parseColor("#030000"));
        } else if (text21.getText().equals("8")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text21.setTextColor(Color.parseColor("#ffffff"));
        } else if (text21.getText().equals("16")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text21.setTextColor(Color.parseColor("#ffffff"));
        } else if (text21.getText().equals("32")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text21.setTextColor(Color.parseColor("#ffffff"));
        } else if (text21.getText().equals("64")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text21.setTextColor(Color.parseColor("#ffffff"));
        } else if (text21.getText().equals("128")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text21.setTextColor(Color.parseColor("#ffffff"));
        } else if (text21.getText().equals("256")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text21.setTextColor(Color.parseColor("#ffffff"));
        } else if (text21.getText().equals("512")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text21.setTextColor(Color.parseColor("#ffffff"));
        } else if (text21.getText().equals("1024")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text21.setTextColor(Color.parseColor("#ffffff"));
        } else if (text21.getText().equals("2048")) {
            text21.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text21.setTextColor(Color.parseColor("#ffffff"));
        }

        text22.setText(String.valueOf(a[2][2]));
        if (text22.getText().equals("0")) {
            text22.setText("");
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text22.getText().equals("2")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text22.setTextColor(Color.parseColor("#030000"));
        } else if (text22.getText().equals("4")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text22.setTextColor(Color.parseColor("#030000"));
        } else if (text22.getText().equals("8")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text22.setTextColor(Color.parseColor("#ffffff"));
        } else if (text22.getText().equals("16")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text22.setTextColor(Color.parseColor("#ffffff"));
        } else if (text22.getText().equals("32")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text22.setTextColor(Color.parseColor("#ffffff"));
        } else if (text22.getText().equals("64")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text22.setTextColor(Color.parseColor("#ffffff"));
        } else if (text22.getText().equals("128")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text22.setTextColor(Color.parseColor("#ffffff"));
        } else if (text22.getText().equals("256")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text22.setTextColor(Color.parseColor("#ffffff"));
        } else if (text22.getText().equals("512")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text22.setTextColor(Color.parseColor("#ffffff"));
        } else if (text22.getText().equals("1024")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text22.setTextColor(Color.parseColor("#ffffff"));
        } else if (text22.getText().equals("2048")) {
            text22.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text22.setTextColor(Color.parseColor("#ffffff"));
        }

        text23.setText(String.valueOf(a[2][3]));
        if (text23.getText().equals("0")) {
            text23.setText("");
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text23.getText().equals("2")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text23.setTextColor(Color.parseColor("#030000"));
        } else if (text23.getText().equals("4")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text23.setTextColor(Color.parseColor("#030000"));
        } else if (text23.getText().equals("8")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text23.setTextColor(Color.parseColor("#ffffff"));
        } else if (text23.getText().equals("16")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text23.setTextColor(Color.parseColor("#ffffff"));
        } else if (text23.getText().equals("32")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text23.setTextColor(Color.parseColor("#ffffff"));
        } else if (text23.getText().equals("64")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text23.setTextColor(Color.parseColor("#ffffff"));
        } else if (text23.getText().equals("128")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text23.setTextColor(Color.parseColor("#ffffff"));
        } else if (text23.getText().equals("256")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text23.setTextColor(Color.parseColor("#ffffff"));
        } else if (text23.getText().equals("512")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text23.setTextColor(Color.parseColor("#ffffff"));
        } else if (text23.getText().equals("1024")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text23.setTextColor(Color.parseColor("#ffffff"));
        } else if (text23.getText().equals("2048")) {
            text23.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text23.setTextColor(Color.parseColor("#ffffff"));
        }

        text30.setText(String.valueOf(a[3][0]));
        if (text30.getText().equals("0")) {
            text30.setText("");
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text30.getText().equals("2")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text30.setTextColor(Color.parseColor("#030000"));
        } else if (text30.getText().equals("4")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text30.setTextColor(Color.parseColor("#030000"));
        } else if (text30.getText().equals("8")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text30.setTextColor(Color.parseColor("#ffffff"));
        } else if (text30.getText().equals("16")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text30.setTextColor(Color.parseColor("#ffffff"));
        } else if (text30.getText().equals("32")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text30.setTextColor(Color.parseColor("#ffffff"));
        } else if (text30.getText().equals("64")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text30.setTextColor(Color.parseColor("#ffffff"));
        } else if (text30.getText().equals("128")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text30.setTextColor(Color.parseColor("#ffffff"));
        } else if (text30.getText().equals("256")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text30.setTextColor(Color.parseColor("#ffffff"));
        } else if (text30.getText().equals("512")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text30.setTextColor(Color.parseColor("#ffffff"));
        } else if (text30.getText().equals("1024")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text30.setTextColor(Color.parseColor("#ffffff"));
        } else if (text30.getText().equals("2048")) {
            text30.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text30.setTextColor(Color.parseColor("#ffffff"));
        }

        text31.setText(String.valueOf(a[3][1]));
        if (text31.getText().equals("0")) {
            text31.setText("");
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text31.getText().equals("2")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text31.setTextColor(Color.parseColor("#030000"));
        } else if (text31.getText().equals("4")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text31.setTextColor(Color.parseColor("#030000"));
        } else if (text31.getText().equals("8")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text31.setTextColor(Color.parseColor("#ffffff"));
        } else if (text31.getText().equals("16")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text31.setTextColor(Color.parseColor("#ffffff"));
        } else if (text31.getText().equals("32")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text31.setTextColor(Color.parseColor("#ffffff"));
        } else if (text31.getText().equals("64")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text31.setTextColor(Color.parseColor("#ffffff"));
        } else if (text31.getText().equals("128")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text31.setTextColor(Color.parseColor("#ffffff"));
        } else if (text31.getText().equals("256")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text31.setTextColor(Color.parseColor("#ffffff"));
        } else if (text31.getText().equals("512")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text31.setTextColor(Color.parseColor("#ffffff"));
        } else if (text31.getText().equals("1024")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text31.setTextColor(Color.parseColor("#ffffff"));
        } else if (text31.getText().equals("2048")) {
            text31.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text31.setTextColor(Color.parseColor("#ffffff"));
        }

        text32.setText(String.valueOf(a[3][2]));
        if (text32.getText().equals("0")) {
            text32.setText("");
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text32.getText().equals("2")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text32.setTextColor(Color.parseColor("#030000"));
        } else if (text32.getText().equals("4")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text32.setTextColor(Color.parseColor("#030000"));
        } else if (text32.getText().equals("8")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text32.setTextColor(Color.parseColor("#ffffff"));
        } else if (text32.getText().equals("16")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text32.setTextColor(Color.parseColor("#ffffff"));
        } else if (text32.getText().equals("32")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text32.setTextColor(Color.parseColor("#ffffff"));
        } else if (text32.getText().equals("64")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text32.setTextColor(Color.parseColor("#ffffff"));
        } else if (text32.getText().equals("128")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text32.setTextColor(Color.parseColor("#ffffff"));
        } else if (text32.getText().equals("256")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text32.setTextColor(Color.parseColor("#ffffff"));
        } else if (text32.getText().equals("512")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text32.setTextColor(Color.parseColor("#ffffff"));
        } else if (text32.getText().equals("1024")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text32.setTextColor(Color.parseColor("#ffffff"));
        } else if (text32.getText().equals("2048")) {
            text32.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text32.setTextColor(Color.parseColor("#ffffff"));
        }

        text33.setText(String.valueOf(a[3][3]));
        if (text33.getText().equals("0")) {
            text33.setText("");
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text));
        } else if (text33.getText().equals("2")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2));
            text33.setTextColor(Color.parseColor("#030000"));
        } else if (text33.getText().equals("4")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text4));
            text33.setTextColor(Color.parseColor("#030000"));
        } else if (text33.getText().equals("8")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text8));
            text33.setTextColor(Color.parseColor("#ffffff"));
        } else if (text33.getText().equals("16")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text16));
            text33.setTextColor(Color.parseColor("#ffffff"));
        } else if (text33.getText().equals("32")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text32));
            text33.setTextColor(Color.parseColor("#ffffff"));
        } else if (text33.getText().equals("64")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text64));
            text33.setTextColor(Color.parseColor("#ffffff"));
        } else if (text33.getText().equals("128")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text128));
            text33.setTextColor(Color.parseColor("#ffffff"));
        } else if (text33.getText().equals("256")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text256));
            text33.setTextColor(Color.parseColor("#ffffff"));
        } else if (text33.getText().equals("512")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text512));
            text33.setTextColor(Color.parseColor("#ffffff"));
        } else if (text33.getText().equals("1024")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text1024));
            text33.setTextColor(Color.parseColor("#ffffff"));
        } else if (text33.getText().equals("2048")) {
            text33.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.text2048));
            text33.setTextColor(Color.parseColor("#ffffff"));
        }

    }


    //Butona bastığımızda kaydıramasakta yan yana eşit iki sayı var mı diye kontrol ediyoruz.
    // Böylece tablo dolu olsada oyunun bitmemesini sağlıyoruz.
    public boolean kontrolesitsayi(){

        for (int i = 0; i < 4; i++) {
            for (int k = 3; k > 0; k--) {
                if (a[i][k - 1] == a[i][k]) {
                    return false;
                }
            }
        }

        for (int j=0;j<4;j++){
            for (int k = 3; k > 0; k--) {
                if (a[k - 1][j] == a[k][j]) {
                    return false;
                }
            }
        }

        return true;

    }


    //Oyunun bitip bitmediğini kontrol ediyoruz.
    public void oyunbittimi(){

        int kontrol=0;

        for(int m=0;m<4;m++){
            for(int n=0;n<4;n++){
                if(a[m][n]==0){
                    kontrol=1;

                }
            }
        }
        if(kontrol==0 && kontrolesitsayi()){

            SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getApplicationContext().getPackageName(), Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPref.edit();
            edit.putString("score",textskor.getText().toString());
            edit.commit();

            for(int m=0;m<4;m++){
                for(int n=0;n<4;n++){
                    a[m][n]=0;
                }
            }
            skor=0;



            Intent i=new Intent(MainActivity.this,GameOver.class);
            startActivity(i);
            finish();

        }
    }


    //Oyunu resetlemek için fonksiyon.Bütün tabloyu 0'a eşitliyoruz.
    // İki tane rastgele sayı koyup skoru 0'a eşitleyerek oyunu baştan başlatmış oluyoruz.
    public void resetle(){

        for(int m=0;m<4;m++){
            for(int n=0;n<4;n++){
                a[m][n]=0;
            }
        }
        rastgelesayi();
        rastgelesayi();
        skor=0;
        esitle();

    }
}