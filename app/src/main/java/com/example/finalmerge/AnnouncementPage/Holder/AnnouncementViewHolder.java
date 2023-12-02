package com.example.finalmerge.AnnouncementPage.Holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.R;

public class AnnouncementViewHolder extends RecyclerView.ViewHolder{
    public TextView subject, description, date;
    public LinearLayout layout;

    public AnnouncementViewHolder(@NonNull View itemView) {
        super(itemView);
        subject = itemView.findViewById(R.id.rSubject);
        description = itemView.findViewById(R.id.rDes);
        date = itemView.findViewById(R.id.rDate);
        layout = itemView.findViewById(R.id.layout);
    }
}
