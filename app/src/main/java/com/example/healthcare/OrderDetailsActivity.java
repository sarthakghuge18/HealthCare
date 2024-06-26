package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsActivity extends AppCompatActivity {

    private String[][] orderDetails = {};
    ListView lst;
    Button btnBack;
    HashMap<String ,String> item;
    ArrayList list;

    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        btnBack = findViewById(R.id.buttonODBack);
        lst = findViewById(R.id.listViewOD);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailsActivity.this, HomeActivity.class));
            }
        });

        Database db = new Database(getApplicationContext(),"healthcare",null,1);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();
        ArrayList dbData = db.getOrderData(username);


        orderDetails = new String[dbData.size()][];
        for(int i = 0; i<orderDetails.length;i++){
            orderDetails[i] = new String[5];
            String arrData = dbData.get(i).toString();
            String [] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            orderDetails[i][0] = strData[0];
            orderDetails[i][1] = strData[1];
            if(strData[7].compareTo("medicine")==0){
                orderDetails[i][3] = "Del : "+strData[4];
            }else{
                orderDetails[i][3] = "Del : "+strData[4] + " " + strData[5];
            }
            orderDetails[i][2] = "Rs."+strData[6];
            orderDetails[i][4] = strData[7];
        }

        list = new ArrayList();
        for(int i = 0 ;i<orderDetails.length;i++){
            item = new HashMap<String, String>();
            item.put("line1",orderDetails[i][0]);
            item.put("line2",orderDetails[i][1]);
            item.put("line3",orderDetails[i][2]);
            item.put("line4",orderDetails[i][3]);
            item.put("line5",orderDetails[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_e,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);
    }
}