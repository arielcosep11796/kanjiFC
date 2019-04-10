package com.cosep.kanjiflashcard;

public class Model {

    private String kanji,hiragana,imi;

    public Model(String kanji,String hiragana,String imi){
        this.kanji = kanji;
        this.hiragana = hiragana;
        this.imi = imi;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getHiragana() {
        return hiragana;
    }

    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }

    public String getImi() {
        return imi;
    }

    public void setImi(String imi) {
        this.imi = imi;
    }

}
