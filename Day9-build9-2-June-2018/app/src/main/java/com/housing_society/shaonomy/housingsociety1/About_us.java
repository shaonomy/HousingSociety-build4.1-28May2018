package com.housing_society.shaonomy.housingsociety1;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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
import android.widget.ViewFlipper;

import java.net.URL;

public class About_us extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent;
    ViewFlipper viewFlipper;
    DownloadManager downloadManager;
    Uri uri;
    String folder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        folder = "Hems_files";
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int images[] = {R.drawable.download, R.drawable.download1, R.drawable.download2,R.drawable.download3};

        viewFlipper = findViewById(R.id.v_flipper);

        for(int image: images){
            flipperimages(image);
        }




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

    public  void flipperimages(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000); //4sec
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left );
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

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
        getMenuInflater().inflate(R.menu.about_us, menu);
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
            case R.id.nav_aboutus_aboutus:
                intent = new Intent(About_us.this, About_us.class);
                startActivity(intent);
                break;
            case R.id.nav_aboutus_auditdetails:
                intent = new Intent(About_us.this, Audit_Details.class);
                startActivity(intent);
                break;

            case R.id.nav_aboutus_memberdetails:
                intent = new Intent(About_us.this, MemberDetails.class);
                startActivity(intent);
                break;

            case R.id.nav_aboutus_features:
                intent = new Intent(About_us.this, FeaturesServices.class);
                startActivity(intent);
                break;

            case R.id.nav_aboutus_paymentdetails:
                intent = new Intent(About_us.this, Payment_Details.class);
                startActivity(intent);
                break;

            case R.id.nav_aboutus_events:
                intent = new Intent(About_us.this, Payment_Details.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Below function is written to download the excel,word,pdf file from the server.
    public void performDownloadAction(View view) {
        Runnable runnable;
        switch (view.getId()) {
            case R.id.pdf:
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        uri = Uri.parse("http://www.shaonomy.com/MySchoolDemo/pdf_file");
                        downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        request.setTitle("Data Download");
                        request.setDescription("Android Data download using DownloadManager.");

                        request.setDestinationInExternalFilesDir(About_us.this, Environment.DIRECTORY_PICTURES.toString(), folder);
                        downloadManager.enqueue(request);
                    }
                };
                new Thread(runnable).start();
                break;
            case R.id.word:
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        uri = Uri.parse("http://www.shaonomy.com/MySchoolDemo/wordFile");
                        downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        request.setTitle("Data Download");
                        request.setDescription("Android Data download using DownloadManager.");
                        request.setDestinationInExternalFilesDir(About_us.this, Environment.DIRECTORY_PICTURES.toString(), folder);
                        downloadManager.enqueue(request);
                    }
                };
                new Thread(runnable).start();
                break;
            case R.id.excel:
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        uri = Uri.parse("http://www.shaonomy.com/MySchoolDemo/excelFile");
                        downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        request.setTitle("Data Download");
                        request.setDescription("Android Data download using DownloadManager.");
                        downloadManager.enqueue(request);
                    }
                };
                new Thread(runnable).start();
                break;

        }
    }
}
