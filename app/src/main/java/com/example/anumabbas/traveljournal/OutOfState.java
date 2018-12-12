package com.example.anumabbas.traveljournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OutOfState extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference ref;
    FirebaseDatabase database;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_of_state);

        recyclerView=findViewById(R.id.recyclerView3);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        final FirebaseRecyclerAdapter<Post ,MyViewHolder> adapter;
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users/"+uid+"/OutOfState");

        adapter = new FirebaseRecyclerAdapter <Post, MyViewHolder>(Post.class, R.layout.one_row, MyViewHolder.class, ref) {

            @Override
            protected void populateViewHolder(final MyViewHolder viewHolder, Post model, int position) {


                viewHolder.bindData(model);



            }

            @Override
            public int getItemCount() {
                return super.getItemCount();
            }


        };

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
