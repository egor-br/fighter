package com.example.fighter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PravActivity extends AppCompatActivity {

    private Button btn;
    private String zvuk = "1";
    private MediaPlayer knop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prav);
        Intent intent = getIntent();
        btn = (Button) findViewById(R.id.button8);
        zvuk = intent.getStringExtra("zvuk");
        knop = MediaPlayer.create(this, R.raw.knopka);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ("1".equals(zvuk)) {
                            SoundPlay(knop);
                        }
                        AlertDialog.Builder a1_builder = new AlertDialog.Builder(PravActivity.this);
                        a1_builder.setMessage("Хотите вернуться в меню?").setCancelable(false).setPositiveButton("Да", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setNegativeButton("Нет", new DialogInterface.OnClickListener() {
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
    }

    public void SoundPlay(MediaPlayer sound) {
        sound.start();
    }
}