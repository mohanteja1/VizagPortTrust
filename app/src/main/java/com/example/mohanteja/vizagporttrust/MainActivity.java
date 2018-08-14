package com.example.mohanteja.vizagporttrust;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String PREF_NAME = "LoginDetails";
    private static final String KEY_USERNAME = "username";

    private static final String TAG = "MainActivity";
    SharedPreferences userLogin;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //nav bar
        mDrawerLayout = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        try {
            userLogin = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            menu.findItem(R.id.nav_user).setTitle("user :" +userLogin.getString(KEY_USERNAME, ""));

            // Log.d(TAG, "onCreate: "+ userLogin.getString(KEY_USERNAME, " nothing here "));
        } catch (Exception e) {
            Log.e(TAG, "onCreate: " + e.toString());
        }



        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();
                        int id = menuItem.getItemId();
                        // Add code here to update the UI based on the item selected
                        Intent intent;
                        switch (id) {

                            case R.id.nav_user:
                                intent = new Intent(getApplicationContext(), UserDetailActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_login:
                                intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_settings:
                                intent = new Intent(getApplicationContext(), SettingsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_help:
                                intent = new Intent(getApplicationContext(), HelpActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_feedback:
                                intent = new Intent(getApplicationContext(), FeedBackActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_about:
                                intent = new Intent(getApplicationContext(), About.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_exit:
                                finish();
                                System.exit(0);
                                break;

                        }


                        // For example, swap UI fragments here

                        return true;
                    }
                });


        Button btnElectronics = (Button) findViewById(R.id.btnElectronics);
        Button btnCranes = (Button) findViewById(R.id.btnCranes);
        Button btnFloatingCraftSection = (Button) findViewById(R.id.btnFloatingCraftsSection);
        Button btnBGLocos = (Button) findViewById(R.id.btnBGLocos);
        Button btnPowerDistribution = (Button) findViewById(R.id.btnPowerDistribution);
        Button btnPumpHouse = (Button) findViewById(R.id.btnPumpHouse);
        Button btnLighting = (Button) findViewById(R.id.btnlighting);


        btnElectronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ElectronicsActivity.class);
                startActivity(intent);
            }
        });

        btnBGLocos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BGLocosActivity.class);
                startActivity(intent);

            }
        });

        btnCranes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CraneActivity.class);
                startActivity(intent);
            }
        });

        btnFloatingCraftSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FCSActivity.class);
                startActivity(intent);

            }
        });

        btnLighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LightingActivity.class);
                startActivity(intent);

            }
        });

        btnPowerDistribution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PowerHouseActivity.class);
                startActivity(intent);

            }
        });

        btnPumpHouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PumpHouseActivity.class);
                startActivity(intent);
            }
        });

    }


}