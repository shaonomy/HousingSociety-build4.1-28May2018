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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class paymentdetails extends  AppCompatActivity {
    TextView result;
    EditText phone;
    Button search;
    String number;
    private RequestQueue mqueue;
   // private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_payment__details);
        result = findViewById(R.id.result);
        Button search = findViewById(R.id.search);
        mqueue = Volley.newRequestQueue(this);

        //number = phone.getText().toString().trim();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //number = phone.getText().toString().trim();
                jsonParse();
            }
        });
    }


    private void jsonParse(){
        String url = "https://api.myjson.com/bins/9axby";
        //String url = "https://api.myjson.com/bins/17acji";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject data = jsonArray.getJSONObject(i);

                                String username = data.getString("username");
                                String  passwd = data.getString("passwd");
                                String phone = data.getString("phone");

                                result.append(username + ", " + passwd + ", " + phone + "\n\n");
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

}
//                    @Override
//                    public void onResponse(String response) {
//
//                        pd.hide();
//
//
//                        try {
//
//                            JSONArray jsonarray = new JSONArray(response);
//
//                            for(int i=0; i < jsonarray.length(); i++) {
//
//                                JSONObject jsonobject = jsonarray.getJSONObject(i);
//
//
//                                //String id = jsonobject.getString("id");
//                                String passwd = jsonobject.getString("passwd");
//                                String username = jsonobject.getString("username");
//                                String phone = jsonobject.getString("phone");
//
//                                result.setText(" Passwd -"+passwd+"\n username -"+username+"\n Phone -"+phone);
//
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//
//
//                        }
//
//
//
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        if(error != null){
//
//                            Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//
//        );
//
//        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
//    }
//
//}


