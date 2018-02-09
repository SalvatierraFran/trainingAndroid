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
}
