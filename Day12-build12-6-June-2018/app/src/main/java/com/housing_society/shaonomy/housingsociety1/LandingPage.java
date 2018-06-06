package com.housing_society.shaonomy.housingsociety1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class LandingPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id) {
            case R.id.nav1_aboutus:
            intent= new Intent(LandingPage.this,About_us.class);
            startActivity(intent);
            break;
            case R.id.nav1_auditdetails:
            intent= new Intent(LandingPage.this,Audit_Details.class);
            startActivity(intent);
            break;

            case R.id.nav1_memberdetails:
            intent= new Intent(LandingPage.this,MemberDetails.class);
            startActivity(intent);
            break;

            case R.id.nav1_features:
            intent= new Intent(LandingPage.this,FeaturesServices.class);
            startActivity(intent);
            break;


            case R.id.nav1_paymentdetails:
                intent= new Intent(LandingPage.this,Payment_Details.class);
                startActivity(intent);
                break;

            case R.id.nav1_events:
                intent = new Intent(LandingPage.this, Events.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;



    }


    public void performAction(View view)
    {
        switch (view.getId())
        {

            case R.id.landingpage_aboutus:
                intent= new Intent(LandingPage.this,About_us.class);
                startActivity(intent);

                break;

            case R.id.landingpage_paymentdeatils:
                intent= new Intent(LandingPage.this,Payment_Details.class);
                startActivity(intent);
                break;
            case R.id.landingpage_auditdetails:
                intent= new Intent(LandingPage.this,Audit_Details.class);
                startActivity(intent);
                break;

             case R.id.landingpage_memberdetails:
                intent= new Intent(LandingPage.this,MemberDetails.class);
                startActivity(intent);
                break;

             case R.id.landingpage_features:
                intent= new Intent(LandingPage.this,FeaturesServices.class);
                startActivity(intent);
                break;


            case R.id.landingpage_events:
                intent= new Intent(LandingPage.this,Events.class);
                startActivity(intent);
                break;

        }


    }
}
