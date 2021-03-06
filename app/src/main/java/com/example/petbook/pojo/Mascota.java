package com.example.petbook.pojo;

import java.io.Serializable;


public class Mascota implements Serializable { // Serializable permite que Mascota sea "parselable" para enviar el ArrayList a través del Intent
    // Atributos
    private int id;
    private String nombre;
    private int foto;
    private int huesos;


    public Mascota(int id, String nombre, int foto, int huesos) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.huesos = huesos;
    }

    /**
     * Constructor para insertar datos dummy
     * @param nombre
     * @param foto
     */
    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    /**
     * Constructor para recuperar datos de la DB
     */
    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void darHueso(){
        this.setHuesos(this.getHuesos() + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mascota)) return false;
        Mascota mascota = (Mascota) o;
        return foto == mascota.foto &&

                nombre.equals(mascota.nombre);
    }
}
