package com.th.mvpstaff;

import android.os.Handler;
import android.os.Looper;

public class Util {
    private static Handler handler;

    public static Handler getHandler() {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        return handler;
    }

    public static void post(Runnable runnable) {
        getHandler().post(runnable);
    }

    public static void postDelay(Runnable runnable, long delay) {
        getHandler().postDelayed(runnable, delay);
    }
}
