package com.example.finalmerge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_complaints);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();

            }
        });
    }

    private void showDialog() {
        final AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Complaints form");
        dialog.setMessage("Submit your complaints here");

        LayoutInflater inflater= LayoutInflater.from(this);

        View reg_layout=inflater.inflate(R.layout.activity_complaints, null);

        final MaterialEditText editEmail=reg_layout.findViewById(R.id.editEmail);
        final MaterialEditText editSubject=reg_layout.findViewById(R.id.editSubject);
        final MaterialEditText editComplaint=reg_layout.findViewById(R.id.editComplaint);

        dialog.setView(reg_layout);

        //set button

        dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //check validation

                Editable editable=editEmail.getText();
                if (editable==null || TextUtils.isEmpty(editable.toString())) {
                    Toast.makeText(MainActivity.this, "Please type email", Toast.LENGTH_SHORT).show();
                }

                editable=editSubject.getText();
                if (editable==null || TextUtils.isEmpty(editable.toString())) {
                    Toast.makeText(MainActivity.this, "Subject cannot be empty",Toast.LENGTH_SHORT).show();
                }

                editable=editComplaint.getText();
                if (editable==null || TextUtils.isEmpty(editComplaint.toString())) {
                    Toast.makeText(MainActivity.this, "Complaint cannot be empty",Toast.LENGTH_SHORT).show();
                }

                FirebaseDatabase database=FirebaseDatabase.getInstance();

                DatabaseReference ref=database.getReference();

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Object value=dataSnapshot.getValue();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivity.this, "Failed to read value", Toast.LENGTH_SHORT).show();

                    }
                });

                ref.child("Complaints").child(editEmail.getText().toString()).child("Email").setValue(editEmail.getText().toString());
                ref.child("Complaints").child(editEmail.getText().toString()).child("Subject").setValue(editSubject.getText().toString());
                ref.child("Complaints").child(editEmail.getText().toString()).child("Complaint").setValue(editComplaint.getText().toString());

                Toast.makeText(MainActivity.this, "Thank you for your feedback", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();

        }
    }
