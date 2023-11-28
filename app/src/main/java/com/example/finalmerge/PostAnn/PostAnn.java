package com.example.finalmerge.PostAnn;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.databinding.ActivityPostAnnBinding;
import com.example.finalmerge.homePage.models.Announcements;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostAnn extends AppCompatActivity {
    ActivityPostAnnBinding binding;
    String annSubject, annDes;
    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostAnnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                annSubject = binding.annSubject.getText().toString();
                annDes = binding.annDes.getText().toString();

                if(!annSubject.isEmpty() && !annDes.isEmpty()){
                    Announcements announcements = new Announcements(annSubject,annDes);
                    db = FirebaseDatabase.getInstance();
                    ref = db.getReference("Announcements");
                    ref.child(annSubject).setValue(announcements).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.annSubject.setText("");
                            binding.annDes.setText("");
                            Toast.makeText(PostAnn.this, "Success",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}