package com.androidarchitecturecomponents.rx;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androidarchitecturecomponents.R;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by Ashutosh Ojha on 1/2/19.
 */
public class RxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.btnProgressBar).setOnClickListener((v) -> {
            subjects();

            flowable();
        });

        Observable<Integer> observable = new Observable<Integer>() {
            @Override
            protected void subscribeActual(final Observer<? super Integer> observer) {

            }
        };


    }

    private void flowable() {

        //Flowable from observable
        Observable<Integer> observable = Observable.range(1, 2000000000);
        Flowable<Integer> flowable = observable.toFlowable(BackpressureStrategy.BUFFER);
    }

    @SuppressLint("CheckResult")
    private void subjects() {

        PublishSubject<String> publishSubject = PublishSubject.create();


        publishSubject.onNext("a");

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(final Disposable d) {
                Log.d("Tag", "onSubscribe");

            }

            @Override
            public void onNext(final String s) {

                Log.d("Tag", s);
            }

            @Override
            public void onError(final Throwable e) {
                Log.d("Tag", "onError");

            }

            @Override
            public void onComplete() {
                Log.d("Tag", "ONCOMPLETE");

            }
        };


        publishSubject.subscribe(observer);
        publishSubject.onNext("a");

        Observable<String> observable = Observable.just("hot", "warm", "cold")
                .subscribeOn(Schedulers.computation())
                .map(i -> {
                    return i + " climate";
                });

        BehaviorSubject<String> bSubject = BehaviorSubject.create();
        observable.subscribe(bSubject);


    }
}

