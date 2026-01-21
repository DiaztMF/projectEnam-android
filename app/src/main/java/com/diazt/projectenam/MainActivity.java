package com.diazt.projectenam;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText input;
    Button alert;
    Spinner opsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        input = findViewById(R.id.input);
        alert = findViewById(R.id.alert);
        opsi = findViewById(R.id.spinner);

        alert.setOnClickListener(v -> {
            String inputValue = input.getText().toString().trim();
            String selectedOption = opsi.getSelectedItem().toString();

            String message = "No Telp " + selectedOption + " anda " + inputValue + "? Klik Ok jika benar, atau Cancel jika salah";

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Alert")
                    .setMessage(message)
                    .setPositiveButton("Ok", (dialog, which) -> dialog.dismiss())
                    .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                    .show();

        });
    }
}