package com.example.petbook.presentador;

import com.example.petbook.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentPresenter {

    public void obtenerContactosDB();

    public void mostrarContactosRV(ArrayList<Mascota> mascotas);

}
