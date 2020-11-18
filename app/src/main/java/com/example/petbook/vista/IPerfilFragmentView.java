package com.example.petbook.vista;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petbook.adapters.PublicacionAdapter;
import com.example.petbook.pojo.Publicacion;

import java.util.ArrayList;

public interface IPerfilFragmentView {

    public GridLayoutManager crearGridLayoutManager(View v, int col);

    public PublicacionAdapter crearAdaptador(ArrayList<Publicacion> publicaciones);

    public void inicializarRecyclerView(RecyclerView rv, GridLayoutManager glm, PublicacionAdapter publicacionAdapter);

}
