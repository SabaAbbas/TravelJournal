package com.example.anumabbas.traveljournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class CreateProfile extends AppCompatActivity {

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    EditText Name;
    EditText Age;
    EditText City;
    EditText Country;
    EditText Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        mStorageRef= FirebaseStorage.getInstance().getReference();
        mDatabaseRef= FirebaseDatabase.getInstance().getReference();
    }
    public void onClick(View view)
    {
        Name   = (EditText)findViewById(R.id.editText3);
        Age   = (EditText)findViewById(R.id.editText4);
        City   = (EditText)findViewById(R.id.editText6);
        Country   = (EditText)findViewById(R.id.editText14);
        Phone   = (EditText)findViewById(R.id.editText15);

        final String name= Name.getText().toString().trim();
        final String age= Age.getText().toString().trim();
        final String city= City.getText().toString().trim();
        final String country= Country.getText().toString().trim();
        final String phone= Phone.getText().toString().trim();



            // Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT).show();

        //    if(mImageUri!=null)
          //  {
            //    StorageReference ref=mStorageRef.child(path_storage+System.currentTimeMillis()+"."+getImgExt(mImageUri));

              //  ref.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                /*    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        String downloadURL = taskSnapshot.getDownloadUrl().toString();   */

                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        String uid=user.getUid();

                        DatabaseReference ref= mDatabaseRef.child("Users").child(uid);
                        String key=ref.push().getKey();
                        ProfileInfo prof=new ProfileInfo(name,age,city,country,phone,uid,key);


                        ref.setValue(prof);

                        Intent i = new Intent(getApplicationContext(),Home.class);
                        finish();
                        startActivity(i);
                    }

                //});


            //}

        //Intent i = new Intent(getApplicationContext(),Home.class);
        //startActivity(i);
    }

