package com.androidarchitecturecomponents.threadpoolexecutor;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.androidarchitecturecomponents.R;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Ashutosh Ojha on 3/5/19.
 */
public class ThreadPoolExecutorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {

        });

        EditText editText = findViewById(R.id.etTitle);

        try {
            EditTextTint.applyColor(editText, Color.RED);
        } catch (EditTextTint.EditTextTintError e) {
            e.printStackTrace();
        }

//newFixedThreadPool method creates a ThreadPoolExecutor with equal corePoolSize and maximumPoolSize parameter values and a zero keepAliveTime.
// This means that the number of threads in this thread pool is always the same:


//        ThreadPoolExecutor executor1 =
//                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//        executor1.submit(() -> {
//            Thread.sleep(1000);
//            return null;
//        });
//        executor1.submit(() -> {
//            Thread.sleep(1000);
//            return null;
//        });
//        executor1.submit(() -> {
//            Thread.sleep(1000);
//            return null;
//        });
//
//        Log.d("ThreadPoolExecutor", executor1.getPoolSize() + "  pool size");
//        Log.d("ThreadPoolExecutor", executor1.getQueue().size() + "  queue size");
//
//
//        ScheduledExecutorService executorService = (ScheduledExecutorService) Executors.newFixedThreadPool(5);
//        executorService.schedule(() -> {
//
//        }, 10, TimeUnit.MILLISECONDS);

//        AppCompatImageView ivCall=findViewById(R.id.ivCall);
////        DrawableCompat.setTint(ivCall.getDrawable(), Color.parseColor("#db402c"));
//
//        Drawable drawable = getDrawable(R.drawable.ic_more_vert_black_24dp);
//        drawable = DrawableCompat.wrap(drawable);
//        DrawableCompat.setTint(drawable, Color.GREEN);


//        Drawable normalDrawable = getResources().getDrawable(R.drawable.ic_more_vert_black_24dp);
//        Drawable wrapDrawable = DrawableCompat.wrap(normalDrawable);


//Post lollipop

//        ImageView ivCall=findViewById(R.id.ivCall);
//        DrawableCompat.setTint(ivCall.getDrawable(), Color.parseColor("#db402c"));


//Pre lollipop
//        Drawable normalDrawable = getResources().getDrawable(R.drawable.ic_more_vert_black_24dp);
//        Drawable wrapDrawable = DrawableCompat.wrap(normalDrawable);
//        DrawableCompat.setTint(wrapDrawable, Color.parseColor("#db402c"));


        //Both
//        ImageView ivCall = findViewById(R.id.ivCall);
//        Drawable normalDrawable = getResources().getDrawable(R.drawable.ic_more_vert_black_24dp);
//        Drawable wrapDrawable = DrawableCompat.wrap(ivCall.getDrawable());
//        DrawableCompat.setTint(DrawableCompat.wrap(ivCall.getDrawable()), Color.parseColor("#db402c"));


        //Drawable left
//
//        TextView textView=findViewById(R.id.tvHello);
//        Drawable mDrawable = ContextCompat.getDrawable(this, R.drawable.ic_delete_black_24dp);
//        DrawableCompat.setTint(DrawableCompat.wrap(mDrawable), Color.parseColor("#db402c"));
//        textView.setCompoundDrawablesWithIntrinsicBounds( mDrawable, null, null, null);


        findViewById(R.id.btnWorkManager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                setColor(ContextCompat.getDrawable(ThreadPoolExecutorActivity.this, R.drawable.ic_delete_black_24dp),
                        ContextCompat.getDrawable(ThreadPoolExecutorActivity.this, R.drawable.ic_more_vert_black_24dp));
//
//                DrawableCompat.setTint(DrawableCompat.wrap(ContextCompat.getDrawable(ThreadPoolExecutorActivity.this, R.drawable.ic_delete_black_24dp)),
//                        Color.parseColor("#db402c"));

                startActivity(new Intent(ThreadPoolExecutorActivity.this, AActivity.class));

                finish();
            }
        });


    }

    void setColor(Drawable... databases) {

        for (Drawable drawable : databases) {
            DrawableCompat.setTint(DrawableCompat.wrap(drawable),
                    Color.parseColor("#db402c"));
        }

    }

}
