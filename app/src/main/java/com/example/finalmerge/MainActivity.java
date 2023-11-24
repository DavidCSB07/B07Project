package com.example.finalmerge;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.rengwuxian.materialedittext.MaterialEditText;

import android.content.DialogInterface;
import android.os.Bundle;
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

                if (TextUtils.isEmpty(editEmail.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please type email", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(editSubject.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Subject cannot be empty",Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(editComplaint.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Complaint cannot be empty",Toast.LENGTH_SHORT).show();
                }


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
