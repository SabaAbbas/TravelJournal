package com.example.anumabbas.traveljournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {

    EditText Name;
    EditText Age;
    EditText City;
    EditText Country;
    EditText Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Name   = (EditText)findViewById(R.id.name);
        Age   = (EditText)findViewById(R.id.age);
        City   = (EditText)findViewById(R.id.city);
        Country   = (EditText)findViewById(R.id.country);
        Phone   = (EditText)findViewById(R.id.phone);

        final String name= Name.getText().toString().trim();
        final String age= Age.getText().toString().trim();
        final String city= City.getText().toString().trim();
        final String country= Country.getText().toString().trim();
        final String phone= Phone.getText().toString().trim();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid= user.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref= database.getReference("Users/"+uid);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Toast.makeText(getApplicationContext(), "On data changed", Toast.LENGTH_SHORT).show();
                ProfileInfo pro = dataSnapshot.getValue(ProfileInfo.class);

                Name.setText(pro.getName().trim());
                Age.setText(pro.getAge().trim());
                City.setText(pro.getCity().trim());
                Country.setText(pro.getCountry().trim());
                Phone.setText(pro.getPhone().trim());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });



    }
}
