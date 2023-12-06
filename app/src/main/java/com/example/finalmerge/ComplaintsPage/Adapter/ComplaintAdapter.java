package com.example.finalmerge.ComplaintsPage.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.ComplaintsPage.ComplaintDetail;
import com.example.finalmerge.ComplaintsPage.Holder.ComplaintViewHolder;
import com.example.finalmerge.ComplaintsPage.Model.Complaint;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;

import java.util.ArrayList;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintViewHolder> {

    Context context;
    ArrayList<Complaint> list;

    public ComplaintAdapter(Context context, ArrayList<Complaint> listComplaints) {
        this.context = context;
        this.list = listComplaints;
    }

    @NonNull
    @Override
    public ComplaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.complaints_recycleview,parent,false);
        return new ComplaintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintViewHolder holder, int position) {
        holder.email.setText(list.get(position).getEmail());
        holder.subject.setText(list.get(position).getSubject());
        holder.complaint.setText(list.get(position).getComplaint());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ComplaintDetail.class);
                intent.putExtra("contentEmail", list.get(position).getEmail());
                intent.putExtra("contentSubject", list.get(position).getSubject());
                intent.putExtra("contentComplaint", list.get(position).getComplaint());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
