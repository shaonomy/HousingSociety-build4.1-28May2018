package com.housing_society.shaonomy.housingsociety1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class paymentdetails extends  AppCompatActivity {
    TextView result;
    EditText phone;
    Button search;
    String number;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_payment__details);
        search = (Button)findViewById(R.id.button);
        result = (TextView)findViewById(R.id.textView);
        phone = (EditText)findViewById(R.id.phone);
        pd = new ProgressDialog(paymentdetails.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = phone.getText().toString().trim();

                getSqlDetails();
            }
        });


    }

    private void getSqlDetails() {

        String url= "http://192.168.1.57/OTP/read.php?phone="+number;
        pd.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        pd.hide();


                        try {

                            JSONArray jsonarray = new JSONArray(response);

                            for(int i=0; i < jsonarray.length(); i++) {

                                JSONObject jsonobject = jsonarray.getJSONObject(i);


                                //String id = jsonobject.getString("id");
                                String passwd = jsonobject.getString("passwd");
                                String username = jsonobject.getString("username");
                                String phone = jsonobject.getString("phone");

                                result.setText(" Passwd -"+passwd+"\n username -"+username+"\n Phone -"+phone);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();


                        }




                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(error != null){

                            Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                        }
                    }
                }

        );

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

}


