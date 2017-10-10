package com.example.rasmus_laptop.dtuguide.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rasmus_laptop.dtuguide.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment /* implements OnMapReadyCallback */ {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.map_layout, container, false);

       // SupportMapFragment mfragment = (SupportMapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map);
       // mfragment.getMapAsync(this);

        return view;
    }


   // @Override
   // public void onMapReady(GoogleMap map) {
   //     map.addMarker(new MarkerOptions()
   //             .position(new LatLng(0, 0))
   //             .title("Marker"));
   // }
}