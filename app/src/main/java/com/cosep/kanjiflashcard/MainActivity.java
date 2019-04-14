package com.cosep.kanjiflashcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        TinyDB db = new TinyDB(getApplicationContext());


        CardView mixedKanjiBtn =  findViewById(R.id.mixedKanjiCard);
        mixedKanjiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), FlashCardView.class);
                i.putExtra("mode",2);
                startActivity(i);
            }
        });
        CardView kotobaBtn = findViewById(R.id.kotobaCard);
        kotobaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), FlashCardView.class);
                i.putExtra("mode",3);
                startActivity(i);
            }
        });
        CardView testBtn = findViewById(R.id.testBtn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), FlashCardView.class);
                i.putExtra("mode",4);
                startActivity(i);
            }
        });
    }


}
