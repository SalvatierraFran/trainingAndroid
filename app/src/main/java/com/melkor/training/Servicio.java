package com.melkor.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.util.Log;

import com.melkor.training.Utils.AsynkConnector;
import com.melkor.training.Utils.Callback;
import com.melkor.training.Utils.DataHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;

public class Servicio extends AppCompatActivity {

    private List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio);

        getData();

        System.out.println(getListaUsuarios());

        final ListView listview = (ListView)this.findViewById(R.id.servicio_lv);
        UsuariosAdapter itemAdapter = new UsuariosAdapter(this, R.layout.row_layout, getListaUsuarios());
        listview.setAdapter(itemAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent myIntentDatos = new Intent(Servicio.this, MasDatosActivity.class);
                myIntentDatos.putExtra("Datos",i);
                startActivity(myIntentDatos);
            }
        });

    }

    public void getData()
    {
        String content = "{}";

        String param = "";

        AsynkConnector c = new AsynkConnector(AsynkConnector.USER, param, content, new Callback(){
            private int dots = 0;
            @Override
            public void starting()
            {  }

            @Override
            public void completed(String res, int responseCode)
            {
                if(responseCode == 200)
                {
                    parseResponseJson(res);
                }
                else
                {

                }
            }

            @Override
            public void completedWithErrors(Exception e)
            {

            }

            @Override
            public void update(){

            }
        });

        c.execute();
    }

    private void parseResponseJson(String res)
    {
        try
        {
            JSONArray myarray = new JSONArray(res);

            for(int i=0; i< myarray.length(); i++)
            {
                JSONObject obj = myarray.getJSONObject(i);
                Usuarios user = new Usuarios();
                Address addr = new Address();
                Geo geo = new Geo();
                Company Comp = new Company();

                user.setId(obj.optInt("id"));
                user.setName(obj.optString("name"));
                user.setUsername(obj.optString("username"));
                user.setEmail(obj.optString("email"));

                JSONObject objAddr = obj.getJSONObject("address");
                addr.setStreet(objAddr.optString("street"));
                addr.setSuite(objAddr.optString("suite"));
                addr.setCity(objAddr.optString("city"));
                addr.setZipcode(objAddr.optString("zipcode"));

                JSONObject objGeo = objAddr.getJSONObject("geo");
                geo.setLat(objGeo.optString("lat"));
                geo.setLng(objGeo.optString("lng"));

                JSONObject objCompany = obj.getJSONObject("company");
                Comp.setName(objCompany.optString("name"));
                Comp.setCatchPhrase(objCompany.optString("catchPhrase"));
                Comp.setBs(objCompany.optString("bs"));

                addr.setGeo(geo);
                user.setAddress(addr);
                user.setCompany(Comp);

                Log.i("Username: ", user.getUsername());
                Log.i("Email: ", user.getEmail());

                this.listaUsuarios.add(user);
                DataHandler.listaDatos = this.listaUsuarios;

            }

        }
        catch (JSONException e){
            System.out.println(e.getMessage());
            Log.i("ERROR PARSING", e.getMessage());
        }
    }

    public List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
