package com.example.trai_ga_bt6;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder>{

    private List<Album> albums;
    private FragmentManager fragmentManager;

    AlbumAdapter (List<Album> albums, FragmentManager fragmentManager) {
        this.albums = albums;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imggrid1in3, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        Album album = albums.get(position);
        Glide.with(holder.itemView.getContext()).load(album.getImageUrl()).into(holder.imageView);

        holder.imageView.setOnClickListener(view -> {
            AlbumDialogFragment dialog = AlbumDialogFragment.newInstance(album);

            dialog.show(fragmentManager, "AlbumDialog");
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}
