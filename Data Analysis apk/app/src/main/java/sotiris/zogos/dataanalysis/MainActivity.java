package sotiris.zogos.dataanalysis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter,listadapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        final Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[] {"Select a sensor", "heart rate", "humidity", "battery monitor", "temperature", "accelerometer", "magnetometer", "altimeter/pressure",
                "imager (VGA/RGB)", "imager (MP4 compressed)", "infrared proximity", "gyroscope", "microphone", "CO2", "light", "strain", "ultra-violet", "ph meter"};


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        ListView lstView = (ListView) findViewById(R.id.listView1);
        listadapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item,list);
                lstView.setAdapter(listadapter);
                dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                   int arg2, long arg3) {
                // TODO Auto-generated method stub
                String s = dropdown.getItemAtPosition(arg2).toString();
                if (!(s.matches( "Select a sensor" ))) {
                    list.add( s );
                    dropdown.setSelection( 0 );
                    listadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                }
            });

            Button button3 = findViewById( R.id.button3 );
            button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                list.clear();
                listadapter.notifyDataSetChanged();
                }
            });

            Button button2 = findViewById( R.id.button2 );
            button2.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    Intent intent = new Intent( MainActivity.this, Calculate.class );
                    intent.putExtra( "items", list );
                    startActivity( intent );
                }
            } );
        }

    }
