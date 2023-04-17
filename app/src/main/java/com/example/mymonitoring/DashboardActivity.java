package com.example.mymonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    LinearLayout layoutOne, layoutTwo, layoutThree, layoutFour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        ImageSlider imageSlider = findViewById(R.id.image_slider);

        layoutOne = findViewById(R.id.LayoutOne);
        layoutTwo = findViewById(R.id.LayoutTwo);
        layoutThree = findViewById(R.id.LayoutThree);
        layoutFour = findViewById(R.id.LayoutFour);

        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.banner, null));
        imageList.add(new SlideModel(R.drawable.banner, null));
        imageSlider.setImageList(imageList, ScaleTypes.FIT);


        layoutOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, UploadLaporanActivity.class));
                Toast.makeText(getApplicationContext(),"Satu", Toast.LENGTH_LONG).show();
            }
        });

        layoutTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
                //Toast.makeText(getApplicationContext(),"Dua", Toast.LENGTH_LONG).show();
            }
        });

        layoutThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Tiga", Toast.LENGTH_LONG).show();
            }
        });

        layoutFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Empat", Toast.LENGTH_LONG).show();
            }
        });



    }
}