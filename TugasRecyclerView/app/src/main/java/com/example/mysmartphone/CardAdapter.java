package com.example.mysmartphone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ListViewHolder> {
    private ArrayList<HP> listHP;
    private Context context;

    public CardAdapter(ArrayList<HP> listHP, Context context) {
        this.listHP = listHP;
        this.context = context;
    }


    @NonNull
    @Override
    public CardAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_hp, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ListViewHolder holder, int position) {
        final HP hp = listHP.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hp.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgPhoto);
        holder.tvName.setText(hp.getName());
        holder.tvDesc.setText(hp.getDescription());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailHP = new Intent(context, DetailHP.class);
                detailHP.putExtra("hp_id" , hp.getId());
                context.startActivity(detailHP);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listHP.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_hp_list);
            tvName = itemView.findViewById(R.id.name_hp_list);
            tvDesc = itemView.findViewById(R.id.desc_hp_list);
            cv = itemView.findViewById(R.id.cardview_item);
        }
    }
}
