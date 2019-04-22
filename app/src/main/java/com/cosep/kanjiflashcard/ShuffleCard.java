package com.cosep.kanjiflashcard;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.huxq17.swipecardsview.BaseCardAdapter;

import java.util.List;

import static android.content.ContentValues.TAG;

public class ShuffleCard extends BaseCardAdapter {

    private List<Model> modelList;
    private Context context;

    public ShuffleCard(List<Model> modelList,Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public int getCardLayoutId() {
        return R.layout.card_view;
    }

    @Override
    public void onBindData(int position, View cardview) {
        if(modelList!=null||modelList.size()!=0){
            TextView kanji = cardview.findViewById(R.id.kanji);
            final TextView hiragana = cardview.findViewById(R.id.hiragana);
            final TextView imi = cardview.findViewById(R.id.imi);
            Model model = modelList.get(position);
            imi.setVisibility(TextView.INVISIBLE);
            hiragana.setVisibility(TextView.INVISIBLE);
            if(model.getKanji()==null || model.getKanji().isEmpty()){
                kanji.setText(model.getHiragana());
                hiragana.setText(model.getImi());
                imi.setText("");
            }else{
                kanji.setText(model.getKanji());
                hiragana.setText(model.getHiragana());
                imi.setText(model.getImi());
            }
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hiragana.setVisibility(TextView.VISIBLE);
                    imi.setVisibility(TextView.VISIBLE);
                }
            });
        }

    }
}
