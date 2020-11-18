package com.example.petbook.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.petbook.R;
import com.example.petbook.adapters.PagerAdapter;
import com.example.petbook.vista.PerfilFragment;
import com.example.petbook.vista.RecyclerViewFragment;
import com.example.petbook.pojo.Mascota;
import com.example.petbook.pojo.Publicacion;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SecActivity extends AppCompatActivity {

    Intent i;
    MaterialToolbar toolBar;
    ArrayList<Mascota> favoritos;
    ArrayList<Publicacion> publicaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        favoritos = (ArrayList<Mascota>) getIntent().getSerializableExtra("favoritos");
        publicaciones = (ArrayList<Publicacion>) getIntent().getSerializableExtra("publicaciones");

        // AppBar
        toolBar = (MaterialToolbar) findViewById(R.id.topAppBar);
        // Modificamos el ícono del menú de opciones con las siguientes dos líneas
        Drawable iconoMenuOpciones = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_more_vert);
        toolBar.setOverflowIcon(iconoMenuOpciones);
        // Modificamos el ícono de navegación y le asignamos comportamiento
        toolBar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecActivity.this, MainActivity.class);
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

                        return true;

                    case R.id.contacto:

                        i = new Intent(SecActivity.this, FormularioContacto.class);
                        i.putExtra("favoritos", favoritos);
                        i.putExtra("publicaciones", publicaciones);
                        startActivity(i);

                        return true;

                    case R.id.about:

                        i = new Intent(SecActivity.this, About.class);
                        i.putExtra("favoritos", favoritos);
                        i.putExtra("publicaciones", publicaciones);
                        startActivity(i);

                        return true;
                    /* default:
                        // If we got here, the user's action was not recognized.
                        // Invoke the superclass to handle it.
                        return super.onOptionsItemSelected(item); */

                }
                return false;
            }
        });

        /** Declaraciones para poner en funcionamiento los fragments.
         Al ViewPager se le pasa un FragmentAdapter al que a su vez le pasamos
         un ArrayList de Fragments (en este caso RecyclerViewFragment y PerfilFragment)
         */

        // Declaramos los Fragments
        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment(favoritos);
        PerfilFragment perfilFragment = new PerfilFragment(publicaciones);

        // Los agregamos a un ArrayList de Fragments
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(recyclerViewFragment);
        fragments.add(perfilFragment);

        // TabLayout y ViewPager son las clases que nos permiten switchear las vistas (fragments).
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);
        // Setear íconos en para cada columna del TabLayout
        int[] icons = {R.drawable.ic_photo_library, R.drawable.ic_pets} ;
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar, menu);
        return true;
    }
}
