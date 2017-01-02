package com.fjglezn.identidadpersonalizada;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText input_name, input_phone, input_email, input_descripcion;
    Button btnSiguiente, btnFecha;
    TextView input_fecha;
    private int dia, anio, mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_name = (EditText) findViewById(R.id.input_name);
        input_fecha = (TextView) findViewById(R.id.input_fecha);
        input_phone = (EditText) findViewById(R.id.input_phone);
        input_email = (EditText) findViewById(R.id.input_email);
        input_descripcion = (EditText) findViewById(R.id.input_descripcion);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnFecha = (Button) findViewById(R.id.btnFecha);


        //Escuchadores
        btnFecha.setOnClickListener(this);


    }


    public void onClickSiguiente(View view)
    {
        String auxNombre = input_name.getText().toString();
        String auxFecha  = input_fecha.getText().toString();
        String auxPhone = input_phone.getText().toString();
        String auxEmail = input_email.getText().toString();
        String auxDescrip = input_descripcion.getText().toString();

        Intent i = new Intent(this, ConfirmarDatos.class);

        i.putExtra(getResources().getString(R.string.pnombre), auxNombre);
        i.putExtra(getResources().getString(R.string.pfechanace), auxFecha);
        i.putExtra(getResources().getString(R.string.ptelefono), auxPhone);
        i.putExtra(getResources().getString(R.string.pemail), auxEmail);
        i.putExtra(getResources().getString(R.string.pdecrip), auxDescrip);

        startActivity(i);
    }



    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {

        if(v == btnFecha)
        {
            final Calendar c = Calendar.getInstance();//Instancia de la clase calendar

            dia=c.get(Calendar.DAY_OF_MONTH);
            mes =c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    input_fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }, dia, mes, anio);
            datePickerDialog.show();

        }

    }
}
