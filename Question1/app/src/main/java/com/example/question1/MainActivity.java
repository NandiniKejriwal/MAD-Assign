package com.example.question1;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputValue;
    Spinner fromUnit, toUnit;
    Button convertButton;
    TextView resultText;

    String[] units = {"Feet", "Inches", "Centimeters", "Meters", "Yards"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        fromUnit = findViewById(R.id.fromUnit);
        toUnit = findViewById(R.id.toUnit);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, units);
        fromUnit.setAdapter(adapter);
        toUnit.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputStr = inputValue.getText().toString();
                if (inputStr.isEmpty()) {
                    resultText.setText("Please enter a value");
                    return;
                }

                double input = Double.parseDouble(inputStr);
                String from = fromUnit.getSelectedItem().toString();
                String to = toUnit.getSelectedItem().toString();

                double result = convertLength(input, from, to);
                resultText.setText(String.format("%.4f %s", result, to));
            }
        });
    }

    double convertLength(double value, String from, String to) {
        double valueInMeters = 0.0;
        switch (from) {
            case "Feet": valueInMeters = value * 0.3048; break;
            case "Inches": valueInMeters = value * 0.0254; break;
            case "Centimeters": valueInMeters = value * 0.01; break;
            case "Meters": valueInMeters = value; break;
            case "Yards": valueInMeters = value * 0.9144; break;
        }

        switch (to) {
            case "Feet": return valueInMeters / 0.3048;
            case "Inches": return valueInMeters / 0.0254;
            case "Centimeters": return valueInMeters / 0.01;
            case "Meters": return valueInMeters;
            case "Yards": return valueInMeters / 0.9144;
        }

        return 0.0;
    }
}
