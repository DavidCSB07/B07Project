package com.example.finalmerge.ComplaintsPage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.ComplaintsPage.Holder.ComplaintViewHolder;
import com.example.finalmerge.ComplaintsPage.Model.Complaint;
import com.example.finalmerge.R;

import java.util.ArrayList;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintViewHolder> {

    Context context;
    ArrayList<Complaint> listComplaints;

    public ComplaintAdapter(Context context, ArrayList<Complaint> listComplaints) {
        this.context = context;
        this.listComplaints = listComplaints;
    }

    @NonNull
    @Override
    public ComplaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.complaints_recycleview,parent,false);
        return new ComplaintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintViewHolder holder, int position) {
        Complaint complaints=listComplaints.get(position);
        holder.email.setText(complaints.getEmail());
        holder.subject.setText(complaints.getSubject());
        holder.complaint.setText(complaints.getComplaint());
    }

    @Override
    public int getItemCount() {
        return listComplaints.size();
    }

}
