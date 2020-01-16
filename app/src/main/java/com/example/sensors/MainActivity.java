package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    TextView tvsensorlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvsensorlist=findViewById(R.id.tvsensorlist);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensorList=sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i=0;i<sensorList.size();i++)
        {
            String sensors="";
            sensors += sensorList.get(i).getName() + "\n";
            tvsensorlist.append(sensors);
        }

    }
}
