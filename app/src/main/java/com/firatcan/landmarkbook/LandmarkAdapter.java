package com.firatcan.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firatcan.landmarkbook.databinding.RcyclerRowBinding;

import java.util.ArrayList;

//<vh> görünüm tutucu
public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.Landmarkholder> {

    ArrayList<LandMark> landMarkArrayList;
    public LandmarkAdapter(ArrayList<LandMark> landMarkArrayList) {
        this.landMarkArrayList = landMarkArrayList;
    }


    @NonNull

    //Bindingimiz board'a baglayacagız yani XML imizi burda bağlarız.
    @Override
    public Landmarkholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RcyclerRowBinding rcyclerRowBinding=RcyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Landmarkholder(rcyclerRowBinding);
    }

    //ViewHolder'a bağlandığınıda ne olacağını söyler kısacası layout umda hangi görüntüyü göstermek istersem burda gösteririm.değerimi vericem
    @Override
    public void onBindViewHolder(@NonNull LandmarkAdapter.Landmarkholder holder,int position) {
        holder.binding.recyclerViewTextView.setText(landMarkArrayList.get(position).name);

        //HERBİR ELAMANA TIKLANDIĞINDA NE OLACAĞINI SOYLUYORUZ.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(holder.itemView.getContext(),DetailsActivity.class);
                //intent.putExtra("kayıt",landMarkArrayList.get(holder.getAdapterPosition()));

                Singleton singleton=Singleton.getInstance();
                singleton.setSentLandmark(landMarkArrayList.get(holder.getAdapterPosition()));

                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    //Bu method XML in kaç defa oluştrulacağını söyler
    @Override
    public int getItemCount() {
        return landMarkArrayList.size();
    }

    //Asagidaki sınıf yardımcı sınıftır gorunumlerimizi tutar.



    public class Landmarkholder extends RecyclerView.ViewHolder{

        private final RcyclerRowBinding binding;
        public Landmarkholder(RcyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
