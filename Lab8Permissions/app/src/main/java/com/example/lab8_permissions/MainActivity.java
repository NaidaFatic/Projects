package com.example.lab8_permissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private FusedLocationProviderClient fusedLocationProviderClient;
    private GoogleMap map;
    private SupportMapFragment supportMapFragment;
    private static final int LOCATION_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_map);
        supportMapFragment.getMapAsync(this);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    public void onButtonClick(View view){
        switch (view.getId()){
            case R.id.button:
                LatLng sydney = new LatLng(-34,151);
                map.clear();
                map.animateCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case R.id.button2:
                getLocation();
                break;
        }
    }

    private void getLocation(){
        if(checkPermission()){
            if(isLocationEnabled()){
                fusedLocationProviderClient.getLastLocation().addOnCompleteListener(
                        new OnCompleteListener<Location>() {
                            @Override
                            public void onComplete(@NonNull Task<Location> task) {
                                Location location=task.getResult();

                                if(location != null){
                                    LatLng current = new LatLng(location.getLatitude(), location.getLongitude());
                                    map.clear();

                                    map.addMarker(new MarkerOptions().position(current).title("Marker in current"));
                                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(current,15.0f));

                                }else
                                    Toast.makeText(MainActivity.this, "unavaible location", Toast.LENGTH_SHORT).show();

                            }
                        }
                );
            }else{
                Toast.makeText(MainActivity.this, "location disabled", Toast.LENGTH_SHORT).show();
            }
        }else {
            getPermissions();
        }
    }

    private boolean isLocationEnabled(){
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) || locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private boolean checkPermission(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED)
            return true;
        return false;
    }

    private void getPermissions(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                LOCATION_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == LOCATION_CODE){
            if(grantResults != null && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this, "granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}