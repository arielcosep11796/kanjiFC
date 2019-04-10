package com.cosep.kanjiflashcard;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.huxq17.swipecardsview.BaseCardAdapter;

import java.util.List;

import static android.content.ContentValues.TAG;

public class CardAdapter extends BaseCardAdapter {

    private List<Model> modelList;
    private Context context;

    public CardAdapter(List<Model> modelList,Context context) {
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
            hiragana.setVisibility(TextView.INVISIBLE);
            final TextView imi = cardview.findViewById(R.id.imi);
            imi.setVisibility(TextView.INVISIBLE);
            Model model = modelList.get(position);
            kanji.setText(model.getKanji());
            hiragana.setText(model.getHiragana());
            imi.setText(model.getImi());
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
