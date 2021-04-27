package com.example.mesplanetes;

public class Planetes {
    private String nom;
    private String description;
    private String taille;
    private String vitesse;
    private int image;

    Planetes(String text1,String text2,String text3,String text4, int image1){
        nom=text1;
        description=text2;
        image=image1;
        taille=text3;
        vitesse=text4;

    }


    public String getNom() {
        return nom;
    }
    public String getDescription() {
        return description;
    }
    public int  getImage() {
        return image;
    }
    public String getTaille() {
        return taille;
    }
    public String getVitesse() {
        return vitesse;
    }

}
