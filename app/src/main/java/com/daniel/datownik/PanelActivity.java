package com.daniel.datownik;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class PanelActivity extends FragmentActivity implements MainPanelFragment.MainPanelFragmentListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);
    }

    @Override
    public void onItemSelected(String msg) {

    }
}
