package com.androidarchitecturecomponents.stack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.androidarchitecturecomponents.R;

public class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);


        findViewById(R.id.btnTabA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentActivity.this, ListAActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.btnTabB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentActivity.this, ListBActivity.class);
                startActivity(intent);
            }
        });
    }
}
