package com.androidarchitecturecomponents.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidarchitecturecomponents.R;

public class FragmentB extends Fragment {

    public static final String TAG1 = "ABC123";
    public static final String TAG = "FragmentB";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG1, "onCreateView" + TAG);

//        View view = inflater.inflate(R.layout.fragment_backstack, container, false);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_backstack, container, false);


        ((TextView) view.findViewById(R.id.tvLabel)).setText("Fragment b");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG1, "onActivityCreated" + TAG);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG1, "onAttach" + TAG);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG1, "onCreate" + TAG);

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG1, "onStart" + TAG);

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG1, "onResume" + TAG);

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG1, "onPause" + TAG);

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG1, "onStop" + TAG);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG1, "onDestroyView" + TAG);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG1, "onDestroy" + TAG);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG1, "onDetach" + TAG);

    }
}
