package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Context context = getApplicationContext();
        SharedPreferences prefs = context.getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        Boolean isOnboardingPresented = prefs.getBoolean("isOnboardingPresented", false);

        // тут ваще бред какой-то, должно все работать по коду, проверил все 999 раз
        // но почему сразу открыватся конвертер

        if (!isOnboardingPresented) {
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
            prefs.edit().putBoolean("isOnboardingPresented", true).apply();
        } else {
            Intent intent2 = new Intent(this, ConverterActivity.class);
            startActivity(intent2);
        }

    }
}
