package com.firatcan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firatcan.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Vİew Binding setContentView ın R.Layout.activity_details'in yerine gelir
        //setContentView(R.layout.activity_details);

        binding =ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent=getIntent();
        //casting diyorum bu yönteme.Bir şeyi başka bir şeye dönüştürme
        LandMark selectedLandmark=(LandMark) intent.getSerializableExtra("kayıt");
        binding.nameText.setText(selectedLandmark.name);
        binding.countryText.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);


    }

}