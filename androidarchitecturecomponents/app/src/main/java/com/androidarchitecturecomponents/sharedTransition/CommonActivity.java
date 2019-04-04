package com.androidarchitecturecomponents.sharedTransition;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.androidarchitecturecomponents.R;

/**
 * Created by Ashutosh Ojha on 4/4/19.
 */
public class CommonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        findViewById(R.id.llOne).setOnClickListener(v -> {
            Intent intent = new Intent(CommonActivity.this, DetailsActivity.class);

            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(CommonActivity.this,
                    findViewById(R.id.ivOne), "imageOne");

            startActivity(intent, activityOptionsCompat.toBundle());
        });


        findViewById(R.id.llTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(CommonActivity.this, DetailsActivity.class);

//                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(CommonActivity.this,
//                        findViewById(R.id.ivOne), "imageOne");

                startActivity(intent);
            }
        });
    }
}
