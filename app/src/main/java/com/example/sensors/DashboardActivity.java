package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button btnaccelo,btnsensor,btngyros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnaccelo=findViewById(R.id.btnaccelo);
        btnsensor=findViewById(R.id.btnsensorlist);
        btngyros=findViewById(R.id.btngyro);

        btngyros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,GyroscopeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnaccelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,AccelerometerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnsensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
