package com.cosep.kanjiflashcard;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.huxq17.swipecardsview.SwipeCardsView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlashCardView extends AppCompatActivity {
    private SwipeCardsView swipeCardsView;
    private List<Model> modelList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        try {
            modelList = readCsv("漢字復習.csv");
        }catch(IOException e){

        }
        swipeCardsView = findViewById(R.id.swpcard);
        swipeCardsView.retainLastCard(true);
        swipeCardsView.enableSwipe(true);



        Intent intent = getIntent();
        int mode = intent.getExtras().getInt("mode");
        if(mode==1){
            CardAdapter2 cardAdapter2 = new CardAdapter2(modelList,getApplicationContext());
            swipeCardsView.setAdapter(cardAdapter2);
        }else{
            Collections.shuffle(modelList);
            CardAdapter cardAdapter = new CardAdapter(modelList,getApplicationContext());
            swipeCardsView.setAdapter(cardAdapter);
        }

    }

    private List<Model> readCsv(String filename) throws IOException{
        InputStream is = getApplicationContext().getAssets().open(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line="";
        List<Model> modelList = new ArrayList<>();
        try{
            while((line = reader.readLine())!=null){
                String[] tokens = line.split(",");
                StringBuilder meaning = new StringBuilder().append(tokens[2]);
                int i=3;
                while(i<tokens.length){
                    meaning.append(", "+tokens[i]);
                    i++;
                }
                modelList.add(new Model(tokens[1],tokens[0],meaning.toString().replace("\"","")));
            }
        }catch(IOException e){

        }
        return modelList;
    }
}
