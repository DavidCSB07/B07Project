package com.example.finalmerge.EventPage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.EventPage.Holder.EventViewHolder;
//import com.example.finalmerge.EventPage.Model.Event;
import com.example.finalmerge.ScheduleEvent.models.Event;
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
        return new EventViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_event_page, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.titleView.setText(events.get(position).getTitle());
        holder.descriptionView.setText(events.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
