package com.melkor.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

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

        mitv.setText(Calendar.getInstance().getTime().toString());
    }
}
