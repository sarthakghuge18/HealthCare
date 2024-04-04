package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {

    EditText edtFullName,edtAddress,edtContact,edtPinCode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        edtFullName = findViewById(R.id.editTextLTBFullname);
        edtAddress = findViewById(R.id.editTextLTBAddress);
        edtContact = findViewById(R.id.editTextLTBContact);
        edtPinCode = findViewById(R.id.editTextLTBPinCode);

        btnBooking = findViewById(R.id.buttonkLTBBooking);

        Intent intent = getIntent();
        String [] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(" : "));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username,edtFullName.getText().toString(),edtAddress.getText().toString(),edtContact.getText().toString(),Integer.parseInt(edtPinCode.getText().toString()),date.toString(),time.toString(),Float.parseFloat(price[1]),"lab");
                db.removeCart(username,"lab");
                Toast.makeText(LabTestBookActivity.this, "Your Booking is Done Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this, HomeActivity.class));
            }
        });
    }
}