package com.example.anumabbas.traveljournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickGoToHome(View view) {

        Intent i = new Intent(getApplicationContext(),Home.class);
        startActivity(i);
    }
}
