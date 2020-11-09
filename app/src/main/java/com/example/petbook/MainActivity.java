package com.example.petbook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciamos los objetos
        ArrayList<Mascota> mascotas;
        ArrayList<Mascota> favoritos;

        if (getIntent().getExtras() == null) {
            mascotas = new ArrayList<>();
            favoritos = new ArrayList<>();
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
        } else {
            mascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("mascotas");
            favoritos = (ArrayList<Mascota>) getIntent().getSerializableExtra("favoritos");
        }

        //

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Inicializar LayoutManager
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        // Inicializar Adaptador
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, favoritos);
        recyclerView.setAdapter(adaptador);

        // Menú

        MaterialToolbar toolBar = (MaterialToolbar) findViewById(R.id.topAppBar);
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.favoritos:

                        Intent i = new Intent(MainActivity.this, SecActivity.class);
                        i.putExtra("mascotas", mascotas);
                        i.putExtra("favoritos", favoritos);
                        startActivity(i);

                        return true;

                    case R.id.more:
                        // User chose the "Favorite" action, mark the current item
                        // as a favorite...
                        return true;

                    /* default:
                        // If we got here, the user's action was not recognized.
                        // Invoke the superclass to handle it.
                        return super.onOptionsItemSelected(item); */

                }
                return false;
            }
        });
    }


}