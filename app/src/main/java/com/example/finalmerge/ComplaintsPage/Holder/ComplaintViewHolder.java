package com.example.finalmerge.ComplaintsPage.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.R;

public class ComplaintViewHolder extends RecyclerView.ViewHolder{

    public TextView email, subject, complaint;

    public ComplaintViewHolder(@NonNull View itemView) {
        super(itemView);

        email=itemView.findViewById(R.id.contentEmail);
        subject=itemView.findViewById(R.id.contentSubject);
        complaint=itemView.findViewById(R.id.contentComplaint);
    }
}
