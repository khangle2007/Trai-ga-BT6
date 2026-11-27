package com.example.trai_ga_bt6;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class AlbumViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    public AlbumViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imgAlbum);
    }
}
