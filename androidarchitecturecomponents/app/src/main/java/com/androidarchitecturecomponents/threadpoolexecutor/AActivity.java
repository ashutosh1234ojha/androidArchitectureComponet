package com.androidarchitecturecomponents.threadpoolexecutor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.androidarchitecturecomponents.R;

import java.util.HashMap;

/**
 * Created by Ashutosh Ojha on 3/13/19.
 */
public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        findViewById(R.id.new1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
//                startActivity(new Intent(AActivity.this, BActivity.class));


//                reverse();

//                reverse1();
//                count();

                prime();

            }
        });


    }

    public void method() {
        int n = 5;
        Log.d("Tag", "start");
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print("1 ");
            }

            System.out.println("");
        }
    }

    public void method1() {
        int n = 5;
        Log.d("Tag", "start");
        for (int i = 0; i < n; i++) {

            for (int j = n - i; j > 0; j--) {
                System.out.print("1 ");
            }

            System.out.println("");
        }
    }

    public void reverse() {
        String input = "abc def";
        String[] split = input.split(" ");

        if (split.length <= 1) {
            String innerSplit[] = input.split("");
            String op = "";
            for (int i = innerSplit.length - 1; i >= 0; i--) {
                op = op + innerSplit[i];
            }

            Log.d("Output", op);
        } else {
            String op = "";

            for (int i = split.length - 1; i >= 0; i--) {
                String innerSplit[] = split[i].split("");

                for (int j = innerSplit.length - 1; j > 0; j--) {
                    op = op + innerSplit[j];
                }

                op = op + " ";

            }
            Log.d("Output", op);

        }
    }

    public void reverse1() {
        int input = 345;
        int output = 0;

        while (input != 0) {

            output = (output * 10) + input % 10;

            input = input / 10;
        }

        Log.d("Output", output + "  output");


    }

    public void count() {
        String input = "abca";
        String split[] = input.split("");

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : split) {
            int count = 0;
            if (hashMap.containsKey(s)) {
                count = hashMap.get(s);
            }
            hashMap.put(s, ++count);
        }

        for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

    }

    public void prime() {
        int input = 17;
        int start = (int) Math.sqrt(17);

        boolean isPrime = true;

        for (int i = 2; i <= input/2; i++) {
            if (input % i == 0) {
                isPrime = false;
                break;
            }
        }

        Log.d("Prime", isPrime + "");
    }
}
