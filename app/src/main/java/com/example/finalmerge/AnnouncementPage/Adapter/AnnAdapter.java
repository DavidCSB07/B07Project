package com.example.finalmerge.AnnouncementPage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.AnnouncementPage.Holder.AnnouncementViewHolder;
import com.example.finalmerge.AnnouncementPage.Model.Announcements;
import com.example.finalmerge.R;

import java.util.ArrayList;

public class AnnAdapter extends RecyclerView.Adapter<AnnouncementViewHolder> {

    Context context;
    ArrayList<Announcements> AnnouncementList;

    public AnnAdapter(Context context, ArrayList<Announcements> announcementList) {
        this.context = context;
        this.AnnouncementList = announcementList;
    }

    @NonNull
    @Override
    public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.announcement_recycleview,parent,false);
        return new AnnouncementViewHolder(v, context, AnnouncementList);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementViewHolder holder, int position) {
        Announcements announcements = AnnouncementList.get(position);
        holder.subject.setText(announcements.getAnnSubject());
        holder.description.setText(announcements.getAnnDes());
        holder.date.setText(announcements.getCurrentDate());
    }

    @Override
    public int getItemCount() {
        return AnnouncementList.size();
    }
}

