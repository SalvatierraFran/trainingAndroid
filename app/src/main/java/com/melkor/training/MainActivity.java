package com.melkor.training;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.melkor.training.Utils.AsynkConnector;
import com.melkor.training.Utils.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    /*
    Aplicacion base para Entrenamiento.

    Requerimientos:
        - Completar la funcionalidad de cada una de las secciones de la aplicacion definidas.
     */

    ProgressBar prgBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        añadirVistas();

        ((Button)findViewById(R.id.btn_toma_datos)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTomaDatos();
            }
        });

        ((Button)findViewById(R.id.btn_consume_service)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTask_load().execute();
                goToConsumeService();
            }
        });

        ((Button)findViewById(R.id.btn_DB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDB();
                
            }
        });

        ((Button)findViewById(R.id.btn_fragments)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFragments();
                
            }
        });
    }

    private void añadirVistas()
    {
        prgBar = (ProgressBar)findViewById(R.id.progressBar);
        prgBar.setVisibility(View.GONE);
        prgBar.setProgress(0);
    }

    public class AsyncTask_load extends AsyncTask<Void, Integer, Void>
    {
        int progreso;

        @Override
        protected void onPreExecute()
        {
            progreso = 0;
            prgBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {
            while(progreso < 100)
            {
                progreso++;
                publishProgress(progreso);
                SystemClock.sleep(20);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            prgBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            prgBar.setVisibility(View.INVISIBLE);
            prgBar.setVisibility(View.GONE);
        }
    }

    private void goToFragments() {
        /*ShowAlert("Ir a una pantalla que contenga dos tabs," +
                "dentro de cada uno mostrar un texto sencillo que indique en que tab se encuentra");*/

        Intent myIntent = new Intent(MainActivity.this, ConFragmensActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    private void goToDB() {
        /*ShowAlert("Almacenar en una DB local la fecha y hora de cuando se oprime un boton" +
                "y mostrar en la parte inferior de la pantalla que indique la cantidad de registros existentes en la DB");*/

        Intent myIntent = new Intent(MainActivity.this, BotonDBActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    private void goToConsumeService() {
        /*ShowAlert("- Consumir el servicio de la siguiente URL: https://jsonplaceholder.typicode.com/users" +
                "\n\r - mostrar en un ListView los siguientes datos: username e email" +
                "\n\r - Al seleccionar un item de la lista ir a una pantalla de detalles donde se muestra el resto de la informacion");*/

        Intent myIntent = new Intent(MainActivity.this, Servicio.class);
        MainActivity.this.startActivity((myIntent));
    }

    private void goToTomaDatos() {
        /*ShowAlert("Tomar los datos ingresados en un EditText y mostrarlos en un TextView");*/

        Intent myIntent = new Intent(MainActivity.this, TomaDatos.class);
        MainActivity.this.startActivity((myIntent));
    }

    public void ShowAlert(String text){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Que Hacer")
                .setMessage(text)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
