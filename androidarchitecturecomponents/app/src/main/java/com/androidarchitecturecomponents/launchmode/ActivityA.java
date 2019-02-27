package com.androidarchitecturecomponents.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.androidarchitecturecomponents.R;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Ashutosh Ojha on 1/28/19.
 */
public class ActivityA extends AppCompatActivity {

    private String apiKey = "AIzaSyCAef1zxK2Dzeva5UVxlnplAlSGPKkJAao";
    private PlacesClient placesClient;
    private static final int AUTOCOMPLETE_REQUEST_CODE = 23487;
    private TextView textView;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Log.e("Tag", "onCreate A");

        places();

        textView = findViewById(R.id.tvScreen);
        textView.setText("Activity A");

        findViewById(R.id.btnLaunchA).setOnClickListener(view -> {

//            startActivity(new Intent(this, ActivityA.class));
            startAutocompleteActivity();
        });

        findViewById(R.id.btnLaunchB).setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityB.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

        });

//        recurringTime();


        Date date = new GregorianCalendar(2018, 02, 12).getTime();

        Log.d("DateGrego", date + "");
    }

    private void recurringTime() {

        List<Date> dates = new ArrayList<Date>();

        String str_date = "27/08/2010";
        String end_date = "02/09/2010";

        DateFormat formatter;

        formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null, endDate = null;
        try {
            startDate = (Date) formatter.parse(str_date);
            endDate = (Date) formatter.parse(end_date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
        long endTime = endDate.getTime(); // create your endtime here, possibly using Calendar or Date
        long curTime = startDate.getTime();
        while (curTime <= endTime) {
            dates.add(new Date(curTime));
            curTime += interval;
        }
        for (int i = 0; i < dates.size(); i++) {
            Date lDate = (Date) dates.get(i);
            String ds = formatter.format(lDate);
            System.out.println(" Date is ..." + ds);
        }
    }

    private void startAutocompleteActivity() {

        List<Place.Field> selectedList = new ArrayList<>();
        selectedList.add(Place.Field.ADDRESS);
        Intent autocompleteIntent =
                new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, selectedList)
//                        .setInitialQuery(getQuery())
//                        .setCountry(getCountry())
//                        .setLocationBias(getLocationBias())
//                        .setLocationRestriction(getLocationRestriction())
//                        .setTypeFilter(getTypeFilter())
                        .build(ActivityA.this);
        startActivityForResult(autocompleteIntent, AUTOCOMPLETE_REQUEST_CODE);
    }

    private void places() {
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }


        // Retrieve a PlacesClient (previously initialized - see MainActivity)
        placesClient = Places.createClient(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Tag", "onDestroy A");

    }

    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        Log.e("Tag", "onNewIntent A");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == AutocompleteActivity.RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(intent);

                textView.setText(place.getAddress());

            }
        }

        // Required because this class extends AppCompatActivity which extends FragmentActivity
        // which implements this method to pass onActivityResult calls to child fragments
        // (eg AutocompleteFragment).
        super.onActivityResult(requestCode, resultCode, intent);
    }
}
