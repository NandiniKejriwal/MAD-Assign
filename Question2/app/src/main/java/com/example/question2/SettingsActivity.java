package com.example.question2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends AppCompatActivity {

    Button toggleThemeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        toggleThemeBtn = findViewById(R.id.toggleThemeButton);

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        boolean isDark = prefs.getBoolean("dark_mode", false);
        toggleThemeBtn.setText(isDark ? "Switch to Light Mode" : "Switch to Dark Mode");

        toggleThemeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean currentDark = prefs.getBoolean("dark_mode", false);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("dark_mode", !currentDark);
                editor.apply();

                AppCompatDelegate.setDefaultNightMode(!currentDark ?
                        AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

                recreate(); // Optional: restart activity to reflect changes
            }
        });
    }
}
