package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SeccondActivity extends AppCompatActivity {

    private TextView textHitung, textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccond);

        textHitung = findViewById(R.id.TextHitung);
        textHasil = findViewById(R.id.TextHasil);

        Intent intent = getIntent();

        if (intent != null) {
            String hitung = intent.getStringExtra(MainActivity.EXTRA_HITUNG);
            double hasil = intent.getDoubleExtra(MainActivity.EXTRA_HASIL, 0);

            textHitung.setText(hitung);

            if (hasil == (long) hasil) {
                textHasil.setText(String.valueOf((long) hasil));
            } else {
                textHasil.setText(String.valueOf(hasil));
            }
        }
    }
}
