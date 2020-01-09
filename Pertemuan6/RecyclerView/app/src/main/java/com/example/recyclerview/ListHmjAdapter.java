package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHmjAdapter extends RecyclerView.Adapter<ListHmjAdapter.ListViewHolder>  {
    private ArrayList<hmj> listHmj;

    public ListHmjAdapter(ArrayList<hmj> list){
        this.listHmj = list;
    }

    @NonNull
    @Override
    public ListHmjAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_hmj, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHmjAdapter.ListViewHolder holder, int position) {
        hmj Hmj = listHmj.get(position);

        Glide.with(holder.itemView.getContext())
                .load(Hmj.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(Hmj.getName());
        holder.tvDesc.setText(Hmj.getDescription());
    }

    @Override
    public int getItemCount() {
        return listHmj.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDesc = itemView.findViewById(R.id.tv_item_des);
        }
    }
}
