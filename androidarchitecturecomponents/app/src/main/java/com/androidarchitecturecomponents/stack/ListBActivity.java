package com.androidarchitecturecomponents.stack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.androidarchitecturecomponents.R;

public class ListBActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_child);

        TextView textView = findViewById(R.id.tvInfo);
        textView.setText("ListB");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBActivity.this, DetailsBActivity.class);
                startActivity(intent);
            }
        });


    }
}
