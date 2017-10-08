package com.example.dhadotid.recycleview.Model;

/**
 * Created by HateLogcatError on 10/8/2017.
 */

public class EvaluasiModel {

    int idevaluasi;
    int idinformasi;
    String pertanyaan;
    String jawabana;
    String jawabanb;
    String jawabanc;
    String jawabanbenar;

    public EvaluasiModel(int idevaluasi, int idinformasi, String pertanyaan, String jawabana, String jawabanb, String jawabanc, String jawabanbenar) {
        this.idevaluasi = idevaluasi;
        this.idinformasi = idinformasi;
        this.pertanyaan = pertanyaan;
        this.jawabana = jawabana;
        this.jawabanb = jawabanb;
        this.jawabanc = jawabanc;
        this.jawabanbenar = jawabanbenar;
    }

    public int getIdevaluasi() {
        return idevaluasi;
    }

    public int getIdinformasi() {
        return idinformasi;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public String getJawabana() {
        return jawabana;
    }

    public String getJawabanb() {
        return jawabanb;
    }

    public String getJawabanc() {
        return jawabanc;
    }

    public String getJawabanbenar() {
        return jawabanbenar;
    }
}
