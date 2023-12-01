package com.example.finalmerge.AnnouncementPage.Holder;

import android.content.Intent;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.AnnouncementPage.Adapter.AnnAdapter;
import com.example.finalmerge.AnnouncementPage.AnnouncementDetail;
import com.example.finalmerge.AnnouncementPage.Model.Announcements;
import com.example.finalmerge.R;

import java.util.ArrayList;

public class AnnouncementViewHolder extends RecyclerView.ViewHolder{
    public TextView subject, description, date;
    private Context context;

    private ArrayList<Announcements> list;

    public AnnouncementViewHolder(View itemView, Context context, ArrayList<Announcements> list) {
        super(itemView);
        this.context = context;
        this.list = list;
        subject = itemView.findViewById(R.id.rSubject);
        description = itemView.findViewById(R.id.rDes);
        date = itemView.findViewById(R.id.rDate);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent announcementDetail = new Intent(context, AnnouncementDetail.class);
                int position = getAdapterPosition();

                announcementDetail.putExtra("subject",list.get(position).getAnnSubject());
                announcementDetail.putExtra("date",list.get(position).getCurrentDate());
                announcementDetail.putExtra("description",list.get(position).getAnnDes());
                context.startActivity(announcementDetail);
            }
        });
    }
}
