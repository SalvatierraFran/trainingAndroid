package com.melkor.training;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franco.salvatierra on 09/02/2018.
 */

public class UsuariosAdapter extends ArrayAdapter<Usuarios> {
    List<Usuarios> data;
    Activity context;

    public UsuariosAdapter(@NonNull Context context, int resource, List<Usuarios> data)
    {
        super(context, resource, data);

        this.data = data;
        this.context = (Activity)context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater lnf = context.getLayoutInflater();
        View row = lnf.inflate(R.layout.row_layout, null);

        TextView tvUsername = (TextView) row.findViewById(R.id.row_username);
        tvUsername.setText(data.get(position).getUsername());

        TextView tvEmail = (TextView) row.findViewById(R.id.row_email);
        tvEmail.setText(data.get(position).getEmail());

        return row;
    }

    /*public View getView2(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater lnf = context.getLayoutInflater();
        View row = lnf.inflate(R.layout.activity_mas_datos, null);

        TextView tvName = (TextView)row.findViewById(R.id.masdatos_name);
        tvName.setText(data.get(position).getName());

        TextView tvStreet = (TextView)row.findViewById(R.id.masdatos_street);
        tvStreet.setText(data.get(position).getAddress().getStreet());

        TextView tvSuite = (TextView)row.findViewById(R.id.masdatos_suite);
        tvStreet.setText(data.get(position).getAddress().getSuite());

        TextView tvCity = (TextView)row.findViewById(R.id.masdatos_city);
        tvCity.setText(data.get(position).getAddress().getCity());

        TextView tvZip = (TextView)row.findViewById(R.id.masdatos_zip);
        tvZip.setText(data.get(position).getAddress().getZipcode());

        TextView tvLat = (TextView)row.findViewById(R.id.masdatos_lat);
        tvLat.setText(data.get(position).getAddress().getGeo().getLat());

        TextView tvLng = (TextView)row.findViewById(R.id.masdatos_lng);
        tvLng.setText(data.get(position).getAddress().getGeo().getLng());

        TextView tvPhone = (TextView)row.findViewById(R.id.masdatos_phone);
        tvPhone.setText(data.get(position).getPhone());

        TextView tvWeb = (TextView)row.findViewById(R.id.masdatos_website);
        tvWeb.setText(data.get(position).getWebsite());

        TextView tvNameC = (TextView)row.findViewById(R.id.masdatos_nameCompany);
        tvNameC.setText(data.get(position).getCompany().getName());

        TextView tvPhrase = (TextView)row.findViewById(R.id.masdatos_phrase);
        tvPhrase.setText(data.get(position).getCompany().getCatchPhrase());

        TextView tvBs = (TextView)row.findViewById(R.id.masdatos_bs);
        tvBs.setText(data.get(position).getCompany().getBs());

        return row;
    }*/
}
