package com.example.anumabbas.traveljournal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CreateDiary extends Activity {
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_diary);

    }


    public void onClickMethod(View v)
    {

        Intent i = new Intent(getApplicationContext(),CreatePost.class);
        startActivity(i);
    }

    public void MessageBox(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void GoToWC(View view) {

        Intent i = new Intent(getApplicationContext(),WithinCityTrips.class);
        startActivity(i);
    }

    public void GoToOC(View view) {
        Intent i = new Intent(getApplicationContext(),OutOfCity.class);
        startActivity(i);
    }
    public void GoToOS(View view) {
        Intent i = new Intent(getApplicationContext(),OutOfState.class);
        startActivity(i);
    }
}
