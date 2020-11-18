package com.example.petbook.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.petbook.R;
import com.example.petbook.pojo.Mascota;

import java.util.ArrayList;

public class InteractorMascotas {

    private Context contexto;
    private DataBase db;

    public InteractorMascotas(Context contexto) {
        this.contexto = contexto;
        db = new DataBase(contexto);
    }

    /**
     * Método que interactúa con la DB, construye y devuelve
     * un ArrayList de objetos del tipo Mascota
     *
     */
    public ArrayList<Mascota> obtenerDatos () {

        if (db.checkEmpty()) {
            insertarDatosDummy();
        }

        return db.obtenerMascotas();
    }

    /**
     * Genera un ArrayList<ContentValues> con datos dummy
     * para insertarlos en la DB
     */
    public void insertarDatosDummy () {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        // Datos de dummy
         mascotas.add(new Mascota("Rex", R.drawable.pastor_aleman));
         mascotas.add(new Mascota("Blanquito", R.drawable.blanquito));
         mascotas.add(new Mascota("Tweety", R.drawable.canario2));
         mascotas.add(new Mascota("Snoopy", R.drawable.beagle));
         mascotas.add(new Mascota("Fly", R.drawable.border_collie));
         mascotas.add(new Mascota("Clover", R.drawable.conejo));
         mascotas.add(new Mascota("Gumer", R.drawable.bulldog_frances));
         mascotas.add(new Mascota("Pirata", R.drawable.manchas));
         mascotas.add(new Mascota("Pelusa", R.drawable.pelusa));
         mascotas.add(new Mascota("Donald", R.drawable.duck));
         mascotas.add(new Mascota("Manchas", R.drawable.gatito_gris));
         mascotas.add(new Mascota("Marley", R.drawable.labrador));
         mascotas.add(new Mascota("Anabella I", R.drawable.hamster1));
         mascotas.add(new Mascota("Leonardo", R.drawable.tortuga));
         mascotas.add(new Mascota("Terminator", R.drawable.gatito_naranja));
         mascotas.add(new Mascota("Rocky", R.drawable.doberman));
         mascotas.add(new Mascota("Anabella II", R.drawable.hamster2));
         mascotas.add(new Mascota("Donatello", R.drawable.tortuga1));
         mascotas.add(new Mascota("Mica", R.drawable.siames));
         mascotas.add(new Mascota("Poly", R.drawable.loro));

        for (Mascota m: mascotas) {
            ContentValues contenedorDeValores = new ContentValues();
            contenedorDeValores.put(ConstantesDB.TABLE_PETS_NOMBRE, m.getNombre());
            contenedorDeValores.put(ConstantesDB.TABLE_PETS_PHOTO, m.getFoto());
            db.insertarMascota(contenedorDeValores);
        }
    }

    public void darHueso (Mascota mascota) {
        ContentValues contenedorDeValores = new ContentValues();
        contenedorDeValores.put(ConstantesDB.TABLE_PETS_ID, mascota.getId());
        contenedorDeValores.put(ConstantesDB.TABLE_PETS_BONES, mascota.getHuesos());
        db.actualizarMascota(contenedorDeValores);
    }
}
