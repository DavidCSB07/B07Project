package com.example.finalmerge.Feedback.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.Feedback.Holder.FeedbackViewHolder;
import com.example.finalmerge.Feedback.Model.FeedBack;
import com.example.finalmerge.R;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackViewHolder>{

    Context context;
    List<FeedBack> feedbacks;

    public FeedbackAdapter(Context context, List<FeedBack> feedbacks) {
        this.context = context;
        this.feedbacks = feedbacks;
    }

    @NonNull
    @Override
    public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FeedbackViewHolder(LayoutInflater.from(context).inflate(R.layout.feedback_recycleview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackViewHolder holder, int position) {
        holder.username.setText(feedbacks.get(position).getUserName());
        holder.commentText.setText(feedbacks.get(position).getShortFeedback());
        holder.rating.setText(feedbacks.get(position).getNumFeedback());
    }

    @Override
    public int getItemCount() {
        return feedbacks.size();
    }
}
