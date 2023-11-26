package com.example.finalmerge;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import com.example.finalmerge.homePage.models.Announcements;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListAdapter extends ArrayAdapter {

    private Activity mContext;
    List<Announcements> announcementList;
    public ListAdapter(Activity mContext, List<Announcements> announcementList){
        super(mContext, R.layout.list_item, announcementList);
        this.mContext = mContext;
        this.announcementList = announcementList;
    }

    @NonNull
    public View getview(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item, null, true);

        TextView subject = listItemView.findViewById(R.id.subject);
        TextView ann_description = listItemView.findViewById(R.id.ann_description);
        TextView id = listItemView.findViewById(R.id.id);

        Announcements announcements = announcementList.get(position);

        subject.setText(announcements.getTitle);
        subject.setText(announcements.getDescription);
        subject.setText(announcements.getId);

        return listItemView;
    }
}
