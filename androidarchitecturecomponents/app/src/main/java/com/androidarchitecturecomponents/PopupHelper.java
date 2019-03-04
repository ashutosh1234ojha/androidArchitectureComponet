package com.androidarchitecturecomponents;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.PopupMenu;

/**
 * Created by Ashutosh Ojha on 3/4/19.
 */
public class PopupHelper extends PopupMenu {
    public PopupHelper(final Context context, final View anchor) {
        super(context, anchor);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public PopupHelper(final Context context, final View anchor, final int gravity) {
        super(context, anchor, gravity);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public PopupHelper(final Context context, final View anchor, final int gravity, final int popupStyleAttr, final int popupStyleRes) {
        super(context, anchor, gravity, popupStyleAttr, popupStyleRes);
    }

    @Override
    public void setGravity(final int gravity) {
        super.setGravity(gravity);

    }


}
