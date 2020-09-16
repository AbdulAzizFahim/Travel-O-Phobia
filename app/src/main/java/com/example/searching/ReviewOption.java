package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class ReviewOption extends AppCompatActivity {

    Button b1;
    Button b2;
    EditText text;
    String details;
    DatabaseReference data;
    String name,place,purl;
    String myname,mypass;
    String special;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_option);

        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        text = (EditText) findViewById(R.id.editext1);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

            name = bundle.getString("name");
            place = bundle.getString("place");
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               jump();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(place.equals("Cox's Bazar"))
                    special = "Review1";
                else if(place.equals("Saint Martins"))
                    special = "Review2";
                else if(place.equals("Sundarbans"))
                    special = "Review3";
                else if(place.equals("Sylhet"))
                    special = "Review4";



                details = text.getText().toString().trim();
                data = FirebaseDatabase.getInstance().getReference().child(special);
                String key = data.push().getKey();
                Helper hp = new Helper(name,details,purl,place);
                data.child(key).setValue(hp);
                jump();
            }
        });


    }

    void jump(){
        Intent intent = new Intent(this,Review.class);
        intent.putExtra("name",name);
        intent.putExtra("place", place);
        intent.putExtra("where", special);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        text.setText("");
        super.onRestart();
    }
}
