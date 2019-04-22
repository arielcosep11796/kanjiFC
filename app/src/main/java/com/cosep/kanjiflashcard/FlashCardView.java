package com.cosep.kanjiflashcard;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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
    private List<ModelB> modelListB = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        swipeCardsView = findViewById(R.id.swpcard);
        swipeCardsView.retainLastCard(true);
        swipeCardsView.enableSwipe(true);
        Intent intent = getIntent();
        int mode = intent.getExtras().getInt("mode");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        try {
            String book = "";
            if(mode==1){
                book = "singleKanji.csv";
                modelListB = readCsvSingleKanji(book);
                ShowCardSingleKanji singleKanji = new ShowCardSingleKanji(modelListB,getApplicationContext());
                swipeCardsView.setAdapter(singleKanji);
            }else if(mode==2){
                book = "漢字復習.csv";
                modelList = readCsv(book);
                ShowCardMixedKanji mixedKanjis = new ShowCardMixedKanji(modelList,getApplicationContext());
                swipeCardsView.setAdapter(mixedKanjis);
            }else if(mode==3){
                book = "言葉.csv";
                modelList = readCsv(book);
                ShowCardKotoba kotobas = new ShowCardKotoba(modelList,getApplicationContext());
                swipeCardsView.setAdapter(kotobas);
            }else if(mode==4){
                modelList = readCsv("漢字復習.csv");
                modelList.addAll(readCsv("言葉.csv"));
                Collections.shuffle(modelList);
                ShuffleCard cardAdapter = new ShuffleCard(modelList,getApplicationContext());
                swipeCardsView.setAdapter(cardAdapter);
            }

        }catch(IOException e){
            e.printStackTrace();
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

    private List<ModelB> readCsvSingleKanji(String filename) throws IOException{
        InputStream is = getApplicationContext().getAssets().open(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line="";
        List<ModelB> modelList = new ArrayList<>();
        try{
            while((line = reader.readLine())!=null){
                String[] tokens = line.split(",");
                modelList.add(new ModelB(tokens[0],tokens[1].replace(";",", "),tokens[2].replace(";",", "),tokens[3]));
            }
        }catch(IOException e){

        }
        return modelList;
    }
}
