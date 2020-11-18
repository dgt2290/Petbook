package com.example.petbook.vista;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petbook.adapters.MascotaAdapter;
import com.example.petbook.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public LinearLayoutManager crearLinearLayoutManagerVertical();

    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarRecyclerView(LinearLayoutManager llm, MascotaAdapter mascotaAdapter);
}
