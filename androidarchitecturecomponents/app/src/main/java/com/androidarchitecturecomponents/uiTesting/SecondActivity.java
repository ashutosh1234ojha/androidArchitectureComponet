package com.androidarchitecturecomponents.uiTesting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.androidarchitecturecomponents.R;

/**
 * Created by Ashutosh Ojha on 4/22/19.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_view);
    }
}
