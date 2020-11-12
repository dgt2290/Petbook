package com.example.petbook.pojo;

import java.io.Serializable;

public class Publicacion implements Serializable {
    private int foto;
    private int huesos;

    public Publicacion(int foto, int huesos) {
        this.foto = foto;
        this.huesos = huesos;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getHuesos() {
        return huesos;
    }

    public void setHuesos(int huesos) {
        this.huesos = huesos;
    }
}
