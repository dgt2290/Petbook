package com.example.petbook.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.petbook.activities.FormularioContacto;
import com.example.petbook.pojo.Mascota;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    private Context context;

    public DataBase(Context context) {
        super(context, ConstantesDB.DATABASE_NAME, null, ConstantesDB.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesDB.TABLE_PETS + "(" +
                                                        ConstantesDB.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        ConstantesDB.TABLE_PETS_NOMBRE + " TEXT," +
                                                        ConstantesDB.TABLE_PETS_PHOTO + " INTEGER," +
                                                        ConstantesDB.TABLE_PETS_BONES + " INTEGER" +
                                                        ")";

        db.execSQL(queryCrearTablaMascota);
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesDB.TABLE_PETS);
        onCreate(db);
    }

    /**
     * Recorre la tabla Mascotas e instancia cada uno de sus elementos
     * para luego ir agregándolos a un ArrayList y retornar dicha lista
     *
     * @return
     */
    public ArrayList<Mascota> obtenerMascotas (){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesDB.TABLE_PETS;
        SQLiteDatabase db = getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascota = new Mascota();
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));
            mascota.setFoto(registros.getInt(2));
            mascota.setHuesos(registros.getInt(3));
            mascotas.add(mascota);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_PETS, null, contentValues);
        db.close();
    }

    public void actualizarMascota (ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesDB.TABLE_PETS, contentValues, ConstantesDB.TABLE_PETS_ID + "=" + contentValues.get("Id"), null);
        db.close();
    }

    public boolean checkEmpty(){
        boolean bool;
        SQLiteDatabase db = this.getWritableDatabase();
        if (DatabaseUtils.queryNumEntries(db, ConstantesDB.TABLE_PETS) == 0) {
            bool = true;
        } else {
            bool = false;
        }
        db.close();
        return bool;
    }
}
