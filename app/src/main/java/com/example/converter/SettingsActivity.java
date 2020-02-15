package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    TextView language, info, menuC, menuS, version, header;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        language = findViewById(R.id.textViewChangeLanguage);
        info = findViewById(R.id.textViewInfo);
        menuC = findViewById(R.id.textViewConvert1);
        menuS = findViewById(R.id.textViewSettings1);
        version = findViewById(R.id.textViewVerison);
        header = findViewById(R.id.textViewHeader);
    }

    public void gotoConverter(View view) {
        Intent intent = new Intent(this, ConverterActivity.class);
        startActivity(intent);
    }

    public void changelanguage(View view) {
        if (i == 0) {
            language.setText("Поменять язык");
            info.setText("Информация");
            menuC.setText("Конвертировать");
            menuS.setText("Настройки");
            version.setText("версия приложения 1.0");
            header.setText("Настройки");
            i = 1;
        } else {
            language.setText("Change Language");
            info.setText("Info");
            menuC.setText("Convert");
            menuS.setText("Settings");
            version.setText("app version 1.0");
            header.setText("Settings");
            i = 0;
        }
    }
}
