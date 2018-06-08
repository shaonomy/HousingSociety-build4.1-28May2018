package com.housing_society.shaonomy.housingsociety1;

import android.app.ProgressDialog;
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
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Payment_Details extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent;
    TextView monthdetails;
    TextView status;
    private RequestQueue mqueue;
    private ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mqueue = Volley.newRequestQueue(this);
        pd = new ProgressDialog(Payment_Details.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);
        monthdetails = (TextView) findViewById(R.id.monthdetails);
        status = (TextView) findViewById(R.id.status);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        jsonParse();
        jsonParse1();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void jsonParse(){
        //number = phone.getText().toString().trim();
        String url = "http://192.168.1.56/otp/read.php?phone=917719096717";
        pd.show();
        //String url = "https://api.myjson.com/bins/17acji";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pd.hide();

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject data = jsonArray.getJSONObject(i);

                                String username = data.getString("username");
                                String  passwd = data.getString("passwd");
                                String phone = data.getString("phone");

                                monthdetails.append("Event Charges:" + "  " + username + "\n\n" + "Lify Charges:" + "  "  + passwd + "\n\n" + "Security Charges:" + "  " + phone + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


        mqueue.add(request);
    }

    private void jsonParse1(){
        //number = phone.getText().toString().trim();
        String url = "http://192.168.1.56/otp/read.php?phone=917719096717";
        pd.show();
        //String url = "https://api.myjson.com/bins/17acji";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pd.hide();

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject data = jsonArray.getJSONObject(i);

                                String username = data.getString("username");
                                String  passwd = data.getString("passwd");
                                String phone = data.getString("phone");

                                status.append("status:" + "  " + username + "\n\n" + "Total Maintence:(A+B+C+D+E+F)" + "\n  " + phone + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


        mqueue.add(request);
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
        getMenuInflater().inflate(R.menu.payment__details, menu);
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
            case R.id.nav_paymentdetails_aboutus:
                intent = new Intent(Payment_Details.this, About_us.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.nav_paymentdetails_auditdetails:
                intent = new Intent(Payment_Details.this, Audit_Details.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.nav_paymentdetails_memberdetails:
                intent = new Intent(Payment_Details.this, MemberDetails.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.nav_paymentdetails_features:
                intent = new Intent(Payment_Details.this, FeaturesServices.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.nav_paymentdetails_paymentdetails:
                intent = new Intent(Payment_Details.this, Payment_Details.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.nav_paymentdetails_events:
                intent = new Intent(Payment_Details.this, Events.class);
                startActivity(intent);
                this.finish();
                break;


        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
