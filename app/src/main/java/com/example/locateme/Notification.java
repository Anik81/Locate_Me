package com.example.locateme;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Notification extends AppCompatActivity implements View.OnClickListener {
    ImageView Nhome, Nmap, Ncontacts, Nsettings;
    Spinner spType;
    Button btFind;
    SupportMapFragment supportMapFragment;
    GoogleMap map;
    FusedLocationProviderClient fusedLocationProviderClient;
    double currentLat = 0, currentLong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Nhome = (ImageView) findViewById(R.id.imageView25);
        Nmap = (ImageView) findViewById(R.id.imageView27);
        Ncontacts = (ImageView) findViewById(R.id.imageView28);
        Nsettings = (ImageView) findViewById(R.id.imageView29);
        spType = findViewById(R.id.sp_type);
        btFind = findViewById(R.id.bt_find);
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map1);

        final String[] placeTypeList = {"hospital","police station"};
        String[] placeNameList = {"Hospital", "Police Station"};

        spType.setAdapter(new ArrayAdapter<>(Notification.this, android.R.layout.simple_spinner_dropdown_item, placeNameList));
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(Notification.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation();
        }else {
            ActivityCompat.requestPermissions(Notification.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
        }
        btFind.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          int i=spType.getSelectedItemPosition();
                                          String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"+"?location="+currentLat+","+currentLong+"&radius=5000"+"&types="+placeTypeList[i]+"&sensor=true"+
                                                  "&key="+getResources().getString(R.string.google_map_ke);
                                          new PlaceTask().execute(url);
                                      }
                                  }

        );

        Nhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NotificationToHome = new Intent(Notification.this, HomePage.class);
                startActivity(NotificationToHome);
            }
        });
        Nmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NotificationToMap = new Intent(Notification.this, Map.class);
                startActivity(NotificationToMap);
            }
        });
        Ncontacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NotificationToContacts = new Intent(Notification.this, Contacts.class);
                startActivity(NotificationToContacts);
            }
        });
        Nsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NotificationToSettings = new Intent(Notification.this, Seetings.class);
                startActivity(NotificationToSettings);
            }
        });

    }

    private void getCurrentLocation() {
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
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null)
                {
                    currentLat = location.getLatitude();
                    currentLong= location.getLongitude();
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            map= googleMap;
                            map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(currentLat,currentLong),10));
                        }
                    });
                }
            }
        });

    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 44){
            if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                getCurrentLocation();
            }
        }
    }

    @Override
    public void onClick(View view) {

    }

    private class PlaceTask extends AsyncTask<String,Integer,String> {
        @Override
        protected String doInBackground(String... strings) {
            String data = null;
            try {
                 data = downloadUrl(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            new ParserTask().execute(s);
        }
    }

    private String downloadUrl(String string) throws IOException {
        URL url= new URL(string);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.connect();
        InputStream stream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder builder = new StringBuilder();
        String line = null ;
        while((line=reader.readLine())!= null){

            builder.append(line);
        }
        String data = builder.toString();
        reader.close();;
        return data;
    }

    private class ParserTask extends AsyncTask<String,Integer, List<HashMap<String,String>>>{
        @Override
        protected List<HashMap<String, String>> doInBackground(String... strings) {
            JsonParser jsonParser = new JsonParser();
            List<HashMap<String,String>> mapList = null;
            JSONObject object= null;
            try {
                 object = new JSONObject(strings[0]);
                 mapList = jsonParser.parseResult(object);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return mapList;
        }

        @Override
        protected void onPostExecute(List<HashMap<String, String>> hashMaps) {
            map.clear();
            for(int i =0; i<hashMaps.size();i++)
            {
                HashMap<String,String> hashMapList = hashMaps.get(i);
                double lat= Double.parseDouble(hashMapList.get("lat"));
                double lng= Double.parseDouble(hashMapList.get("lng"));
                String name = hashMapList.get("name");
                LatLng latLng = new LatLng(lat,lng);
                MarkerOptions options = new MarkerOptions();
                options.position(latLng);
                options.title(name);
                map.addMarker(options);
            }
        }
    }
}