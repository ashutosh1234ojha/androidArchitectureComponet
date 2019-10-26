package com.androidarchitecturecomponents;

/**
 * Created by Ashutosh Ojha on 1/28/19.
 */
public class Child extends Parent {
    @Override
    public String name() {
        return "rahul";
    }


   public static void rotate() {

        int[] input ={7, 9, 11, 12, 5};
//        int[] input = {15, 18, 2, 3, 6, 12};
        int left = input[0], right = input[input.length - 1];
        int i = 0, j = input.length - 1;
        int count = 0;

        while (left > right) {
            i++;
            j--;

            left = input[i];
            right = input[j];
            count++;
        }

        System.out.println("Rotation count" + count);

    }


}
