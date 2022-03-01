package com.example.fighter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Button button, button2;
    private MediaPlayer knop;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        knop = MediaPlayer.create(this, R.raw.knopka);
        onButton();
    }

     public void onButton() {
        button =(Button)findViewById(R.id.button);
        button2 =(Button)findViewById(R.id.button2);
        text = (EditText)findViewById(R.id.editTextPersonName);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SoundPlay(knop);
                        String name = text.getText().toString();
                        String nm = "";
                        int len = name.length();
                        if(nm.equals(name)){
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Имя не введено", Toast.LENGTH_SHORT);
                            toast.show();
                        }else{
                            if(len <= 20) {
                                Intent intent = new Intent(MainActivity.this, menu.class);
                                intent.putExtra("name", name);
                                startActivity(intent);
                            }else{
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Имя игрока слишком большое", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }

                    }
                }
        );

        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SoundPlay(knop);
                        AlertDialog.Builder a1_builder = new AlertDialog.Builder(MainActivity.this);
                        a1_builder.setMessage("Хотите закрыть приложение?").setCancelable(false).setPositiveButton("Да", new DialogInterface.OnClickListener(){
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
                        al_builder.setTitle("Закрыть приложение");
                        al_builder.show();
                    }
                }
        );

     }
    public void SoundPlay(MediaPlayer sound){
        sound.start();
    }
}