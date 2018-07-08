package com.example.maximus.droneme;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SettingsFragment.OnFragmentInteractionListener, TransportFragment.OnFragmentInteractionListener, PhotoFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener, NavigationFragment.OnFragmentInteractionListener, MessageFragment.OnFragmentInteractionListener, View.OnClickListener {

    Fragment transportFragment = new TransportFragment();
    Fragment homeFragment = new HomeFragment();
    Fragment navigationFragment = new NavigationFragment();
    Fragment photoFragment = new PhotoFragment();
    Fragment settingsFragment = new SettingsFragment();
    Fragment messageFragment = new MessageFragment();

    private TextView mTextMessage;
    private ImageButton messageButton;
    private ImageButton naviButton;

    //Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_photo:
                    replaceFragment(photoFragment);
                    return true;
                case R.id.navigation_package:
                    replaceFragment(transportFragment);
                    return true;
                case R.id.navigation_home:
                    replaceFragment(homeFragment);
                    return true;
                case R.id.navigation_navigation:
                    replaceFragment(navigationFragment);
                    return true;
                case R.id.navigation_settings:
                    replaceFragment(settingsFragment);
                    return true;
            }
            return false;
        }
    };

    public void onClick(View view){
        switch(view.getId()){
            case(R.id.toolbar_button):
                replaceFragment(navigationFragment);
                break;
            case(R.id.toolbar_button2):
                replaceFragment(messageFragment);
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        setTitle("Home");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_navigation);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.top_nav_layout);

        naviButton = findViewById(R.id.toolbar_button);
        naviButton.setOnClickListener(this);

        messageButton = findViewById(R.id.toolbar_button2);
        messageButton.setOnClickListener(this);

        // initialize fragment view
        if (getSupportFragmentManager().findFragmentByTag("home_fragment_tag") == null) {
            System.out.println("Entered if");
            if (savedInstanceState != null) {
                System.out.println("There is a saved state. Returning!");
                return;
            }
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
