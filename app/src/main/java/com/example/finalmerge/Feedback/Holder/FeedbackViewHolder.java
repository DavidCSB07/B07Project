package com.example.finalmerge.Feedback.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.R;

public class FeedbackViewHolder extends RecyclerView.ViewHolder{

    public TextView username;
    public TextView commentText;
    public TextView rating;
    public FeedbackViewHolder(@NonNull View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.UserName);
        commentText = itemView.findViewById(R.id.CommentText);
        rating = itemView.findViewById(R.id.rating);
    }
}
