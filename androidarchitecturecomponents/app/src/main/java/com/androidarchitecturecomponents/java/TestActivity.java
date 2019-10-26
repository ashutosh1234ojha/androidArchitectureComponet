package com.androidarchitecturecomponents.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.androidarchitecturecomponents.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Child child = new Child();
        Parent parent = new Parent();
        Parent parent1 = new Child();


    }

    int a[] = {1, -1, 2, 3, 5, -7, 4, -3};
    int b[] = {1, -1, 2, -7, 3, -3, 5, 4};

    int c[] = new int[8];

    int pos = 0, neg = 1;
    boolean isEvenTurn = true;

    int length = a.length;

    void rearrange() {

        for (int z = 0; z < a.length; z++) {


            if (a[z] > 0) {

                c[pos] = a[z];

                if (pos >length)
                    pos = pos + 2;
            } else {
                c[neg] = a[z];
                neg = neg + 2;
            }
        }

    }
}
