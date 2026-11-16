
package com.example.personalizatortekstu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvText;
    Button btnChangeText, btnChangeColor, btnChangeBg;
    SwitchCompat switchNight;
    LinearLayout rootLayout;

    int color = 0;
    int bg = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tvText);
        btnChangeText = findViewById(R.id.btnChangeText);
        btnChangeColor = findViewById(R.id.btnChangeColor);
        btnChangeBg = findViewById(R.id.btnChangeBg);
        switchNight = findViewById(R.id.switchNight);
        rootLayout = findViewById(R.id.rootLayout);

        btnChangeText.setOnClickListener(v -> {
            tvText.setText("Witaj w mojej aplikacji!");
        });

        btnChangeColor.setOnClickListener(v -> {
            if (color == 0) {
                tvText.setTextColor(0xFFFF0000);
                color = 1;
            } else {
                tvText.setTextColor(0xFF000000);
                color = 0;
            }
        });

        btnChangeBg.setOnClickListener(v -> {
            if (bg == 1) {
                rootLayout.setBackgroundResource(R.drawable.tlo2);
                bg = 2;
            } else if (bg == 2) {
                rootLayout.setBackgroundResource(R.drawable.tlo3);
                bg = 3;
            } else {
                rootLayout.setBackgroundResource(R.drawable.tlo1);
                bg = 1;
            }
        });

        switchNight.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                getDelegate().setLocalNightMode(
                        androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                getDelegate().setLocalNightMode(
                        androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
    }
}
