package com.example.thegoldenleashapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap googleMap;
    private LatLng currentLatLng;
    private int radius;
    private List<Marker> randomLocations = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //intent values of radius of nearby locations
        radius = getIntent().getIntExtra("radius",2);
        //getting Map Ready
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        currentLatLng = new LatLng(26.873801,80.947523);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng,13));
        Log.d("debugging","radius in mapready : "+radius);
        nearbyLocations();
        checkPermissions();
    }

    private void checkPermissions(){
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {
            initFusedListener();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    011020);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 011020) {
            if (grantResults.length == 0)
            {   Log.d("Debugging","permissions granted");
                return;}
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(),
                        "Permission required to access location", Toast.LENGTH_SHORT).show();
            } else {
                initFusedListener();
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void initFusedListener() {

        googleMap.setMyLocationEnabled(true);
        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if(location!=null)
                        {
                            Log.d("Debugging",location.getLatitude()+" : "+location.getLongitude());
                            currentLatLng = new LatLng(26.873801,80.947523);
//                            currentLatLng = new LatLng(location.getLatitude(),location.getLongitude());
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng,15-radius));
                            Toast.makeText(MapActivity.this,"Location: "+currentLatLng.toString(),Toast.LENGTH_SHORT).show();
                            nearbyLocations();
                        }
                    }
                });
    }

    private void nearbyLocations() {
        addCircle();
        //manually adding random locations near my location
        googleMap.addMarker(new MarkerOptions()
        .position(new LatLng(26.883652,80.947056))
        .title("PetCare 1")
        .snippet("Vivekanandapuri Hydel Colony, Lucknow"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(26.874552,80.958290))
                .title("PetCare 2")
                .snippet("Karmabhoomi, Mahanagar, Lucknow"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(26.862261,80.946937))
                .title("PetCare 3")
                .snippet("4, RamKrishna Marg, Lucknow"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(26.864748,80.950087))
                .title("PetCare 4")
                .snippet("26, New Hyderabad, Hasanganj, Lucknow"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(26.876294,80.930504))
                .title("PetCare 5")
                .snippet("Sector A, Mahanagar, Lucknow"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(26.886294,80.935504))
                .title("PetCare 6")
                .snippet("Sector C, Mahanagar, Lucknow"));
    }
    private void addCircle(){
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(currentLatLng);
        Log.d("Debugging","radius : "+radius);
        Toast.makeText(MapActivity.this,"radius : "+radius,Toast.LENGTH_SHORT).show();
        circleOptions.radius(radius*1000);
        circleOptions.strokeColor(Color.parseColor("#77d00000"));
        circleOptions.fillColor(Color.parseColor("#22d00000"));
        circleOptions.strokeWidth(15);
        googleMap.addCircle(circleOptions);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        return false;
    }
}