package com.melkor.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.melkor.training.Utils.DataHandler;

import org.w3c.dom.Text;

import java.util.List;

public class MasDatosActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_datos);

        Bundle bundle = getIntent().getExtras();

        int i = ((Integer)bundle.get("Datos")).intValue();

        TextView tvName = (TextView)findViewById(R.id.masdatos_name);
        tvName.setText(DataHandler.listaDatos.get(i).getName());

        TextView tvStreet = (TextView)findViewById(R.id.masdatos_street);
        tvStreet.setText(DataHandler.listaDatos.get(i).getAddress().getStreet());

        TextView tvSuite = (TextView)findViewById(R.id.masdatos_suite);
        tvSuite.setText(DataHandler.listaDatos.get(i).getAddress().getSuite());

        TextView tvCity = (TextView)findViewById(R.id.masdatos_city);
        tvCity.setText(DataHandler.listaDatos.get(i).getAddress().getCity());

        TextView tvZip = (TextView)findViewById(R.id.masdatos_zip);
        tvZip.setText(DataHandler.listaDatos.get(i).getAddress().getZipcode());

        TextView tvLat = (TextView)findViewById(R.id.masdatos_lat);
        tvLat.setText(DataHandler.listaDatos.get(i).getAddress().getGeo().getLat());

        TextView tvLng = (TextView)findViewById(R.id.masdatos_lng);
        tvLng.setText(DataHandler.listaDatos.get(i).getAddress().getGeo().getLng());

        TextView tvPhone = (TextView)findViewById(R.id.masdatos_phone);
        tvPhone.setText(DataHandler.listaDatos.get(i).getPhone());

        TextView tvWeb = (TextView)findViewById(R.id.masdatos_website);
        tvWeb.setText(DataHandler.listaDatos.get(i).getWebsite());

        TextView tvNameC = (TextView)findViewById(R.id.masdatos_nameCompany);
        tvNameC.setText(DataHandler.listaDatos.get(i).getCompany().getName());

        TextView tvPhrase = (TextView)findViewById(R.id.masdatos_phrase);
        tvPhrase.setText(DataHandler.listaDatos.get(i).getCompany().getCatchPhrase());

        TextView tvBs = (TextView)findViewById(R.id.masdatos_bs);
        tvBs.setText(DataHandler.listaDatos.get(i).getCompany().getBs());
    }
}
