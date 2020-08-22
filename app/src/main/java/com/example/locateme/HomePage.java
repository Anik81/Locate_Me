package com.example.locateme;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class HomePage extends AppCompatActivity implements View.OnClickListener, SensorEventListener {
    ImageView hnotification, hmap, hcontacts, hsettings, exit;
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private boolean isAccelerometerSensorAvailable,itIsNotFirstTime=false;
    private  float currentX,currentY,currentZ,lastX,lastY,lastZ;
    private  float xDiff,yDiff,zDiff;
    private float Shake= 20f;
    private Vibrator vibrator;
    private TextView L1, L2, Country, Locality, Address;
    FusedLocationProviderClient fusedLocationProviderClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        hnotification = (ImageView) findViewById(R.id.imageView19);
        hmap = (ImageView) findViewById(R.id.imageView20);
        hcontacts = (ImageView) findViewById(R.id.imageView21);
        hsettings = (ImageView) findViewById(R.id.imageView22);
        exit = (ImageView) findViewById(R.id.imageView43);
        L1 = findViewById(R.id.L1);
        L2 = findViewById(R.id.L2);
        Country = findViewById(R.id.Country);
        Locality = findViewById(R.id.Locality);
        Address = findViewById(R.id.Address);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        hnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HometoNotificationIn = new Intent(HomePage.this, Notification.class);
                startActivity(HometoNotificationIn);
            }
        });
        hmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent HometoMapIn = new Intent(HomePage.this, Map.class);
                startActivity(HometoMapIn);
            }
        });
        hcontacts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent HometoContactsIn = new Intent(HomePage.this, Contacts.class);
                startActivity(HometoContactsIn);
            }
        });
        hsettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent HometoSettingIn = new Intent(HomePage.this, Seetings.class);
                startActivity(HometoSettingIn);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent HometoFirstPage = new Intent(HomePage.this, MainActivity.class);
                startActivity(HometoFirstPage);
            }
        });

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null)
        {
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            isAccelerometerSensorAvailable=true;
        }else {
            isAccelerometerSensorAvailable=false;
        }

    }

    @Override
    public void onClick(View view) {

    }
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if(location != null)
                {
                    try {
                        Geocoder geocoder= new Geocoder(HomePage.this, Locale.getDefault());
                        List<android.location.Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

                        L1.setText("Latitude :" + addresses.get(0).getLatitude());
                        L2.setText("Longitude :" + addresses.get(0).getLongitude());
                        Country.setText("Country Name :" + addresses.get(0).getCountryName());
                        Locality.setText("Locality :" + addresses.get(0).getLocality());
                        Address.setText("Address :" + addresses.get(0).getAddressLine(0));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        currentX=event.values[0];
        currentY=event.values[1];
        currentZ=event.values[2];

        if(itIsNotFirstTime)
        {
            xDiff= Math.abs(lastX-currentX);
            yDiff= Math.abs(lastY-currentY);
            zDiff= Math.abs(lastZ-currentZ);

            if((xDiff > Shake && yDiff > Shake) || (xDiff > Shake && zDiff > Shake) || (yDiff > Shake && zDiff > Shake))
            {
                vibrator.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
                if (ActivityCompat.checkSelfPermission(HomePage.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(HomePage.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }

            }

        }
        lastX=currentX;
        lastY=currentY;
        lastZ=currentZ;
        itIsNotFirstTime=true;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isAccelerometerSensorAvailable)
        {
            sensorManager.registerListener(this,accelerometerSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isAccelerometerSensorAvailable)
            sensorManager.unregisterListener(this);


    }
}