package com.example.petbook.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petbook.R;
import com.example.petbook.adapters.PublicacionAdapter;
import com.example.petbook.pojo.Publicacion;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    ArrayList<Publicacion> publicaciones;

    public PerfilFragment(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        RecyclerView recyclerViewPerfil = v.findViewById(R.id.recyclerViewPerfil);
        recyclerViewPerfil.setAdapter(new PublicacionAdapter(publicaciones) );
        GridLayoutManager glm = new GridLayoutManager(v.getContext(), 2);
        recyclerViewPerfil.setLayoutManager(glm);
        return v;
    }
}