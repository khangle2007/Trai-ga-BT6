package com.example.trai_ga_bt6;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AlbumData {
    public static ArrayList<Album> loadAlbums(Context context) {
        ArrayList<Album> albums = new ArrayList<>();

        try {
            InputStream inputStream = context.getAssets().open("album.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            reader.close();

            JSONArray jsonArray = new JSONArray(stringBuilder.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject albumObject = jsonArray.getJSONObject(i);

                int id = albumObject.getInt("id");
                String imageUrl = albumObject.getString("imageUrl");
                String date = albumObject.getString("date");
                String description = albumObject.getString("description");

                Album album = new Album(id, imageUrl, date, description);
                albums.add(album);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return albums;
    }
}
