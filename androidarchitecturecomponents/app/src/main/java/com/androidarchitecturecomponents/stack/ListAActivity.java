package com.androidarchitecturecomponents.stack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.androidarchitecturecomponents.R;

public class ListAActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_child);

        TextView textView = findViewById(R.id.tvInfo);
        textView.setText("ListA");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListAActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });


    }
}
