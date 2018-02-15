package com.melkor.training;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.melkor.training.Entities.FechaHora;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class BotonDBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton_db);

        Button mibtn = (Button)findViewById(R.id.botondb_btn);
        mibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonAction();
            }
        });
    }

    public void doButtonAction()
    {
        TextView mitv = (TextView)findViewById(R.id.botondb_tv);



        /*Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 1);
        c.set(Calendar.MINUTE, 1);
        c.set(Calendar.SECOND, 1);*/

        Time today = new Time(Time.getCurrentTimezone());

        today.setToNow();

        int dia = today.monthDay;
        int mes = today.month+1;
        int anio = today.year;
        int min = today.minute;
        int hr = today.hour;
        int sc = today.second;

        mitv.setText(dia+"/"+mes+"/"+anio+" "+hr+":"+min+":"+sc);

        GuardarFechaHora();
    }

    public void GuardarFechaHora()
    {
        Time today = new Time(Time.getCurrentTimezone());

        today.setToNow();

        int dia = today.monthDay;
        int mes = today.month+1;
        int anio = today.year;
        int min = today.minute;
        int hr = today.hour;
        int sc = today.second;

        FechaHora fh = new FechaHora();

        fh.setFechaHora(dia+"/"+mes+"/"+anio+" "+hr+":"+min+":"+sc);

        FechaHoraDbHelper conn = new FechaHoraDbHelper(this, "FechaHoraBoton", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FechaHoraContract.FechaHoraEntry.CAMPO_FECHAHORA, fh.getFechaHora());

        Long idResultante = db.insert(FechaHoraContract.FechaHoraEntry.TABLE_NAME, FechaHoraContract.FechaHoraEntry._ID, values);

        Toast.makeText(getApplicationContext(), "Id Registro: "+ idResultante, Toast.LENGTH_SHORT).show();
    }
}
