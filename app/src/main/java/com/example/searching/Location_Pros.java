package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Location_Pros extends AppCompatActivity {

    String prosString,placeName;

    TextView ProsTextView,ProsLocationName;

    ImageView prosSignView;

    BufferedReader reader;

    StringBuffer sbuf = new StringBuffer();

    InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location__pros);

        prosSignView = (ImageView) findViewById(R.id.prosSignView);
        prosSignView.setImageResource(R.drawable.pros);

        ProsTextView = (TextView) findViewById(R.id.prosDescription);
        ProsTextView.setMovementMethod(new ScrollingMovementMethod());

        ProsLocationName = (TextView) findViewById(R.id.prosPlace);
        prosString = "";

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
            ProsLocationName.setText("Cox's Bazar Tourism Spot");
            is = this.getResources().openRawResource(R.raw.cox_text_pros);
        }
        else if(LocProInf.equals("Saint Martins"))
        {
            ProsLocationName.setText("Saint Martins Tourism Spot");
            is = this.getResources().openRawResource(R.raw.saint_martin_text_pros);
        }
        else if(LocProInf.equals("Sundarbans"))
        {
            ProsLocationName.setText("Sundarbans Tourism Spot");
            is = this.getResources().openRawResource(R.raw.sundarbans_text_pros);
        }
        else if(LocProInf.equals("Sylhet"))
        {
            ProsLocationName.setText("Sylhet Tourism Spot");
            is = this.getResources().openRawResource(R.raw.sylhet_text_pros);
        }

        reader = new BufferedReader(new InputStreamReader(is));

        if(is!=null)
        {
            try{
                while((prosString = reader.readLine())!=null)
                {
                    sbuf.append(prosString + "\n");
                }
                ProsTextView.setText(sbuf);   is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
