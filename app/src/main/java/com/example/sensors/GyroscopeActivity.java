package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class GyroscopeActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    EditText etxaxis,etyaxis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        etxaxis=findViewById(R.id.etxaxis);
        etyaxis=findViewById(R.id.editText2);
        sensorGyro();
    }
    private void sensorGyro()
    {
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        final SensorEventListener gyrolistener=new SensorEventListener() {

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            };
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[1]>0)
                {
                    int value1=Integer.parseInt(etxaxis.getText().toString());
                    value1=value1-1;
                    etxaxis.setText(value1);
                }
                else if (event.values[1]>0)
                {
                    int value2=Integer.parseInt(etyaxis.getText().toString());
                    value2=value2-1;
                    etxaxis.setText(value2);
                }
            }


        };
        if (sensor!=null)
        {
            sensorManager.registerListener(gyrolistener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            Toast.makeText(this, "No sensors Found", Toast.LENGTH_SHORT).show();
        }

    }
}
