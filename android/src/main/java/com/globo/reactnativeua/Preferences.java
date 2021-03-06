package com.globo.reactnativeua;

import android.content.Context;
import android.content.SharedPreferences;

import com.urbanairship.UAirship;

public class Preferences {

    private final String PREFS_NODE = "preferences";
    private final String PREFS_ANDROID_SMALL_ICON = "prefs_android_small_icon";
    private final String PREFS_ANDROID_LARGE_ICON = "prefs_android_large_icon";
    private static Preferences instance;
    private SharedPreferences preferences;

    public static Preferences getInstance() {
        if (instance == null) {
            instance = new Preferences();
        }
        return instance;
    }

    private Preferences() {
        preferences = UAirship.getApplicationContext().getSharedPreferences(
                PREFS_NODE, Context.MODE_PRIVATE);
    }

    public int getAndroidSmallIconResourceId() {
        return preferences.getInt(PREFS_ANDROID_SMALL_ICON, 0);
    }

    public void setAndroidSmallIconResourceId(int iconResourceId) {
        preferences.edit()
                .putInt(PREFS_ANDROID_SMALL_ICON, iconResourceId)
                .apply();
    }

    public int getAndroidLargeIconResourceId() {
        return preferences.getInt(PREFS_ANDROID_LARGE_ICON, 0);
    }

    public void setAndroidLargeIconResourceId(int iconResourceId) {
        preferences.edit()
                .putInt(PREFS_ANDROID_LARGE_ICON, iconResourceId)
                .apply();
    }

}
