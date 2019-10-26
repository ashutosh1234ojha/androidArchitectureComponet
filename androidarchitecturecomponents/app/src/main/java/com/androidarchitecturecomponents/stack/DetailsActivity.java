package com.androidarchitecturecomponents.stack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.androidarchitecturecomponents.R;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_child);

        TextView textView = findViewById(R.id.tvInfo);
        textView.setText("DetailsA");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Double d;

        String s = new String();
        s.isEmpty();

    }


    void abc(double a) {


    }

    void abc(Double a) {
    }
}
