package com.androidarchitecturecomponents.question;

import android.util.Log;

/**
 * Created by Ashutosh Ojha on 12/31/18.
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

        if (l==r) {
            Log.d("TAG", input);
        }else {
            for(int i=l;i<=r;i++){
                input = swap(input, l, i);
                permutate(input, l+1, r);
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

}
