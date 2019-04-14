package com.cosep.kanjiflashcard;

public class ModelB {

    private String kanji,onyumi,kunyumi,imi;

    public ModelB(String kanji,String onyumi,String kunyumi,String imi){
        this.kanji = kanji;
        this.onyumi = onyumi;
        this.kunyumi = kunyumi;
        this.imi = imi;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getOnyumi() {
        return onyumi;
    }

    public void setOnyumi(String onyumi) {
        this.onyumi = onyumi;
    }

    public String getKunyumi() {
        return kunyumi;
    }

    public void setKunyumi(String kunyumi) {
        this.kunyumi = kunyumi;
    }

    public String getImi() {
        return imi;
    }

    public void setImi(String imi) {
        this.imi = imi;
    }

}
