package com.androidarchitecturecomponents.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.androidarchitecturecomponents.R;

/**
 * Created by Ashutosh Ojha on 1/28/19.
 */
public class ActivityB extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Log.e("Tag", "onCreate B");
        TextView textView= findViewById(R.id.tvScreen);
        textView.setText("Activity B");
        findViewById(R.id.btnLaunchA).setOnClickListener(view -> {

            startActivity(new Intent(this,ActivityA.class));
        });

        findViewById(R.id.btnLaunchB).setOnClickListener(view -> {
            startActivity(new Intent(this,ActivityB.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Tag", "onDestroy B");

    }

    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        Log.e("Tag", "onNewIntent B");
    }
}
