package com.androidarchitecturecomponents.question;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.androidarchitecturecomponents.R;

/**
 * Created by Ashutosh Ojha on 12/31/18.
 */
public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        findViewById(R.id.btnProgressBar).setOnClickListener(view -> {
            Practice practice=new Practice();
            practice.forwordConsequitivePermutation("This is my name");
        });


    }
}
