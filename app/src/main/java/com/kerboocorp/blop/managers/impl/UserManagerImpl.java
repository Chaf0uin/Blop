package com.kerboocorp.blop.managers.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.kerboocorp.blop.R;
import com.kerboocorp.blop.managers.UserManager;
import com.kerboocorp.blop.model.User;

/**
 * Created by cgo on 6/01/2015.
 */
public class UserManagerImpl implements UserManager {

    private static String TAG_ID = "ID";
    private static String TAG_USERNAME = "USERNAME";
    private static String TAG_EMAIL = "EMAIL";
    private static String TAG_IS_CONNECTED = "IS_CONNECTED";

    private Context context;

    public UserManagerImpl(Context context) {
        this.context = context;
    }


    @Override
    public boolean isUserConnected() {
        SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
        return preferences.getBoolean(TAG_IS_CONNECTED, false);
    }

    @Override
    public User findUser() {
        SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
        if (preferences.getBoolean(TAG_IS_CONNECTED, false)) {
            User user = new User();
            user.setId(preferences.getLong(TAG_ID, -1));
            user.setUsername(preferences.getString(TAG_USERNAME, ""));
            user.setEmail(preferences.getString(TAG_EMAIL, ""));
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void saveUser(User user) {
        SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putLong(TAG_ID, user.getId());
        editor.putString(TAG_USERNAME, user.getUsername());
        editor.putString(TAG_EMAIL, user.getEmail());
        editor.putBoolean(TAG_IS_CONNECTED, true);
        editor.commit();
    }

    @Override
    public void deleteUser() {
        SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}
