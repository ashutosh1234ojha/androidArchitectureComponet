package com.androidarchitecturecomponents.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.androidarchitecturecomponents.R;

/**
 * Created by Ashutosh Ojha on 3/1/19.
 */
public class MyCustomView extends View {
    private Paint mPaint;
    private Rect mRect;
    private int sqColor;
    private int mPadding;

    public MyCustomView(final Context context) {
        super(context);
        init(null);

    }

    public MyCustomView(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public MyCustomView(final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyCustomView(final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);

    }

    void init(AttributeSet attributeSet) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRect = new Rect();


        if (attributeSet == null) {
            return;
        }

        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.MyCustomView);
        sqColor = typedArray.getColor(R.styleable.MyCustomView_square_color, Color.GRAY);
        mPaint.setColor(sqColor);
        typedArray.recycle();
        ;

    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        mRect.left = 0+mPadding;
        mRect.top = 0+mPadding;
        mRect.right = getWidth()-mPadding;
        mRect.bottom = getHeight()-mPadding;

        canvas.drawRect(mRect, mPaint);
    }

    void customPaddingUp(int padding) {
        mPadding = mPadding + padding;
        postInvalidate();


    }

    void customPaddingDown(int padding) {
        mPadding = mPadding - padding;
        postInvalidate();

    }

    void changeColor() {

        sqColor = Color.RED;
        mPaint.setColor(Color.RED);
        postInvalidate();
    }
}
