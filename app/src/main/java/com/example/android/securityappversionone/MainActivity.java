package com.example.android.securityappversionone;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.container);

        if(fragment == null){
            fragment = new FragmentSystemsOptions();
            manager.beginTransaction().add(R.id.container,fragment).commit();
        }
    }


}
