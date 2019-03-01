package com.androidarchitecturecomponents.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.androidarchitecturecomponents.R;

/**
 * Created by Ashutosh Ojha on 3/1/19.
 */
public class CustomActivity extends AppCompatActivity {
    private MyCustomView myCustomView;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

//        myCustomView = findViewById(R.id.customView);
//
//        findViewById(R.id.btnPaddingTop).setOnClickListener(v -> {
//            myCustomView.customPaddingUp(30);
//        });
//        findViewById(R.id.btnPaddingBottom).setOnClickListener(v -> {
//            myCustomView.customPaddingDown(30);
//
//        });
//        findViewById(R.id.btnColor).setOnClickListener(v -> {
//            myCustomView.changeColor();
//        });


    TabLayout tabLayout= findViewById(R.id.tabs);

    for(int i=1;i<12;i++){
        tabLayout.addTab(tabLayout.newTab().setText(i+""));
    }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(final TabLayout.Tab tab) {

        }

        @Override
        public void onTabUnselected(final TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(final TabLayout.Tab tab) {

        }
    });

    }
}
