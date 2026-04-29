package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_HITUNG = "hitung";
    public static final String EXTRA_HASIL = "hasil";

    EditText bil1, bil2;
    Button btnTambah, btnKurang, btnKali, btnBagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bil1 = findViewById(R.id.et_bilangan1);
        bil2 = findViewById(R.id.et_bilangan2);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);

        btnTambah.setOnClickListener(v -> hitung('+'));
        btnKurang.setOnClickListener(v -> hitung('-'));
        btnKali.setOnClickListener(v -> hitung('*'));
        btnBagi.setOnClickListener(v -> hitung('/'));
    }

    private void hitung(char operator) {
        String input1 = bil1.getText().toString();
        String input2 = bil2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Masukkan kedua bilangan terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double angka1 = Double.parseDouble(input1);
            double angka2 = Double.parseDouble(input2);

            if (operator == '/' && angka2 == 0) {
                Toast.makeText(this, "Tidak bisa dibagi 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            double hasilHitung = 0;
            switch (operator) {
                case '+':
                    hasilHitung = angka1 + angka2;
                    break;
                case '-':
                    hasilHitung = angka1 - angka2;
                    break;
                case '*':
                    hasilHitung = angka1 * angka2;
                    break;
                case '/':
                    hasilHitung = angka1 / angka2;
                    break;
            }

            String hitungStr = formatNumber(angka1) + " " + operator + " " + formatNumber(angka2);

            Intent intent = new Intent(this, SeccondActivity.class);
            intent.putExtra(EXTRA_HITUNG, hitungStr);
            intent.putExtra(EXTRA_HASIL, hasilHitung);
            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Input tidak valid", Toast.LENGTH_SHORT).show();
        }
    }

    private String formatNumber(double number) {
        if (number == (long) number) {
            return String.valueOf((long) number);
        } else {
            return String.valueOf(number);
        }
    }
}
