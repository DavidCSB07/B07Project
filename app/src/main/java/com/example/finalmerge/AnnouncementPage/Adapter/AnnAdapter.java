package com.example.finalmerge.AnnouncementPage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.R;

import com.example.finalmerge.AnnouncementPage.Model.Announcements;

import java.util.ArrayList;

public class AnnAdapter extends RecyclerView.Adapter<AnnAdapter.MyViewHolder> {

    Context context;
    ArrayList<Announcements> list;

    public AnnAdapter(Context context, ArrayList<Announcements> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.complaints_recycleview,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Announcements announcements = list.get(position);
        holder.subject.setText(announcements.getAnnSubject());
        holder.description.setText(announcements.getAnnDes());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView subject, description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.rSubject);
            description = itemView.findViewById(R.id.rDes);
        }
    }
}

