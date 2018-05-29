package com.housing_society.shaonomy.housingsociety1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class AboutUs extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav1_aboutus) {
            // Handle the camera action
        } else if (id == R.id.nav_aboutus_auditdetails) {

        } else if (id == R.id.nav_aboutus_events) {

        } else if (id == R.id.nav_aboutus_features) {

        } else if (id == R.id.nav_aboutus_memberdetails) {

        } else if (id == R.id.nav_aboutus_paymentdetails) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_aboutus);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}