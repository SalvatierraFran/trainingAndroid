package com.melkor.training;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TomaDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toma_datos);

        Button Escribir = (Button)findViewById(R.id.TomaDatos_btn);
        Escribir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doButtonAction();
            }

        });

        Button Borrar = (Button)findViewById(R.id.TomaDatos_btn2);
        Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doButtonAction2();
            }
        });
    }

    public void doButtonAction()
    {
        String texto;


        EditText et = (EditText)findViewById(R.id.TomaDatos_et);
        texto = et.getText().toString();

        if(!texto.equals(""))
        {
            TextView tv = (TextView)findViewById(R.id.TomaDatos_tv);
            tv.setText(texto);
        }
        else
        {
            ShowAlert("No ha ingresado ningún texto.");
        }
    }

    public void doButtonAction2()
    {
        EditText et = (EditText)findViewById(R.id.TomaDatos_et);
        et.setText("");

        TextView tv = (TextView)findViewById(R.id.TomaDatos_tv);
        tv.setText("");
    }

    public void ShowAlert(String text){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("ERROR")
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
