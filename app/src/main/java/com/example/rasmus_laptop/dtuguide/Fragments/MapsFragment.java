package com.example.rasmus_laptop.dtuguide.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.rasmus_laptop.dtuguide.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements OnMapReadyCallback, LocationListener {

    private GoogleMap map;
    private LocationManager locationManager;
    Button lyngbyButton;
    Button ballerupButton;
    public static final int LOCATION_REQUEST_CODE = 1001; //Any number

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.map_layout, container, false);
        MapFragment mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        lyngbyButton = (Button) view.findViewById(R.id.lyngby_button);
        ballerupButton = (Button) view.findViewById(R.id.ballerup_button);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

           // requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_REQUEST_CODE);

        } else {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 1, this);

        }


        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        lyngbyButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                map.clear();
                LatLng currentLocation = new LatLng(55.7845883,12.5173655);

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(currentLocation);
                map.addMarker(markerOptions);
                map.setMaxZoomPreference(15.0f);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 17.0f));
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 17.0f));

            }
        });

        ballerupButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                map.clear();
                LatLng currentLocation = new LatLng(55.7310917,12.3962129);

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(currentLocation);
                map.addMarker(markerOptions);
                map.setMaxZoomPreference(17f);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 17.0f));
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 17.0f));

            }
        });


        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
         && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_REQUEST_CODE);
        } else {
            map.setMyLocationEnabled(true);
        }

    }

    @Override
    public void onLocationChanged(Location location) {

        map.clear();
        LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(currentLocation);
        map.addMarker(markerOptions);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 17.0f));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 17.0f));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}



