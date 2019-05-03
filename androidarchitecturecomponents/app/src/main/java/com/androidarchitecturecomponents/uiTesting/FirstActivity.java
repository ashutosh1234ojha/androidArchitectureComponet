package com.androidarchitecturecomponents.uiTesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.androidarchitecturecomponents.R;

/**
 * Created by Ashutosh Ojha on 4/22/19.
 */
public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        findViewById(R.id.btnProgressBar).setOnClickListener(v -> startActivity(
                new Intent(FirstActivity.this, SecondActivity.class)));
    }
}
