package com.daniel.datownik;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.widget.EditText;

/**
 * Created by Daniel on 27.02.2017.
 */

public class App extends Application {

    public static App getInstance() {
        return instance;
    }

    public static void setInstance(App instance) {
        App.instance = instance;
    }

    public static Context getContext() {
        return instance;
    }

    private static App instance;
    public static volatile Handler applicationHandler = null;

    public boolean editTextIsEmpty(EditText editText) {
        if (editText.getText().equals("")) {
            return true;
        } else
            return false;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
        applicationHandler = new Handler(getInstance().getMainLooper());


    }
}
