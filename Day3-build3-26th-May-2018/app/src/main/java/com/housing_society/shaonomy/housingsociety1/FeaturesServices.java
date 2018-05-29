package com.housing_society.shaonomy.housingsociety1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FeaturesServices extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features_services);*/
    private LinearLayout outerLinearLayout;
    private TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features_services);
        outerLinearLayout = (LinearLayout) findViewById(R.id.outerLinearLayout);
        text1 = (TextView) findViewById(R.id.text1);

        LinearLayout innerLinearLayout = new LinearLayout(this);

        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.bottomMargin=12;
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.ic_launcher_background);
        innerLinearLayout.addView(imageView);
        TextView textView = new TextView(this);
        textView.setTextSize((float) 24.5);
        textView.setText("New Text View");
        textView.setLayoutParams(params);
        outerLinearLayout.removeAllViews();
        innerLinearLayout.addView(text1);
        outerLinearLayout.addView(textView);
        outerLinearLayout.addView(innerLinearLayout);
    }
}
