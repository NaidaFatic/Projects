package com.example.permissions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        read = findViewById(R.id.button);

        read.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(isPermissionGranted()) {
                    Toast.makeText(MainActivity.this, "GRANTED!", Toast.LENGTH_SHORT).show();
                } else
                    requestStoragePermission();
            }
        });
    }

    public boolean isPermissionGranted(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
           return true;
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestStoragePermission(){
        if(shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)){
            Toast.makeText(this, "this is additioanl explenation", Toast.LENGTH_SHORT).show();
        }else
            requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 25);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults){
        if(requestCode == 25){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "You can access data", Toast.LENGTH_SHORT).show();
            else Toast.makeText(this, "You canot access data", Toast.LENGTH_SHORT).show();
        }
    }

}