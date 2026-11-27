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

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder>{

    private List<Album> albums;

    AlbumAdapter (List<Album> albums) {
        this.albums = albums;
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

        holder.imageView.setOnClickListener(view ->  {
            showAlbumDialog(holder, album);
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public void showAlbumDialog(AlbumViewHolder holder, Album album) {
        Dialog dialog = new Dialog(holder.itemView.getContext());
        dialog.setContentView(R.layout.image_item);

        View front = dialog.findViewById(R.id.front);
        View back = dialog.findViewById(R.id.back);

        float distance = 8000 * front.getResources()
                .getDisplayMetrics().density;

        front.setCameraDistance(distance);
        back.setCameraDistance(distance);

        front.setOnClickListener(v -> {
            flipAlbum(front, back);
        });

        back.setOnClickListener(v -> {
            flipAlbum(back, front);
        });

        ImageButton deleteButton = dialog.findViewById(R.id.delete);
        ImageView imageView = dialog.findViewById(R.id.imgAlbum);
        TextView dateTextView = dialog.findViewById(R.id.date);

        ImageButton deleteButton2 = back.findViewById(R.id.delete);
        TextView dateTextView2 = back.findViewById(R.id.date);
        TextView contentTextView = dialog.findViewById(R.id.content);

        Glide.with(holder.itemView.getContext()).load(album.getImageUrl()).into(imageView);

        dateTextView.setText(album.getDate());
        dateTextView2.setText(album.getDate());

        contentTextView.setText(album.getDescription());

        dialog.show();

        Window window = dialog.getWindow();

        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }


        deleteButton.setOnClickListener(view -> dialog.dismiss());
        deleteButton2.setOnClickListener(view -> dialog.dismiss());
    }

    private void flipAlbum(View front, View back) {

        front.animate()
                .rotationY(90)
                .setDuration(250)
                .withEndAction(() -> {
                    front.setVisibility(View.GONE);

                    back.setVisibility(View.VISIBLE);
                    back.setRotationY(-90);

                    back.animate()
                            .rotationY(0)
                            .setDuration(250)
                            .start();
                })
                .start();
    }
}
