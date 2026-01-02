package com.jovannirodriguez.inch2meter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInches;
    private Button buttonConvert;
    private TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Grab Views from .xml file
        findViews();

        // Set up button click listener and return result
        setButtonConvertClickListener();


    }


    private void findViews() {
        editTextInches = findViewById(R.id.edit_text_inches);
        buttonConvert = findViewById(R.id.button_convert);
        resultText = findViewById(R.id.text_view_result);
    }

    private void setButtonConvertClickListener() {
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if editTextInches empty
                if (editTextInches.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a value for inches", Toast.LENGTH_SHORT).show();
                } else {
                    // Get inches from editTextInches and convert to meters
                    double inches = Double.parseDouble(editTextInches.getText().toString());
                    double result = convertToMeters(inches);

                    // Display the result
                    displayResult(inches, result);
                }

            }
        });
    }


    private double convertToMeters(double inches) {
        return inches * 0.0254;
    }

    private void displayResult(double inches, double result) {
        resultText.setText(String.format("%.2f inches = %.2f meters", inches, result));
    }

}