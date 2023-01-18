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

public class MainActivity extends AppCompatActivity {
    private String username;
    DatabaseReference ref;

    CustomerData customerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Queue");
        EditText txtName = findViewById(R.id.txtName);

        ref = FirebaseDatabase.getInstance().getReference().child("Public");
        customerData = new CustomerData();


        Button btnHello = findViewById(R.id.btnClicked);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = txtName.getText().toString();
                customerData.setName(username);
                ref.push().setValue(customerData);
                Intent intent = new Intent(MainActivity.this,CustomerQ.class);
                intent.putExtra("keyname",username);

                startActivity(intent);
            }
        });



    }


}