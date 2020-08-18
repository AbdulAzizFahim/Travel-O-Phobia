package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Location_Activity extends AppCompatActivity {

    Button Pros_Button,Cons_Button,Trip_Review_Button,Hotel_Book_Button,Bus_Reservation_Button;

    String placeString,placeName;

    TextView placeText,location_Name_Text;

    ImageView placeImage;

    StringBuffer sbuf = new StringBuffer();

    InputStream is ;

    BufferedReader reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_);

        location_Name_Text = (TextView) findViewById(R.id.Location_Name_Text);
        placeText = (TextView) findViewById(R.id.Location_Description_Text);
        placeImage = (ImageView) findViewById(R.id.Location_Image);
        Pros_Button = (Button) findViewById(R.id.Pros_Button);
        Cons_Button = (Button) findViewById(R.id.Cons_Button);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            placeName = bundle.getString("Location_Name");
            location_Name_Text.setText(placeName);
            Location_Information(placeName);
        }

        placeString = "";

        Pros_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ProsIntent = new Intent(Location_Activity.this,Location_Pros.class);

                ProsIntent.putExtra("Location_Name",placeName);

                startActivity(ProsIntent);
            }
        });

        Cons_Button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ConsIntent = new Intent(Location_Activity.this,Location_Cons.class);

                ConsIntent.putExtra("Location_Name",placeName);

                startActivity(ConsIntent);
            }
        }));
    }
    void Location_Information(String LocInf)
    {
        if(LocInf.equals("Cox's Bazar"))
        {
            placeImage.setImageResource(R.drawable.cox3);

            is= this.getResources().openRawResource(R.raw.cox_description_text);
        }
        else if (LocInf.equals("Saint Martins"))
        {
            placeImage.setImageResource(R.drawable.saint1);

            is= this.getResources().openRawResource(R.raw.saint_martin_description_text);
        }
        else if (LocInf.equals("Sundarbans"))
        {
            placeImage.setImageResource(R.drawable.sundar1);

            is= this.getResources().openRawResource(R.raw.sundarbans_description_text);
        }
        else if (LocInf.equals("Sylhet"))
        {
            placeImage.setImageResource(R.drawable.sylhet1);

            is= this.getResources().openRawResource(R.raw.sylhet_description_text);
        }

        reader = new BufferedReader(new InputStreamReader(is));

        if(is!=null)
        {
            try{
                while((placeString = reader.readLine())!=null)
                {
                    sbuf.append(placeString + "\n");
                }
                placeText.setText(sbuf);    is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
