package com.androidarchitecturecomponents.designpattern;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by Ashutosh Ojha on 3/26/19.
 */
public class FactoryMethod  implements Comparable<FactoryMethod > {

    private  int age;

  public   static void method(){
        int a[]={5,4,3,2,1};
        int l=a.length;
        Log.d("Array before", Arrays.toString(a));

        for(int i=0;i<l;i++){

            for(int j=i;j<l;j++){

                if(a[j]<a[i]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
//                    break;
                }
            }
        }

        Log.d("Array", Arrays.toString(a));
    }



    public static void method1(){
        int a[]={5,4,3,2,1};
        int l=a.length;
        Log.d("Array before", Arrays.toString(a));

       for(int i=0;i<l;i++){

           for(int j=i;j<l;j++){
               if(a[j]<a[i]){
               }

           }

       }

        HashSet<Integer> hashSet=new HashSet<>();
        TreeSet<Integer> treeSet=new TreeSet<>();

        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(2);

        HashMap<Integer,Integer> hashMap=new HashMap<>();
//        Hashtable<Integer,Integer> hashSet1=new HashSet<>();
    }

    @Override
    public int compareTo(@NonNull final FactoryMethod o) {
      if(this.age<o.age)
        return -1;
      else return 0;
    }

   public static Comparator<FactoryMethod> age1=new Comparator<FactoryMethod>() {
       @Override
       public int compare(final FactoryMethod o1, final FactoryMethod o2) {
           return 0;
       }
   };

    /**
     * i=0  a[i]=5
     * j=0
     * [5,4,3,2,1]
     *j=1
     * [4,5,3,2,1]
     *j=2
     *  [3,5,4,2,1]
     *
     *  j=3
     *  [2,5,4,3,1]
     *
     *  j=4
     *  [1,5,4,3,2]
     */



}
