package com.example.petbook.vista;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petbook.pojo.Mascota;
import com.example.petbook.R;
import com.example.petbook.adapters.MascotaAdapter;
import com.example.petbook.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment  extends Fragment implements IRecyclerViewFragmentView{

    private ArrayList<Mascota> favoritos;
    private RecyclerView recyclerView;
    private RecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment(ArrayList<Mascota> favoritos) {
        this.favoritos = favoritos;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container,false); //Esto sería como un setContentView en una activity
        recyclerView = v.findViewById(R.id.recyclerView);
        presenter = new RecyclerViewFragmentPresenter(this, this.getContext(), favoritos);
        presenter.obtenerContactosDB();
        return v;
    }

    @Override
    public LinearLayoutManager crearLinearLayoutManagerVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        return llm;
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, favoritos);
        return adapter;
    }

    @Override
    public void inicializarRecyclerView(LinearLayoutManager llm, MascotaAdapter mascotaAdapter) {
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(mascotaAdapter);
    }
}
