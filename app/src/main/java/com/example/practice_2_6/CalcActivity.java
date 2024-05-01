package com.example.practice_2_6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText firstValueEditText = findViewById(R.id.firstValueEditText);
        EditText secondValueEditText = findViewById(R.id.secondValueEditText);
        EditText thirdValueEditText = findViewById(R.id.thirdValueEditText);

        Button calcButton = findViewById(R.id.calculateButton);
        TextView answerTextView = findViewById(R.id.answerTextView);

        calcButton.setOnClickListener(v -> {
            if (!firstValueEditText.getText().toString().isEmpty() ||
                    !secondValueEditText.getText().toString().isEmpty() ||
                    !thirdValueEditText.getText().toString().isEmpty()){
                int ans = Integer.parseInt(firstValueEditText.getText().toString()) *
                        Integer.parseInt(secondValueEditText.getText().toString()) *
                        Integer.parseInt(thirdValueEditText.getText().toString());

                answerTextView.setText("Answer: " + ans);
            }
        });
    }
}
