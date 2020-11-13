package com.example.petbook.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.petbook.R;
import com.example.petbook.pojo.Mascota;
import com.example.petbook.pojo.Publicacion;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class About extends AppCompatActivity {

    Intent i;
    MaterialToolbar toolBar;
    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> favoritos;
    ArrayList<Publicacion> publicaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("mascotas");
        favoritos = (ArrayList<Mascota>) getIntent().getSerializableExtra("favoritos");
        publicaciones = (ArrayList<Publicacion>) getIntent().getSerializableExtra("publicaciones");

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setVerticalScrollBarEnabled(false);
        webView.loadData(getString(R.string.bio), "text/html; charset=utf-8", "utf-8");


        // AppBar
        toolBar = (MaterialToolbar) findViewById(R.id.topAppBar);
        // Modificamos el ícono del menú de opciones con las siguientes dos líneas
        Drawable iconoMenuOpciones = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_more_vert);
        toolBar.setOverflowIcon(iconoMenuOpciones);
        // Modificamos el ícono de navegación y le asignamos comportamiento
        toolBar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About.this, MainActivity.class);
                i.putExtra("mascotas", mascotas);
                i.putExtra("favoritos", favoritos);
                i.putExtra("publicaciones", publicaciones);
                startActivity(i);
            }
        });
        // Definimos las acciones que se ejecutarán según el elemento seleccionado del menú
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.favoritos:

                        i = new Intent(About.this, SecActivity.class);
                        i.putExtra("mascotas", mascotas);
                        i.putExtra("favoritos", favoritos);
                        i.putExtra("publicaciones", publicaciones);
                        startActivity(i);
                        return true;

                    case R.id.contacto:

                        i = new Intent(About.this, FormularioContacto.class);
                        i.putExtra("mascotas", mascotas);
                        i.putExtra("favoritos", favoritos);
                        i.putExtra("publicaciones", publicaciones);
                        startActivity(i);

                        return true;

                    case R.id.about:

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
