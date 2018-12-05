package com.example.anumabbas.traveljournal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;

public class uploadMedia extends AppCompatActivity implements View.OnClickListener {

    private static final int PICK_IMAGE_REQUEST = 234;
    private Button btnChoose,btnUpload;
    private ImageView imageView;
    private StorageReference  mStorage;
    private Uri filePath;
    private static final int GALLERY_INTENT=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_media);
        btnUpload = (Button) findViewById(R.id.btnUpload);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        imageView = (ImageView) findViewById(R.id.imageView);
        mStorage=FirebaseStorage.getInstance().getReference();
        btnChoose.setOnClickListener(this);
        btnUpload.setOnClickListener(this);

    }

    private void uploadFile()
    {
        if(filePath!=null) {

            final ProgressDialog progressDialog= new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            StorageReference wishlistRef = mStorage.child(" Wishlist Images/" + filePath.getLastPathSegment());
            wishlistRef.putFile(filePath).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), exception.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                   progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), " Uploaded Successfully ",
                            Toast.LENGTH_SHORT).show();

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress= (100.0* taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                    progressDialog.setMessage(((int) progress)+"% Uploaded...");
                }
            })

            ;
        }
        else
        {
            Toast.makeText(getApplicationContext(), " Please Choose a File",
                    Toast.LENGTH_SHORT).show();
        }
    }
    private void showFileChooser()
    {
        Intent intent= new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select an Image"),PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==PICK_IMAGE_REQUEST&& resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            filePath=data.getData();
            try {
                Bitmap bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                imageView.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onClick(View view)
    {

        if(view==btnChoose)
        {
            // open file chooser
            showFileChooser();

        }
        else if(view==btnUpload)
        {
            // upload file to firebase storage
            uploadFile();
        }

    }
}
