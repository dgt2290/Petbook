package com.example.petbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

public class FormularioContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        TextInputEditText formTxtImputNombre = (TextInputEditText) findViewById(R.id.formTxtImputNombre);
        TextInputEditText formTxtImputEmail = (TextInputEditText) findViewById(R.id.formTxtImputEmail);
        TextInputEditText formTxtImputMsj = (TextInputEditText) findViewById(R.id.formTxtImputMsj);

        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        /* btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i.putExtra("pnombre", formTxtImputNombre.getText().toString());
                i.putExtra("pemail", formTxtImputEmail.getText().toString());
                i.putExtra("pdes", formTxtImputMsj.getText().toString());


                //Iniciamos la actividad
                startActivity(i);
            }
        }); */

    }

}