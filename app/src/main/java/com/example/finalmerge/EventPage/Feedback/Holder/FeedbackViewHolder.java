package com.example.finalmerge.EventPage.Feedback.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.R;

public class FeedbackViewHolder extends RecyclerView.ViewHolder{

    TextView username, commentText, rating;
    public FeedbackViewHolder(@NonNull View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.UserName);
        commentText = itemView.findViewById(R.id.CommentText);
        rating = itemView.findViewById(R.id.rating);
    }
}
