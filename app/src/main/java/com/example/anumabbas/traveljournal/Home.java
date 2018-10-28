package com.example.anumabbas.traveljournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
    }
    public void onClickGoToProfile(View view)
    {
        Intent i = new Intent(getApplicationContext(),UserProfile.class);
        startActivity(i);
    }
    public void onClickGoToDiary(View view)
    {
        Intent i = new Intent(getApplicationContext(),CreateDiary.class);
        startActivity(i);
    }
    public void onClickGoToWishlist(View view)
    {
        Intent i = new Intent(getApplicationContext(),WishList.class);
        startActivity(i);
    }
    public void onClickGoToPosts(View view)
    {
        Intent i = new Intent(getApplicationContext(),Posts.class);
        startActivity(i);
    }
    public void onClickGoToExplore(View view)
    {
        Intent i = new Intent(getApplicationContext(),Explore.class);
        startActivity(i);
    }

    public void onClickGoToLogin(View view) {

        Intent i = new Intent(getApplicationContext(),Login.class);
        startActivity(i);
    }
}
