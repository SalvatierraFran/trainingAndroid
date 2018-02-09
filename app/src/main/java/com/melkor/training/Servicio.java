package com.melkor.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;

import android.util.Log;

import com.melkor.training.Utils.AsynkConnector;
import com.melkor.training.Utils.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;

public class Servicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio);

        getData();

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

                Log.i("Username: ", user.getUsername());
                Log.i("Email: ", user.getEmail());

            }

        }
        catch (JSONException e){
            System.out.println(e.getMessage());
            Log.i("ERROR PARSING", e.getMessage());
        }
    }
}
