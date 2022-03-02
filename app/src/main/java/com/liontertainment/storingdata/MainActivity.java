package com.liontertainment.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextage;
    TextView textViewage;
    EditText editTextname;
    TextView textViewname;
    Button buttonsave;
    SharedPreferences sharedPreferenceshafizaelemani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bunları on create de tanımlamamızın sebebi heryerde kullanabilmek
        editTextage = findViewById(R.id.agetextView);
        textViewage = findViewById(R.id.ageresulttextView);

        editTextname = findViewById(R.id.nametextView);
        textViewname = findViewById(R.id.nameresulttextView);


        sharedPreferenceshafizaelemani = this.getSharedPreferences("com.liontertainment.storingdata", Context.MODE_PRIVATE);

        String storedName = sharedPreferenceshafizaelemani.getString("storedName","");
        if (storedName == ""){
            textViewname.setText("Please Enter Your Name: ");
        } else {
            editTextname.setText("Tekrar Hoşgeldin " + storedName);
        }
    }

    public void save(View view){

        String userName = editTextname.getText().toString();
        textViewname.setText("Your Name2: " + userName);

        if (!editTextage.getText().toString().matches("")) {
            int userAge = Integer.parseInt(editTextage.getText().toString());
            textViewage.setText("Your age: " + userAge);

            //yaşı uygulama kapatıp açısla bile aklında tutar
            sharedPreferenceshafizaelemani.edit().putString("storedName", userName).apply();

        }
    }

    public void delete (View view){

        String hafizasilme = sharedPreferenceshafizaelemani.getString("storedName","");

        if (hafizasilme != ""){
            sharedPreferenceshafizaelemani.edit().remove("storedName").apply();
            textViewname.setText("i said your name!: ");
        }

    }




}