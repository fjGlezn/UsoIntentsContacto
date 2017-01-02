package com.fjglezn.identidadpersonalizada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String fecha = parametros.getString(getResources().getString(R.string.pfechanace));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descrip = parametros.getString(getResources().getString(R.string.pdecrip));


        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFechaNacimientoValor);
        tvTelefono = (TextView) findViewById(R.id.tvTelefonoValor);
        tvEmail = (TextView) findViewById(R.id.tvEmailValor);
        tvDesc = (TextView) findViewById(R.id.tvDescripcionValor);

        tvNombre.setText(nombre);//Recibe los parametros que esta recibiendo
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDesc.setText(descrip);


        //Realiza la misma función que el boton back
        Button MyOnBackButton = (Button) findViewById(R.id.btnEditar);
        MyOnBackButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                //Añade más funcionalidades
            }
        });

    }

}
