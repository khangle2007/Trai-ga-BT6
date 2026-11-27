package com.example.trai_ga_bt6;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;

public class AlbumDialogFragment extends DialogFragment {
    public static AlbumDialogFragment newInstance(Album album) {
        AlbumDialogFragment fragment = new AlbumDialogFragment();

        Bundle args = new Bundle();
        args.putString("imageUrl", album.getImageUrl());
        args.putString("date", album.getDate());
        args.putString("description", album.getDescription());

        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        String imageUrl = args.getString("imageUrl");
        String date = args.getString("date");
        String description = args.getString("description");

        View front = view.findViewById(R.id.front);
        View back = view.findViewById(R.id.back);

        ImageView imageView = front.findViewById(R.id.imgAlbum);
        TextView dateFront = front.findViewById(R.id.date);
        TextView dateBack = back.findViewById(R.id.date);
        TextView content = back.findViewById(R.id.content);
        ImageButton delete = view.findViewById(R.id.delete);

        Glide.with(this).load(imageUrl).into(imageView);

        dateFront.setText(date);
        dateBack.setText(date);
        content.setText(description);

        delete.setOnClickListener(v -> dismiss());
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();

        if (dialog != null && dialog.getWindow() != null) {
            Window window = dialog.getWindow();

            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }
}
