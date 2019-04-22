package com.cosep.kanjiflashcard;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.huxq17.swipecardsview.BaseCardAdapter;

import java.util.List;

public class ShowCardSingleKanji extends BaseCardAdapter {

    private List<ModelB> modelList;

    public ShowCardSingleKanji(List<ModelB> modelList,Context context) {
        this.modelList = modelList;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public int getCardLayoutId() {
        return R.layout.card_view_single_kanji;
    }

    @Override
    public void onBindData(int position, View cardview) {
        if(modelList!=null||modelList.size()!=0){
            TextView kanji = cardview.findViewById(R.id.kanji);
            TextView onyumi = cardview.findViewById(R.id.onyumi);
            TextView kunyumi = cardview.findViewById(R.id.kunyumi);
            TextView imi = cardview.findViewById(R.id.imi);
            ModelB model = modelList.get(position);
            kanji.setText(model.getKanji());
            onyumi.setText(model.getOnyumi());
            kunyumi.setText(model.getKunyumi());
            imi.setText(model.getImi());
        }

    }
}