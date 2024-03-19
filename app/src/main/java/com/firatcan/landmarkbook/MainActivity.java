package com.firatcan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.firatcan.landmarkbook.databinding.ActivityDetailsBinding;
import com.firatcan.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<LandMark>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        list=new ArrayList<>();

        LandMark pisa=new LandMark("Pisa","Italy",R.drawable.pisa);
        LandMark effiel=new LandMark("Effiel","France",R.drawable.eiffeltower);
        LandMark londonbridge=new LandMark("London Bridge","England",R.drawable.londonbridge);
        LandMark colleseum=new LandMark("Colleseum","Italy",R.drawable.colosseum);

        list.add(pisa);
        list.add(effiel);
        list.add(londonbridge);
        list.add(colleseum);

        binding.rcycleView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter=new LandmarkAdapter(list);
        binding.rcycleView.setAdapter(landmarkAdapter); //51.satırla aynı işi yapıyor.
        /*
        // BU VERİMSİZ BİR YÖNTEM
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                list.stream().map(landMark ->landMark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(MainActivity.this,list.get(position).name,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("kayıt",list.get(position));
                startActivity(intent);

            }
        });
*/
    }
}