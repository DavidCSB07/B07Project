package com.example.finalmerge.EventPage.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.EventPage.Holder.EventViewHolder;
import com.example.finalmerge.EventPage.Model.Event;
import com.example.finalmerge.EventPage.RSVP;
import com.example.finalmerge.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder>{

    Context context;
    List<Event> events;

    public EventAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventViewHolder(LayoutInflater.from(context).inflate(R.layout.event_recycleview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {

        holder.titleView.setText(events.get(position).getTitle());
        holder.descriptionView.setText(events.get(position).getDescription());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check userType
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                DatabaseReference FeedbackUIDbRef = FirebaseDatabase.getInstance().getReference();
                FirebaseUser currentUser = mAuth.getCurrentUser();
                String uid = currentUser.getUid();

                //set Visibility base on userType (0 --> student, 1 --> admin)
                FeedbackUIDbRef.child("RegisterInfo").child(uid).child("userType").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        // 0 is student, 1 is admin
                        int userType = snapshot.getValue(Integer.class);
                        if(userType == 0){
                            //student
                            Intent intent = new Intent(v.getContext(), RSVP.class);
                            intent.putExtra("title", events.get(position).getTitle());
                            intent.putExtra("description", events.get(position).getDescription());
                            intent.putExtra("refKey", events.get(position).getRefKey());
                            v.getContext().startActivity(intent);
                        }
                        if(userType == 1){
                            //admin
                            Intent intent = new Intent(v.getContext(), RSVP.class);
                            intent.putExtra("title", events.get(position).getTitle());
                            intent.putExtra("description", events.get(position).getDescription());
                            intent.putExtra("refKey", events.get(position).getRefKey());
                            v.getContext().startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


    }


    @Override
    public int getItemCount() {
        return events.size();
    }
}



