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
import com.example.finalmerge.EventPage.RSVP.RSVP;
import com.example.finalmerge.R;

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
                Intent intent = new Intent(v.getContext(), RSVP.class);
                intent.putExtra("title", events.get(position).getTitle());
                intent.putExtra("description", events.get(position).getDescription());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}



