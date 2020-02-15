package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Converter;

public class MainActivity3 extends AppCompatActivity {

    private ImageView imageViewThird;
    private TextView title, description;
    private String image_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageViewThird = findViewById(R.id.imageViewThird);
        title = findViewById(R.id.textViewTitle3);
        description = findViewById(R.id.textViewDescription3);

        getScreensMain3();
    }

    private void getScreensMain3(){
        image_url = DataStorage.getInstance().onboardingScreens.get(2).getUrl();
        Glide.with(MainActivity3.this).load(image_url).into(imageViewThird);
        title.setText(DataStorage.getInstance().onboardingScreens.get(2).getTitle());
        description.setText(DataStorage.getInstance().onboardingScreens.get(2).getDescription());
    }

    public void gotoNext(View view) {
        Intent intent = new Intent(this, ConverterActivity.class);
        startActivity(intent);
    }
}
