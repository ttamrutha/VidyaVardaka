package com.example.vidyavardaka;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class FusedClientActivity extends AppCompatActivity {
    private FusedLocationProviderClient mFusedLocationClient;
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;

        if(!checkPermission()){
            requestPermission();
            Toast.makeText(context, "Loc1=" , Toast.LENGTH_SHORT).show();

            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
            mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        double wayLatitude = location.getLatitude();
                        double wayLongitude = location.getLongitude();
                        Toast.makeText(context, "Loc=" + wayLatitude + "," + wayLongitude, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(context, "Loc=" , Toast.LENGTH_SHORT).show();

                    }
                }

            });
        }
        else
        {
            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
            mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        double wayLatitude = location.getLatitude();
                        double wayLongitude = location.getLongitude();
                        Toast.makeText(context, "Loc=" + wayLatitude + "," + wayLongitude, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(context, "Loc=" , Toast.LENGTH_SHORT).show();

                    }
                }

            });
        }

    }

    public  boolean checkPermission() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            return false;
        }
        return true;
    }

    public  void requestPermission() {

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(context, "Location Permited", Toast.LENGTH_SHORT).show();
                }
        }
    }


}
