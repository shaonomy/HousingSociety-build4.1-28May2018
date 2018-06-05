package com.housing_society.shaonomy.housingsociety1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.util.Calendar.*;

public class Gallery_Events extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent;
    Button history, submit;
    //Dialog dialog;
    //final Context context = this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery__events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        history = (Button)findViewById(R.id.History);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Gallery_Events.this, History.class);
                startActivity(intent);
            }
        });

//        history.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final Dialog dialog = new Dialog(context);
//                dialog.setContentView(R.layout.dailog_box);
//                dialog.setTitle("History....");
//                Button Submit = (Button) dialog.findViewById(R.id.btnSubmit);
//
//                Submit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                        intent = new Intent(Gallery_Events.this, History.class);
//                        startActivity(intent);
//                    }
//                });
//
//
//
//                dialog.show();
//
//            }
//        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gallery__events, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_gallery_aboutus:
                intent = new Intent(Gallery_Events.this, About_us.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.nav_gallery_auditdetails:
                intent = new Intent(Gallery_Events.this, Audit_Details.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.nav_gallery_memberdetails:
                intent = new Intent(Gallery_Events.this, MemberDetails.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.nav_gallery_features:
                intent = new Intent(Gallery_Events.this, FeaturesServices.class);
                startActivity(intent);
                this.finish();
                break;


            case R.id.nav_gallerys_paymentdetails:
                intent = new Intent(Gallery_Events.this, Payment_Details.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.nav_gallery_events:
                intent = new Intent(Gallery_Events.this, Events.class);
                startActivity(intent);
                this.finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
