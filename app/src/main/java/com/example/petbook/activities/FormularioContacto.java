package com.example.petbook.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.petbook.R;
import com.example.petbook.pojo.Mascota;
import com.example.petbook.pojo.ProcessEmail;
import com.example.petbook.pojo.Publicacion;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormularioContacto extends AppCompatActivity {

    Intent i;
    MaterialToolbar toolBar;
    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> favoritos;
    ArrayList<Publicacion> publicaciones;
    private static int FILE_SELECT_CODE;
    private static int SELECT_PICTURE;
    String FilePath;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_formulario);

        TextInputEditText nombre = (TextInputEditText) findViewById(R.id.formTxtImputNombre);
        TextInputEditText mail = (TextInputEditText) findViewById(R.id.formTxtImputEmail);
        TextInputEditText msj = (TextInputEditText) findViewById(R.id.formTxtImputMsj);

        mascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("mascotas");
        favoritos = (ArrayList<Mascota>) getIntent().getSerializableExtra("favoritos");
        publicaciones = (ArrayList<Publicacion>) getIntent().getSerializableExtra("publicaciones");

        Button enviar = (Button) findViewById(R.id.btnEnviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromEmail = "dgt2290@gmail.com";
                String fromPassword = "KEV893OOS292";
                List<String> toEmails = new ArrayList();
                toEmails.add("dgt2290@gmail.com");
                String emailSubject = "Nuevo comentario de "+nombre.toString();
                String emailBody = "Email: "+mail.toString()+"\nMensaje: "+msj.toString();
                new ProcessEmail(FormularioContacto.this).execute(
                        fromEmail, fromPassword, toEmails, emailSubject, emailBody, FilePath);
            }
        });

        //ImageButton selectFile= (ImageButton) findViewById(R.id.selectFile);
        //selectFile.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //intent.setType("*/*");
                //startActivityForResult(intent, FILE_SELECT_CODE);
            //}
        //});

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
                Intent i = new Intent(FormularioContacto.this, MainActivity.class);
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

                        i = new Intent(FormularioContacto.this, SecActivity.class);
                        i.putExtra("mascotas", mascotas);
                        i.putExtra("favoritos", favoritos);
                        i.putExtra("publicaciones", publicaciones);
                        startActivity(i);

                        return true;

                    case R.id.contacto:

                        return true;

                    case R.id.about:

                        i = new Intent(FormularioContacto.this, About.class);
                        i.putExtra("mascotas", mascotas);
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
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == FILE_SELECT_CODE) && (resultCode == -1)) {
            FilePath = data.getData().getPath();
            //Toast.makeText(this, FilePath, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar, menu);
        return true;
    }
}