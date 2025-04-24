package com.example.question5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<File> imageFiles;

    public ImageAdapter(Context context, ArrayList<File> imageFiles) {
        this.context = context;
        this.imageFiles = imageFiles;
    }

    @Override
    public int getCount() {
        return imageFiles.size();
    }

    @Override
    public Object getItem(int position) {
        return imageFiles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageURI(android.net.Uri.fromFile(imageFiles.get(position)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
        return imageView;
    }
}

