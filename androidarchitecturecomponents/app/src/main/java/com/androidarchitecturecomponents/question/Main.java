package com.androidarchitecturecomponents.question;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androidarchitecturecomponents.R;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Ashutosh Ojha on 12/31/18.
 */
public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        findViewById(R.id.btnProgressBar).setOnClickListener(view -> {
//            Practice practice = new Practice();
//            practice.forwordConsequitivePermutation("This is my name");

            method1();

        });

        second();
        method();

        method2();


    }

    /**
     * *
     * * * *
     * * * * * *
     * * * * * * * *
     * * * * * * * * * *
     */

    void method(int a) {

        for (int i = 0; i < a; i++) {

        }

    }

    int a[] = {1};

    void second() {

        int f = a[0];
        int s = -1;

        for (int i = 1; i < a.length; i++) {

            if (a[i] > f) {
                int tm = f;
                f = a[i];
                s = tm;
            } else if (a[i] > s) {
                s = a[i];
            }

        }
        Log.d("Number", f + " highest");
        Log.d("Number", s + " second");
    }

    void method() {
        int a[] = {1, 2, 4, 5, 3, -6, 11};
        int sum = 5;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < a.length; i++) {

            if (hashSet.contains(5 - a[i])) {
                Log.d("Pair", a[i] + "," + (5 - a[i]));
            } else if (hashSet.contains(5 + a[i])) {
                Log.d("Pair", a[i] + "," + (5 + a[i]));

            }
            hashSet.add(a[i]);

        }

//       Executor executor= Executors.newFixedThreadPool(344);
//
//       executor.execute(() -> {
//
//       });


    }


    void method1() {
        int a[] = {1, 1, 4, 5, 3, 6, 4};
        int b[] = new int[a.length];

        Log.d("Array", Arrays.toString(a) + " Before");


        Arrays.sort(a);


        Log.d("Array", Arrays.toString(a) + "After");

        int pre = a[0], j = 0;
        b[j++] = a[0];
        for (int i = 1; i < a.length; i++) {

            if (a[i] == pre) {

//                b[j++] = a[i];

            } else {
                b[j++] = a[i];

            }
            pre = a[i];
        }

        Log.d("Array", Arrays.toString(b) + "removed");


    }

    void method2() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.size();

        int j = 0;

        for (int i = 0; i < linkedList.size(); i++) {

            if (i / 3 != 0) {
                j++;
            }
        }


        Log.d("LengthOf", j + "After");

    }


}
