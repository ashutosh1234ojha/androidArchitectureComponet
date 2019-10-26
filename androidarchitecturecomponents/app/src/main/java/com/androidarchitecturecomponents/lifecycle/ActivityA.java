package com.androidarchitecturecomponents.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.androidarchitecturecomponents.Child;
import com.androidarchitecturecomponents.R;
import com.bumptech.glide.Glide;

import java.util.Arrays;

/**
 * Created by Ashutosh Ojha on 4/2/19.
 */
public class ActivityA extends AppCompatActivity {

    public static final String TAG = "ActivityA";
    public static final String TAG1 = "ABC123";

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
//        setContentView(R.layout.activity_a);

        Log.d(TAG1, "onCreate" + TAG);

        Button button = findViewById(R.id.new1);
        button.setText("buttonone");

        findViewById(R.id.new1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
//                getSupportFragmentManager().beginTransaction().add(R.id.flContainer, new FragmentA()).commit();

                startActivity(new Intent(ActivityA.this, ActivityB.class));
            }
        });

        findViewById(R.id.new2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                getSupportFragmentManager().beginTransaction().addToBackStack("")
                        .add(R.id.flContainer, new FragmentB()).commit();

            }
        });

        arrange();

        Child.rotate();

        ImageView iv = findViewById(R.id.iv);
        Glide.with(this).asGif().load(R.raw.splash).into(iv);

    }

    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG1, "onStart" + TAG);

//        setContentView(R.layout.activity_a);
//        Button button = findViewById(R.id.new1);
//
//        button.setText("buttontwo");


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG1, "onRestart" + TAG);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG1, "onSaveInstanceState" + TAG);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG1, "onRestoreInstanceState" + TAG);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG1, "onResume" + TAG);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG1, "onPause" + TAG);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG1, "onStop" + TAG);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG1, "onDestroy" + TAG);

    }


    int input[] = {5, 4, -3, 2, -1};
//    int input[] = {-5, 4, 3, -2, -1};

    int i = 0, j = input.length - 1;

    void arrange() {

        System.out.println(Arrays.toString(input));

        while (i < j) {

            if (input[i] < 0 && input[j] > 0) {

                i++;
                j--;

            } else if (input[i] < 0 && input[j] < 0) {
                i++;

            } else if (input[i] > 0 && input[j] > 0) {

                j--;

            } else if (input[i] > 0 && input[j] < 0) {


                int temp1 = input[i];
                int temp2 = input[j];

                input[i] = temp2;
                input[j] = temp1;

            }
        }

        System.out.println(Arrays.toString(input));


    }


    void method() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                Looper.prepare();
                Handler handler=new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });

                handler.handleMessage(new Message());

                Looper.loop();
            }
        });

        Thread thread1 = new Thread(() -> {

        });


        thread.start();


        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };
    }
Handler handler=new Handler();
    class  MyTh extends Thread{
        @Override
        public void run() {
            super.run();

//            handler.post()


        }
    }


}

