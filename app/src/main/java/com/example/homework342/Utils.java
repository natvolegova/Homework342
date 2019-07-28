package com.example.homework342;

import android.app.Activity;
import android.content.Intent;

public class Utils
{
    private static int sTheme;

    public final static int THEME_SMALL = 2;
    public final static int THEME_DEFAULT = 1;
    public final static int THEME_BIG = 0;

    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.Margin_medium);
                break;
            case THEME_SMALL:
                activity.setTheme(R.style.Margin_small);
                break;
            case THEME_BIG:
                activity.setTheme(R.style.Margin_big);
                break;
        }
    }
}