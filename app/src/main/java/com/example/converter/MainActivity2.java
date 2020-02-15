package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Converter;

public class MainActivity2 extends AppCompatActivity {

    private ImageView imageViewSecond;
    private TextView title, description;
    private String image_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageViewSecond = findViewById(R.id.imageViewSecond);
        title = findViewById(R.id.textViewTitle2);
        description = findViewById(R.id.textViewDescription2);

        getScreensMain2();
    }

    private void getScreensMain2(){
        image_url = DataStorage.getInstance().onboardingScreens.get(1).getUrl();
        Glide.with(MainActivity2.this).load(image_url).into(imageViewSecond);
        title.setText(DataStorage.getInstance().onboardingScreens.get(1).getTitle());
        description.setText(DataStorage.getInstance().onboardingScreens.get(1).getDescription());
    }

    public void gotoNext(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void gotoMain(View view) {
        Intent intent = new Intent(this, ConverterActivity.class);
        startActivity(intent);
    }
}
