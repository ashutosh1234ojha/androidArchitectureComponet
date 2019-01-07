package com.androidarchitecturecomponents.question;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ashutosh Ojha on 12/31/18.
 * N==2
 * 2211
 * 21
 * <p>
 * <p>
 * N=3
 * 333222111
 * 332211
 * 321
 */
public class Practice {


//    void permutate(String input) {
//        HashSet<StringBuilder> hashSet = new HashSet<>();
//
//
//        for (int i = 0; i < input.length() - 1; i++) {
//            for (int j = 0; j < input.length() - 1; j++) {
//
//                StringBuilder stringBuilder = new StringBuilder(input);
//                stringBuilder.setCharAt(j, input.charAt(i));
//
//                hashSet.add(stringBuilder);
//            }
//        }
//
//        for (StringBuilder s : hashSet) {
//            System.out.println(s);
//        }
//
//    }

    void permutate(String input, final int l, final int r) {

        if (l == r) {
            Log.d("TAG", input);
        } else {
            for (int i = l; i <= r; i++) {
                input = swap(input, l, i);
                permutate(input, l + 1, r);
                input = swap(input, l, i);
            }
        }


    }

    private String swap(final String input, final int l, final int r) {
        char[] charArray = input.toCharArray();
        char temp = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = temp;

        return String.valueOf(charArray);

    }

    public void pattern(int n) {

//        int inner = n;
////        for (int i = n; i > 0; i--) {
////
////            for (int j = 0; j < i * inner; j++) {
////
////                if()
////                System.out.print(""+n);
////            }
////
////            inner--;
////
////
////        }

        System.out.println("//////////////////////////");


        for (int k = 0; k < n; k++) {
            for (int i = n; i > 0; i--) {
                for (int j = 0; j < n - k; j++) {
                    System.out.println(i);
                }
            }
        }

        System.out.println("//////////////////////////");


    }

    /**
     * @param n 1
     *          11
     *          111
     *          1111
     *          11111
     */
    public void triangle(int n) {

        for (int i = n; i >= 1; i--) {

            for (int j = 1; j <= n; j++) {

                if (i <= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");

                }
            }
            System.out.println();

        }
    }

    /**
     * 15,3=18
     * <p>
     * 19, 4=20
     * <p>
     * 20, 6=18
     */


    public void highestMultiple(int n, int d) {

        int r = n % d;
        int q = n / d;
        int next, pre;

        if (r != 0) {
            next = n + (d - r);
            pre = d * q;

            int next_n = next - n, n_next = n - pre;

            if ((n_next == next_n) || next_n < n_next) {
                Log.d("TAG", "nearest to " + n + " " + next);

            } else {
                Log.d("TAG", "nearest to " + n + " " + pre);
            }

        }
    }

    /**
     * @param input "this is my name"
     *              output "[This , This is , This is my , This is my name , is , is my , is my name , my , my name , name ]"
     */
    public void forwordConsequitivePermutation(String input) {
        if (input != null) {

            ArrayList<StringBuilder> outputList = new ArrayList<>();
            String[] inputArray = input.split(" ");


            for (int i = 0; i < inputArray.length; i++) {


                for (int j = i; j < inputArray.length; j++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int k = i; k <= j; k++) {

                        stringBuilder.append(inputArray[k]);
                        stringBuilder.append(" ");
                    }

                    outputList.add(stringBuilder);
                }
            }


            Log.d("Tag", outputList.toString());

        }
    }
}
