package com.example.finalmerge.EventPage.Feedback.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.EventPage.Feedback.Holder.FeedbackViewHolder;
import com.example.finalmerge.EventPage.Model.Event;
import com.example.finalmerge.R;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackViewHolder>{

    Context context;
    List<Event> events;
    @NonNull
    @Override
    public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FeedbackViewHolder(LayoutInflater.from(context).inflate(R.layout.feedback_recycleview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
