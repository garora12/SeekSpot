package utils;

import android.util.Log;

/**
 * Created by dhimanabhishek2525 on 4/4/2016.
 */
public class Logger {
    private static boolean debug;

    public static void log(String msg) {
        if (debug)
            System.out.println(msg);
    }

    public static void log(String tag, String msg) {
        if (debug)
            Log.d(tag == null ? "null" : tag, msg == null ? "null" : msg);
    }

    public static void log(Exception e) {
        if (debug && e != null)
            e.printStackTrace();
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        Logger.debug = debug;
    }
}