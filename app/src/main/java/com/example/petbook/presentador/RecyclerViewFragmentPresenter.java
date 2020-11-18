package com.example.petbook.presentador;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.petbook.R;
import com.example.petbook.activities.MainActivity;
import com.example.petbook.adapters.PagerAdapter;
import com.example.petbook.db.InteractorMascotas;
import com.example.petbook.pojo.Mascota;
import com.example.petbook.vista.IRecyclerViewFragmentView;
import com.example.petbook.vista.PerfilFragment;
import com.example.petbook.vista.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> favoritos;
    private IRecyclerViewFragmentView irvfv;
    private Context context;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView irvfv, Context context, ArrayList<Mascota> favoritos) {
        this.irvfv = irvfv;
        this.context = context;
        this.favoritos = favoritos;
    }

    @Override
    public void obtenerContactosDB() {
        if (context instanceof MainActivity) {
            InteractorMascotas interactorMascotas = new InteractorMascotas(context);
            mascotas = interactorMascotas.obtenerDatos();
            mostrarContactosRV(mascotas);
        } else {
            mostrarContactosRV(favoritos);
        }
    }

    @Override
    public void mostrarContactosRV(ArrayList<Mascota> mascotas) {
        irvfv.inicializarRecyclerView(irvfv.crearLinearLayoutManagerVertical(), irvfv.crearAdaptador(mascotas));
    }
}

