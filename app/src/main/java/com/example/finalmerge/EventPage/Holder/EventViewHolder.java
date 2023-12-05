package com.example.finalmerge.EventPage.Holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.R;

public class EventViewHolder extends RecyclerView.ViewHolder{

    //public ImageView imageView;
    public TextView descriptionView, titleView, eventDateView;

    public RelativeLayout layout;
    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.title);
        descriptionView = itemView.findViewById(R.id.description);
        eventDateView = itemView.findViewById(R.id.eventDate);
        layout = itemView.findViewById(R.id.layout);

    }
}
