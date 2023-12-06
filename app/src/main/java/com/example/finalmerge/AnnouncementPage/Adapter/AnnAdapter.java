package com.example.finalmerge.AnnouncementPage.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.AnnouncementPage.AnnouncementDetail;
import com.example.finalmerge.AnnouncementPage.Holder.AnnouncementViewHolder;
import com.example.finalmerge.AnnouncementPage.Model.Announcements;
import com.example.finalmerge.R;

import java.util.ArrayList;

public class AnnAdapter extends RecyclerView.Adapter<AnnouncementViewHolder> {

    Context context;
    ArrayList<Announcements> list;

    public AnnAdapter(Context context, ArrayList<Announcements> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.announcement_recycleview,parent,false);
        return new AnnouncementViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementViewHolder holder, int position) {
        holder.subject.setText(list.get(position).getAnnSubject());
        holder.description.setText(list.get(position).getFilteredDescription());
        holder.date.setText(list.get(position).getCurrentDate());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AnnouncementDetail.class);
                intent.putExtra("annSubject", list.get(position).getAnnSubject());
                intent.putExtra("annDes", list.get(position).getAnnDes());
                intent.putExtra("annDate", list.get(position).getCurrentDate());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

