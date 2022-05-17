package com.example.cardview_cards;

public class Cards {

    private String nombre;
    private int danio;
    private int imgBackground;

    public Cards(String nombre, int danio, int imgBackground) {
        this.nombre = nombre;
        this.danio = danio;
        this.imgBackground = imgBackground;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getImgBackground() {
        return imgBackground;
    }

    public void setImgBackground(int imgBackground) {
        this.imgBackground = imgBackground;
    }
}
