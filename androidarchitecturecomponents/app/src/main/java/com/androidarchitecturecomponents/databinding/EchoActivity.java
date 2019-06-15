package com.androidarchitecturecomponents.databinding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidarchitecturecomponents.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class EchoActivity extends AppCompatActivity {
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.androidarchitecturecomponents.databinding.ActivityEchoBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_echo);

        binding.setEcho(new Echo());

        init();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.list_grid_view);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(this));

        ArrayList arrayList = new ArrayList();
        arrayList.add(new MyItem("First", "https://api.androidhive.info/progressdialog/hive.jpg"));
        arrayList.add(new MyItem("Second", "https://api.androidhive.info/progressdialog/hive.jpg"));
//        mAdapter = new MyAdapter(arrayList);
        recyclerView.setAdapter(mAdapter);

    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).placeholder(R.drawable.ic_clear_black_24dp).into(view);

    }

//    public void onFabClicked(View view) {
//        Toast.makeText(getApplicationContext(), "FAB clicked!", Toast.LENGTH_SHORT).show();
//    }

    public class MyClickHandlers {
        public void onButtonClick(View view) {
            Toast.makeText(getApplicationContext(), "FAB clicked!", Toast.LENGTH_SHORT).show();
            Log.d("Handler", "Fab click");
        }

    }
}

