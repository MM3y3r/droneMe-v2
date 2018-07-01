package com.example.maximus.droneme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TransportFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    //Intent intent = new Intent(getApplicationContext(), MapsActivity.class);

    @Override
    public void onFragmentInteraction(Uri uri) {
        //
    }

    public void replaceFragment(View view) {
        NavigationFragment blankFragment2 = new NavigationFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,blankFragment2).addToBackStack(null).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_photo:
                    mTextMessage.setText(R.string.title_photo);
                    return true;
                case R.id.navigation_package:
                    mTextMessage.setText(R.string.title_package);
                    return true;
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_navigation:
                    mTextMessage.setText(R.string.title_navigation);
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText(R.string.title_settings);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        setTitle("Home");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_navigation);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.top_nav_layout);

        // initialize fragment view
        if (findViewById(R.id.fragment_container) != null) {
            System.out.println("Entered if");
            if (savedInstanceState != null) {
                System.out.println("There is a saved state. Returning!");
                return;
            }
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment).commit();
        }
        System.out.println("can we print tho");
        System.out.println(R.id.fragment_container);


        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.getMenu().getItem(2).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
