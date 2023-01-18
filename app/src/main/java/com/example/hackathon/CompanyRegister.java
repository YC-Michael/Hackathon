package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CompanyRegister extends AppCompatActivity {
    private TextView name;
    EditText CompaniesName;
    Button InsertData;
    DatabaseReference ref;
    CompanyData member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register);

        EditText CompaniesName = findViewById(R.id.CompanyName);
        InsertData = (Button) findViewById(R.id.InsertData);
        ref= FirebaseDatabase.getInstance().getReference().child("Company");
        member = new CompanyData();

        InsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                member.setName_Company(CompaniesName.getText().toString().trim());
                ref.push().setValue(member);
                Toast.makeText(CompanyRegister.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}