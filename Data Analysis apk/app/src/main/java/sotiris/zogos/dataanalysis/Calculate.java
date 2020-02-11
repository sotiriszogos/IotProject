package sotiris.zogos.dataanalysis;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Math.pow;

public class Calculate extends AppCompatActivity {

    ArrayList<Sensors> sensors = new ArrayList();
    int resolution_min=0, resolution_max=0;
    double datarate_min=0, datarate_max=0;
    double adc_min=0, adc_max=0;
    double total_min=0, total_max=0;



    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.calculate );

        Intent intent = getIntent();

        final ArrayList<String> list = getIntent().getStringArrayListExtra("items");


        sensors.add( new Sensors( "heart rate", 4, 12, 5000, 10000, 0.000000001, 0.000000005 ) );
        sensors.add( new Sensors( "humidity", 8, 16, 10, 50, 0, 0 ) );
        sensors.add( new Sensors( "battery monitor", 5, 8, 5, 30, 0, 0 ) );
        sensors.add( new Sensors( "temperature", 6, 12, 100, 300, 0.0000000005, 0.000000001 ) );
        sensors.add( new Sensors( "accelerometer", 8, 14, 2000, 5000, 0.00000001, 0.00000003 ) );
        sensors.add( new Sensors( "magnetometer", 8, 16, 800, 1200, 0.000000007, 0.00000001 ) );
        sensors.add( new Sensors( "altimeter/pressure", 8, 24, 800, 2000, 0.000000007, 0.00000003 ) );
        sensors.add( new Sensors( "imager (VGA/RGB)", 8, 10, 100000000, 200000000, 0.0007, 0.001 ) );
        sensors.add( new Sensors( "imager (MP4 compressed)", 8, 10, 10000000, 300000000, 0.0007, 0.001 ) );
        sensors.add( new Sensors( "infrared proximity", 10, 16, 300, 800, 0.000000007, 0.000000013 ) );
        sensors.add( new Sensors( "gyroscope", 12, 16, 10000, 3000, 0.000002, 0.000008 ) );
        sensors.add( new Sensors( "microphone", 12, 16, 200000, 50000, 0.00002, 0.00008 ) );
        sensors.add( new Sensors( "CO2", 14, 16, 300, 700, 0.0000000004, 0.0000000006 ) );
        sensors.add( new Sensors( "light", 16, 24, 200, 500, 0.0000005, 0.0000008 ) );
        sensors.add( new Sensors( "strain", 16, 24, 20000, 50000, 0.00005, 0.00008 ) );
        sensors.add( new Sensors( "ultra-violet", 0, 0, 400, 700, 0.0000001, 0.0000002 ) );


        //Add the Ph Sensor
        sensors.add( new Sensors( "ph meter", 16, 16, 0.133, 0.266, 0.000000000000004, 0.000000000000008 ));




        for (String s : list) {
            for (Sensors sensor : sensors) {
                if (s.matches( sensor.getName() )){
                    resolution_min = resolution_min + sensor.getResolution_min();
                    resolution_max = resolution_max + sensor.getResolution_max();
                    datarate_min = datarate_min + sensor.getDatarate_min();
                    datarate_max = datarate_max + sensor.getDatarate_max();
                    adc_min = adc_min + sensor.getAdc_min();
                    adc_max = adc_max + sensor.getAdc_max();
                }
            }

        }

        total_min=adc_min+datarate_min*5*(pow(10,-9));
        total_max=adc_max+datarate_max*5*(pow(10,-9));

        TextView textView2 = findViewById( R.id.textView2 );
        textView2.setText( ""+resolution_max+" bits" );

        TextView textView6 = findViewById( R.id.textView6 );
        textView6.setText( resolution_min+" bits" );

        TextView textView8 = findViewById( R.id.textView8 );
        textView8.setText( datarate_min+" bps" );

        TextView textView10 = findViewById( R.id.textView10 );
        textView10.setText( datarate_max+" bps" );

        TextView textView12 = findViewById( R.id.textView12 );
        textView12.setText( adc_min+" W" );

        TextView textView14 = findViewById( R.id.textView14 );
        textView14.setText( adc_max+" W" );

        TextView textView20 = findViewById( R.id.textView20 );
        textView20.setText( total_min+" W" );

        TextView textView22 = findViewById( R.id.textView22 );
        textView22.setText( total_max+" W" );


        Button buttonpdf = findViewById( R.id.buttonpdf );
        buttonpdf.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                StringBuilder sb = new StringBuilder();
                sb.append( "These are the selected sensors:" );
                sb.append( "\n" );
                for (String s : list) {
                    sb.append( s );
                    sb.append( "\n" );
                }
                sb.append( "This is your analysis results" );
                sb.append( "\n" );
                sb.append( "Minimum resolution: " + resolution_min + " bits");
                sb.append( "\n" );
                sb.append( "Maximum resolution: " + resolution_max + " bits");
                sb.append( "\n" );
                sb.append( "Minimum datarate: " + datarate_min + " bps");
                sb.append( "\n" );
                sb.append( "Maximum datarate: " + datarate_max + " bps" );
                sb.append( "\n" );
                sb.append( "Minimum ADC power: " + adc_min + " W");
                sb.append( "\n" );
                sb.append( "Maximum ADC power: " + adc_max + " W");
                sb.append( "\n" );
                sb.append( "Minimum total power: " + total_min + " W");
                sb.append( "\n" );
                sb.append( "Maximum total power: " + total_max + " W");
                sb.append( "\n" );
                String sometext = sb.toString();
                createPdf( sometext );
            }
        } );


        }

    private void createPdf(String sometext) {
        // create a new document
        PdfDocument document = new PdfDocument();
        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder( 300, 600, 1 ).create();
        // start a page
        PdfDocument.Page page = document.startPage( pageInfo );
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor( Color.RED );
        paint.setColor( Color.BLACK );
        paint.setTextSize( 11 );

        int y = 40;
        String[] lines = sometext.split( "\n" );
        for (int i=0; i<lines.length; i++) {
            canvas.drawText(lines[i], 20, y, paint);
            y+=20;
        }

        document.finishPage( page );
        File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File( root + "/Data Analysis" );
        if (!file.exists()) {
            file.mkdirs();
        }
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formatted = df.format(new Date());

        String fname = "YourAnalysis-"+formatted+".pdf";
        File filePath = new File( file, fname );
        try {
            document.writeTo( new FileOutputStream( filePath ) );
            Toast.makeText( this, "Done", Toast.LENGTH_LONG ).show();
        } catch (IOException e) {
            Log.e( "main", "error " + e.toString() );
            Toast.makeText( this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG ).show();
        }
        document.close();
    }
    }



