package com.example.question5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

import com.example.question5.ImageAdapter;
import com.example.question5.imagedetailactivity;

public class GalleryActivity extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<File> imageFiles = new ArrayList<>();
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gridView = findViewById(R.id.gridView);
        loadImages();

        imageAdapter = new ImageAdapter(this, imageFiles);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            File selectedImage = imageFiles.get(position);
            Intent intent = new Intent(GalleryActivity.this, imagedetailactivity.class);
            intent.putExtra("imagePath", selectedImage.getAbsolutePath());
            startActivity(intent);
        });
    }

    private void loadImages() {
        File storageDir = new File(android.os.Environment.getExternalStorageDirectory() + "/MyGallery");
        if (storageDir.exists()) {
            File[] files = storageDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getAbsolutePath().endsWith(".jpg") || file.getAbsolutePath().endsWith(".png")) {
                        imageFiles.add(file);
                    }
                }
            }
        }
    }
}
