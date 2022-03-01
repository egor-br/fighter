package com.example.fighter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    private TextView txt, txt1;
    private Button btn1, btn2, btn3;
    private ImageButton imbtn1, imbtn2, imbtn3;
    private MediaPlayer knop;
    private String name;
    private String zvuk = "1";
    private int  chit = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        txt = (TextView)findViewById(R.id.textView3);
        txt1 = (TextView)findViewById(R.id.textView4);
        name = intent.getStringExtra("name");
        txt.setText("Выбери себе соперника,");
            //txt1.setTextColor(Color.GREEN);
        txt1.setText(name);
        knop = MediaPlayer.create(this, R.raw.knopka);
        if("деньги".equals(name) || "Деньги".equals(name) || "ДЕНЬГИ".equals(name)){
            chit = 1;
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Чит на здоровье", Toast.LENGTH_SHORT);
            toast.show();
        }
        if("доллар".equals(name) || "Доллар".equals(name)){
            chit = 2;
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Чит на урон", Toast.LENGTH_SHORT);
            toast.show();
        }
        if("Шекель".equals(name) || "шекель".equals(name)){
            chit = 3;
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Чит на урон и здоровье", Toast.LENGTH_SHORT);
            toast.show();
        }
        onButton();
    }

    public void onButton() {
        btn1 = (Button)findViewById(R.id.button3);
        btn2 = (Button)findViewById(R.id.button4);
        btn3 = (Button)findViewById(R.id.button5);
        imbtn1 = (ImageButton)findViewById(R.id.imageButton2);
        imbtn2 = (ImageButton)findViewById(R.id.imageButton3);
        imbtn3 = (ImageButton)findViewById(R.id.imageButton);
        String ch = Integer.toString(chit);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)){ SoundPlay(knop);}
                        Intent intent = new Intent(menu.this, GameActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("name1", "Медведь");
                        intent.putExtra("zvuk", zvuk);
                        startActivity(intent);
                    }
                }
        );

        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)){ SoundPlay(knop);}
                        Intent intent = new Intent(menu.this, GameActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("name1", "Хабиб");
                        intent.putExtra("zvuk", zvuk);
                        startActivity(intent);
                    }
                }
        );

        btn3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)){ SoundPlay(knop);}
                        Intent intent = new Intent(menu.this, GameActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("name1", "Фёдор Емельяненко");
                        intent.putExtra("zvuk", zvuk);
                        startActivity(intent);
                    }
                }
        );

        imbtn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SoundPlay(knop);
                        if("1".equals(zvuk)){
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Звук выключен", Toast.LENGTH_SHORT);
                            toast.show();
                            zvuk = "0";
                        }else{
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Звук включен", Toast.LENGTH_SHORT);
                            toast.show();
                            zvuk = "1";
                        }
                    }
                }
        );

        imbtn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)){ SoundPlay(knop);}
                        AlertDialog.Builder a1_builder = new AlertDialog.Builder(menu.this);
                        a1_builder.setMessage("Хотите вернуться к авторизации?").setCancelable(false).setPositiveButton("Да", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setNegativeButton("Нет",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog al_builder = a1_builder.create();

                        al_builder.show();
                    }
                }
        );
        imbtn3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)){ SoundPlay(knop);}
                        Intent intent = new Intent(menu.this, PravActivity.class);
                        intent.putExtra("zvuk", zvuk);
                        startActivity(intent);
                    }
                }
        );
    }

    public void SoundPlay(MediaPlayer sound){
        sound.start();
    }
}