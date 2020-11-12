package com.example.petbook.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petbook.pojo.Mascota;
import com.example.petbook.R;
import com.example.petbook.adapters.MascotaAdapter;

import java.util.ArrayList;

public class RecyclerViewFragment  extends Fragment {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> favoritos;

    public RecyclerViewFragment(ArrayList<Mascota> mascotas, ArrayList<Mascota> favoritos) {
        this.mascotas = mascotas;
        this.favoritos = favoritos;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container,false); //Esto sería como un setContentView en una activity

        // Declaraciones para poner en funcionamiento el RecyclerView
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(v.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(new MascotaAdapter(mascotas, favoritos));
        recyclerView.setLayoutManager(llm);
        return v;
    }

}
