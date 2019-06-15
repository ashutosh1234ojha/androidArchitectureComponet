package com.androidarchitecturecomponents.question;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;

import com.androidarchitecturecomponents.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Ashutosh Ojha on 12/31/18.
 */
public class Main extends AppCompatActivity {

    RadioGroup radioGroup;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        findViewById(R.id.btnProgressBar).setOnClickListener(view -> {
            Practice practice = new Practice();
//            practice.forwordConsequitivePermutation("This is my name");

//            method1();
//
//            method3();

            method4();

            practice.rotationCount();
            practice.rearrangeArray();


        });

//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(final RadioGroup group, final int checkedId) {
//
//            }
//        });

        second();
        method();

        method2();

        method4();


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

    void method3() {
        String input = "ramamrt";
        String[] split = input.split("");

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String aSplit : split) {

            int value;
            if (hashMap.containsKey(aSplit)) {
                value = hashMap.get(aSplit);
                hashMap.put(aSplit, ++value);
            } else {
                hashMap.put(aSplit, 1);
            }
        }

        for (String aSplit : split) {
            if (hashMap.get(aSplit) == 1) {
                Log.d("FirstNonRepeated", aSplit);
            }
        }

        HashSet<String> hashSet = new HashSet<>();


    }

    void method4() {
        String one = "1234";
        String[] oneSplit = one.split("");
        String two = "3412";
        String[] twoSplit = two.split("");

        String min = oneSplit[1];

        for (int j = 1; j < twoSplit.length; j++) {
            if (min.equals(twoSplit[j])) {
                Log.d("Rotation", j + "position");
            }
        }


    }

    String input[] = {"A", "B", "C"};


    void method5() {

    }


}
