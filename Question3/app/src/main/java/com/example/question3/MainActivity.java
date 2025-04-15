package com.example.question3;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView surprise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 💡 Fix: Initialize the Lottie view
        surprise = findViewById(R.id.surprise);

        if (surprise != null) {
            surprise.setAnimation(R.raw.drago); // filename should be lowercase if inside `res/raw`
            surprise.setRepeatCount(LottieDrawable.INFINITE);
            surprise.playAnimation();
        }
    }
}
