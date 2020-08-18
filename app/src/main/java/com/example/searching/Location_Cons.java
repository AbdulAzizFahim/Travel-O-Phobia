package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Location_Cons extends AppCompatActivity {

    String consString,placeName;

    TextView ConsTextView,ConsLocationName;

    BufferedReader reader;

    StringBuffer sbuf = new StringBuffer();

    InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location__cons);


        ConsTextView = (TextView) findViewById(R.id.ConsText1);
        ConsTextView.setMovementMethod(new ScrollingMovementMethod());

        ConsLocationName = (TextView) findViewById(R.id.textView3);
        consString = "";

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            placeName = bundle.getString("Location_Name");
            LocationProsInformation(placeName);
        }

    }

    void LocationProsInformation(String LocProInf)
    {
        if(LocProInf.equals("Cox's Bazar"))
        {
            ConsLocationName.setText("Cons of Cox's Bazar Tourism Spot");
            is = this.getResources().openRawResource(R.raw.cox_text_cons);
        }
        else if(LocProInf.equals("Saint Martins"))
        {
            ConsLocationName.setText("Cons of Saint Martins Tourism Spot");
            is = this.getResources().openRawResource(R.raw.saint_martin_text_cons);
        }
        if(LocProInf.equals("Sundarbans"))
        {
            ConsLocationName.setText("Cons of Sundarbans Tourism Spot");
            is = this.getResources().openRawResource(R.raw.sundarbans_text_cons);
        }
        if(LocProInf.equals("Sylhet"))
        {
            ConsLocationName.setText("Cons of Sylhet Tourism Spot");
            is = this.getResources().openRawResource(R.raw.sylhet_text_cons);
        }

        reader = new BufferedReader(new InputStreamReader(is));

        if(is!=null)
        {
            try{
                while((consString = reader.readLine())!=null)
                {
                    sbuf.append(consString + "\n");
                }
                ConsTextView.setText(sbuf);   is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}