package com.example.petbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class SecActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        ArrayList<Mascota> mascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("mascotas");
        ArrayList<Mascota> favoritos = (ArrayList<Mascota>) getIntent().getSerializableExtra("favoritos");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Inicializar LayoutManager
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        // Inicializar Adaptador
         /*MascotaAdaptador adaptador = new MascotaAdaptador(favoritos);
        recyclerView.setAdapter(adaptador); */


        MaterialToolbar toolBar = (MaterialToolbar) findViewById(R.id.topAppBar);
        toolBar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecActivity.this, MainActivity.class);
                i.putExtra("mascotas", mascotas);
                i.putExtra("favoritos", favoritos);
                startActivity(i);
            }
        });
    }
}
