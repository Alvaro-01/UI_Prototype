package ca.georgebrown.comp3074.uiprototype;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MonitoringActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        getSupportActionBar().setTitle("Monitoring");


    }
}