package com.androidarchitecturecomponents.lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androidarchitecturecomponents.R;

/**
 * Created by Ashutosh Ojha on 4/2/19.
 */
public class ActivityB extends AppCompatActivity {

    public static final String TAG = "ActivityB";
    public static final String TAG1 = "ABC123";

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d(TAG1, "onCreate"+TAG);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG1, "onStart"+TAG);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG1, "onResume"+TAG);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG1, "onPause"+TAG);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG1, "onStop"+TAG);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG1, "onDestroy"+TAG);

    }

}

