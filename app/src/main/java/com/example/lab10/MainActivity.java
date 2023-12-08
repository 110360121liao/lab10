package com.example.lab10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults
    ) {
        super,onRequestPermissionsResult(requestCode,permissions,grantResults);
        if(requestCode==1){
            for(int result: grantResults){
                if(result != PackageManager.PERMISSION_GRANTED) finish();
                else initMap();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED )
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        else
            initMap();
    }
}