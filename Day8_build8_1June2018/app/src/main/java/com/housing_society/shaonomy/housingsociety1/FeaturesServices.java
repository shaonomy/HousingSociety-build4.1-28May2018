package com.housing_society.shaonomy.housingsociety1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FeaturesServices extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private LinearLayout outerLinearLayout;
    private TextView text1,card_text;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features_services);
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
        card_text = (TextView) findViewById(R.id.info_text);
        card_text.setText("HELLO");
        /*outerLinearLayout = (LinearLayout) findViewById(R.id.outerLinearLayout);
        text1 = (TextView) findViewById(R.id.text1);

        LinearLayout innerLinearLayout = new LinearLayout(this);

        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.bottomMargin=12;
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.ic_menu_send);
        innerLinearLayout.addView(imageView);
        TextView textView = new TextView(this);
        textView.setTextSize((float) 24.5);
        textView.setText("New Text View");
        textView.setLayoutParams(params);
        outerLinearLayout.removeAllViews();
        innerLinearLayout.addView(text1);
        outerLinearLayout.addView(textView);
        outerLinearLayout.addView(innerLinearLayout);*/

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
        getMenuInflater().inflate(R.menu.features_services, menu);
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
        switch(id) {
            case R.id.nav1_aboutus:
                intent= new Intent(FeaturesServices.this,About_us.class);
                startActivity(intent);
                break;
            case R.id.nav1_auditdetails:
                intent= new Intent(FeaturesServices.this,Audit_Details.class);
                startActivity(intent);
                break;

            case R.id.nav1_memberdetails:
                intent= new Intent(FeaturesServices.this,MemberDetails.class);
                startActivity(intent);
                break;

            case R.id.nav1_features:
                intent= new Intent(FeaturesServices.this,FeaturesServices.class);
                startActivity(intent);
                break;


            case R.id.nav1_paymentdetails:
                intent= new Intent(FeaturesServices.this,Payment_Details.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
