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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6;
    private String name, name1,zvuk = "1";
    private TextView text_name, text_hp1, text_hp2, text_okn1, text_okn2;
    private int chit, zdorov;
    private int vrag_hp = 8, player_hp = 16, dop_damage = 0, flag;
    private MediaPlayer knop, lose, win;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        name1 = intent.getStringExtra("name1");
        text_okn1 = (TextView)findViewById(R.id.textView9);
        text_okn2 = (TextView)findViewById(R.id.textView10);
        text_name = (TextView)findViewById(R.id.textView6);
        text_hp2 = (TextView)findViewById(R.id.textView8);
        text_hp1 = (TextView)findViewById(R.id.textView7);
        zvuk = intent.getStringExtra("zvuk");
        text_name.setText(name1+":");
        knop = MediaPlayer.create(this, R.raw.knopka);
        lose = MediaPlayer.create(this, R.raw.lose);
        win = MediaPlayer.create(this, R.raw.win);
        onButton();
    }

    public void onButton() {
        update();
        btn1 = (Button)findViewById(R.id.button9);
        btn2 = (Button)findViewById(R.id.button10);
        btn3 = (Button)findViewById(R.id.button6);
        btn4 = (Button)findViewById(R.id.button7);
        btn5 = (Button)findViewById(R.id.button12);
        btn6 = (Button)findViewById(R.id.button13);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)){ SoundPlay(knop);}
                        AlertDialog.Builder a1_builder = new AlertDialog.Builder(GameActivity.this);
                        a1_builder.setMessage("Хотите покинуть игру?").setCancelable(false).setPositiveButton("Да", new DialogInterface.OnClickListener(){
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
        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)) { SoundPlay(knop);}
                        update();
                    }
                }
        );

        btn3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)) { SoundPlay(knop);}
                        if(flag == 1) {
                            int random_number1 = 1 + (int) (Math.random() * 4);
                            if (random_number1 == 4) {
                                text_okn2.setText("Противник поставил блок");
                                int random_number2 = 1 + (int) (Math.random() * 12);
                                if (random_number2 == 12) {
                                    vrag_hp -= 1;
                                    text_okn1.setText("Вы нанесли -1");
                                } else {
                                    text_okn1.setText("Вы не пробили");
                                }
                            } else {
                                right(1);
                                switch (random_number1) {
                                    case 1:
                                        right(2);break;
                                    case 2:
                                        left(2);break;
                                    case 3:
                                        leg(2);break;
                                }
                            }
                            win_lose();
                            text_hp2.setText("Здоровье: " + vrag_hp );
                            text_hp1.setText("Здоровье: " + player_hp);
                        }else{
                            if(vrag_hp <=0)
                                text_hp2.setText("Здоровье: 0");
                            if(player_hp <=0)
                                text_hp1.setText("Здоровье: 0");
                        }

                    }
                }
        );
        btn4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)) { SoundPlay(knop);}
                        if(flag == 1) {
                            int random_number1 = 1 + (int) (Math.random() * 4);
                            if (random_number1 == 4) {
                                text_okn2.setText("Враг поставил блок");
                                int random_number2 = 1 + (int) (Math.random() * 12);
                                if (random_number2 == 12) {
                                    vrag_hp -= 1;
                                    text_okn1.setText("Вы нанесли -1");
                                } else {
                                    text_okn1.setText("Вы не пробили");
                                }
                            } else {
                                left(1);
                                switch (random_number1) {
                                    case 1:
                                        right(2);break;
                                    case 2:
                                        left(2);break;
                                    case 3:
                                        leg(2);break;
                                }
                            }
                            win_lose();
                            text_hp2.setText("Здоровье: " + vrag_hp );
                            text_hp1.setText("Здоровье: " + player_hp);
                        }else{
                            if(vrag_hp <=0)
                                text_hp2.setText("Здоровье: 0");
                            if(player_hp <=0)
                                text_hp1.setText("Здоровье: 0");
                        }

                    }
                }
        );
        btn5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)) { SoundPlay(knop);}
                        if(flag == 1) {
                            int random_number1 = 1 + (int) (Math.random() * 4);
                            if (random_number1 == 4) {
                                text_okn2.setText("Противник поставил блок");
                                int random_number2 = 1 + (int) (Math.random() * 12);
                                if (random_number2 == 12) {
                                    vrag_hp -= 1;
                                    text_okn1.setText("Вы нанесли -1");
                                } else {
                                    text_okn1.setText("Вы не пробили");
                                }
                            } else {
                                leg(1);
                                switch (random_number1) {
                                    case 1:
                                        right(2);break;
                                    case 2:
                                        left(2);break;
                                    case 3:
                                        leg(2);break;
                                }
                            }
                            win_lose();
                            text_hp2.setText("Здоровье: " + vrag_hp );
                            text_hp1.setText("Здоровье: " + player_hp);
                        }else{
                            if(vrag_hp <=0)
                                text_hp2.setText("Здоровье: 0");
                            if(player_hp <=0)
                                text_hp1.setText("Здоровье: 0");
                        }

                    }
                }
        );
        btn6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if("1".equals(zvuk)) { SoundPlay(knop);}
                        if(flag == 1) {
                            text_okn1.setText("Вы поставили блок");
                            int random_number1 = 1 + (int) (Math.random() * 4);
                            if (random_number1 == 4) {
                                text_okn2.setText("Противник поставил блок");
                            } else {
                                int random_number2 = 1 + (int) (Math.random() * 12);
                                if (random_number2 == 12) {
                                    player_hp -= 1;
                                    text_okn2.setText("Противник нанёс -1");
                                } else {
                                    text_okn2.setText("Противник не пробил");
                                }
                            }
                            win_lose();
                            text_hp2.setText("Здоровье: " + vrag_hp );
                            text_hp1.setText("Здоровье: " + player_hp);
                        }else{
                            if(vrag_hp <=0)
                                text_hp2.setText("Здоровье: 0");
                            if(player_hp <=0)
                                text_hp1.setText("Здоровье: 0");
                        }

                    }
                }
        );
    }
    public void win_lose(){
        if(player_hp <= 0 && vrag_hp <= 0){
            flag = 0;
            text_okn1.setText("Ничья");
            text_okn2.setText("Ничья");
            text_hp1.setText("Здоровье: 0");
            text_hp2.setText("Здоровье: 0");
            SoundPlay(win);
        }else {
            if (player_hp <= 0) {
                text_hp1.setText("Здоровье: 0");
                text_okn1.setText("Вы проиграли");
                text_okn2.setText("Противник победил");
                if ("1".equals(zvuk)) {
                    SoundPlay(lose);
                }
                flag = 0;
            } else {
                if (vrag_hp <= 0) {
                    flag = 0;
                    text_hp2.setText("Здоровье: 0" );
                    text_okn1.setText("Вы выиграли");
                    text_okn2.setText("Противник поражен");
                    if ("1".equals(zvuk)) {
                        SoundPlay(win);
                    }
                }
            }
        }
    }
    public void leg(int i){
        int random_number1 = 1 + (int) (Math.random() * 12);
        if(random_number1 < 9 ){
            if(i == 1) {
                text_okn1.setText("Вы промахнулись!");
            }else{
                text_okn2.setText("Противник промахнулся!");
            }
        }else {if(random_number1 >= 9 && random_number1 <= 11){
            if(i == 1){
                vrag_hp -= (3 + dop_damage);
                int n = 3 + dop_damage;
                text_okn1.setText("Удар ногой на -" + n);
            }else{
                player_hp -= 3;
                text_okn2.setText("Удар ногой на -3");
            }
        }else {
            if (random_number1 == 12) {
                if (i == 1) {
                    vrag_hp -= (4 + dop_damage);
                    int n = 4 + dop_damage;
                    text_okn1.setText("КРИТ ногой на -" + n);
                } else {
                    player_hp -= 4;
                    text_okn2.setText("КРИТ ногой на -4");
                }
            }
        }
        }
    }
    public void left(int i){
        int random_number1 = 1 + (int) (Math.random() * 12);
        if(random_number1 < 5 ){
            if(i == 1) {
                text_okn1.setText("Вы промахнулись!");
            }else{
                text_okn2.setText("Противник промахнулся!");
            }
        }else {if(random_number1 >= 5 && random_number1 <= 11){
            if(i == 1){
                vrag_hp -= (1 + dop_damage);
                int n = 1 + dop_damage;
                text_okn1.setText("Удар левой на -" + n);
            }if(i == 2){
                player_hp -= 1;
                text_okn2.setText("Удар левой на -1");
            }
        }else {
            if (random_number1 == 12) {
                if (i == 1) {
                    vrag_hp -= (2 + dop_damage);
                    int n = 2 + dop_damage;
                    text_okn1.setText("КРИТ левой на -" + n);
                } else {
                    player_hp -= 2;
                    text_okn2.setText("КРИТ левой на -2");
                }
            }
        }
        }
    }

    public void right(int i){
        int random_number1 = 1 + (int) (Math.random() * 12);
        if(random_number1 < 5 ){
            if(i == 1) {
                text_okn1.setText("Вы промахнулись!");
            }else{
                text_okn2.setText("Противник промахнулся!");
            }
        }else {if(random_number1 >= 5 && random_number1 <= 11){
            if(i == 1){
                vrag_hp -= (2 + dop_damage);
                int n = 2 + dop_damage;
                text_okn1.setText("Удар правой на -" + n);
            }else{
                player_hp -= 2;
                text_okn2.setText("Удар правой на -2");
            }
        }else {
            if (random_number1 == 12) {
                if (i == 1) {
                    vrag_hp -= (3 + dop_damage);
                    int n = 3 + dop_damage;
                    text_okn1.setText("КРИТ правой на -" + n);
                } else {
                    player_hp -= 3;
                    text_okn2.setText("КРИТ правой на -3");
                }
            }
            }
        }
    }

    public void update(){
        flag = 1;
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

        switch (name1){
            case "Медведь":
                vrag_hp = 8;
                break;
            case "Хабиб" :
                vrag_hp = 16;
                break;
            case "Фёдор Емельяненко":
                vrag_hp = 32;
                break;
        }

        if(chit == 1 || chit == 3){
            player_hp = 999999;
        }
        else{
            player_hp = 16;
        }
        if(chit == 2 || chit == 3){
            dop_damage = 32;
        }
        text_hp1.setText("Здоровье: " + player_hp);
        text_hp2.setText("Здоровье: " + vrag_hp );
        text_okn1.setText("Бой сейчас начнётся");
        text_okn2.setText("Бой сейчас начнётся");
    }
    public void SoundPlay(MediaPlayer sound){
        sound.start();
    }
}