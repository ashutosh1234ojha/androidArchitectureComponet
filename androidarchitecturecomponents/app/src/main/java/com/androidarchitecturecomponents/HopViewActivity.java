package com.androidarchitecturecomponents;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;

import com.androidarchitecturecomponents.designpattern.FactoryMethod;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Ashutosh Ojha on 1/22/19.
 */
public class HopViewActivity extends AppCompatActivity {

    private Button btnHop;
    private TextView tvMsg;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_view);

        btnHop = findViewById(R.id.btnHop);
        tvMsg = findViewById(R.id.tvMsg);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                animationFunction();
            }
        };

        handler.post(runnable);

        int[] iput = {1, 2, 3, 4, 5};

        int [] ads={2, 1, 5, 3, 4};
        minimumBribes(ads);

//        btnHop.setOnClickListener(v -> rotLeft(iput, 2));
        btnHop.setOnClickListener(v -> minimumBribes(ads));
//        btnHop.setOnClickListener(view -> animationFunction());


        checkOperator();

        FactoryMethod factoryMethod = new FactoryMethod();
        boolean a = factoryMethod.equals(new FactoryMethod());
        factoryMethod.getClass();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("", new FactoryMethod());




    }


    static void minimumBribes(int[] q) {
        int count=0;
        boolean check=true;
        for(int i=0;i<q.length;i++){
            int diff=q[i]-(i+1);
            if(diff>2){
                check=false;

                break;

            }else if(diff>0){
                count =count+diff;

            }


        }

        if(check)
        {
            System.out.print("MyCount"+count);


        }else{
            System.out.print("Too chaotic");

        }


    }


    // Complete the rotLeft function below.
    void rotLeft(int[] a, int d) {

        int count = d;

        System.out.println(Arrays.toString(a));


        while (count != 0) {
            int temp = a[0];
            for (int i = 0; i < a.length-1; i++) {
                a[i] = a[i+1];

            }

            a[a.length - 1] = temp;

            count--;
        }


        System.out.println("Array   "+Arrays.toString(a));

    }

    /**
     * operator +,-,*
     * String 123  target  6
     * o/p== 1+2+3 ,2*3
     * <p>
     * String 123  target  =7
     * o/p==2*3+1
     */
    private void checkOperator() {
//        String input="123";
//        String[] inputArray=input.split("");
//        Stack<String> stack=new Stack<String>();
//        stack.push("");
//
//
//        stack.pop();


    }

    private void animationFunction() {

        ViewPropertyAnimator viewPropertyAnimator = tvMsg.animate().translationYBy(-40f).setDuration(200).withEndAction(() -> {
            tvMsg.animate().translationYBy(40f).setDuration(200);

            handler.postDelayed(runnable, 100);

        });

    }
}
