package com.example.question5;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class imageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        String imagePath = getIntent().getStringExtra("imagePath");
        File imageFile = new File(imagePath);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageURI(android.net.Uri.fromFile(imageFile));

        TextView details = findViewById(R.id.textDetails);
        String info = "Name: " + imageFile.getName() +
                "\nPath: " + imageFile.getAbsolutePath() +
                "\nSize: " + (imageFile.length() / 1024) + " KB" +
                "\nDate: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(imageFile.lastModified()));
        details.setText(info);

        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("Are you sure you want to delete this image?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    imageFile.delete();
                    finish();
                })
                .setNegativeButton("No", null)
                .show());
    }
}

