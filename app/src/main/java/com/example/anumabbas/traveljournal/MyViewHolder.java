package com.example.anumabbas.traveljournal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.anumabbas.traveljournal.ImageDownloaderAsync;
import com.example.anumabbas.traveljournal.Post;
import com.example.anumabbas.traveljournal.R;

import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * Created by anumabbas on 09/12/2018.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txt;
        TextView txt2;
        RatingBar rtn;
        //Context c;

public MyViewHolder(View itemView) {
        super(itemView);
        img=itemView.findViewById(R.id.img);
        txt=itemView.findViewById(R.id.description);
        txt2=itemView.findViewById(R.id.location);
        rtn=itemView.findViewById(R.id.ratingbar2);
        }

public void bindData(Post p)
        {
                new ImageDownloaderAsync(img,getApplicationContext()).execute(p.getUrl());
       // new ImageDownloaderAsync(img,v.getContext()).execute(p.getUrl());
        txt.setText(p.getDescription().trim());
        txt2.setText(p.getLocation().trim());
        rtn.setRating(p.getRating());
        }
}


