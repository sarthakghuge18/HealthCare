package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDocterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_docter);

        CardView back = findViewById(R.id.cardFDBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDocterActivity.this,HomeActivity.class));
            }
        });


        CardView familyPhysician = findViewById(R.id.cardFDFamilyPhysician);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDocterActivity.this,DocterDetailsActivity.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);
            }
        });

        CardView dietician = findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDocterActivity.this,DocterDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });

        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDocterActivity.this,DocterDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });

        CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDocterActivity.this,DocterDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });

        CardView cardiologists = findViewById(R.id.cardFDCardiologists);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDocterActivity.this,DocterDetailsActivity.class);
                it.putExtra("title","Cardiologists");
                startActivity(it);
            }
        });

    }
}