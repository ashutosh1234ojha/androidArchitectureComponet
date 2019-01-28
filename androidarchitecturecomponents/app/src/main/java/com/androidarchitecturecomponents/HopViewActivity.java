package com.androidarchitecturecomponents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ashutosh Ojha on 1/22/19.
 */
public class HopViewActivity extends AppCompatActivity {

    private Button btnHop;
    private TextView tvMsg;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_view);

        btnHop=findViewById(R.id.btnHop);
        tvMsg=findViewById(R.id.tvMsg);




       btnHop.setOnClickListener(view -> {

           ViewPropertyAnimator viewPropertyAnimator=tvMsg.animate().translationYBy(-40f).setDuration(200).withEndAction(() -> {
               tvMsg.animate().translationYBy(40f).setDuration(200);
           });


       });
    }
}
