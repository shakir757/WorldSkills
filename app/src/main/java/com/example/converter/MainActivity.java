package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewFirst;
    private TextView title, description;
    private String image_url;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewFirst = findViewById(R.id.imageViewFirst);
        title = findViewById(R.id.textViewTitle1);
        description = findViewById(R.id.textViewDescription1);

         getScreensMain();
    }

    private void getScreensMain(){

        Retrofit  retrofit = new Retrofit.Builder()
                .baseUrl("https://c47fc10f-d7e2-4fff-9fd1-db139e6f4337.mock.pstmn.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<GetPage> call = apiService.getScreens();

        call.enqueue(new Callback<GetPage>() {
            @Override
            public void onResponse(Call<GetPage> call, Response<GetPage> response) {

                if(!response.isSuccessful()){
                    description.setText("Code: " + response.code());
                }

                image_url = response.body().onboarding_screens.get(0).getUrl();
                Glide.with(MainActivity.this).load(image_url).into(imageViewFirst);
                title.setText(response.body().onboarding_screens.get(0).getTitle());
                description.setText(response.body().getOnboarding_screens().get(0).getDescription());
                DataStorage.getInstance().onboardingScreens = response.body().onboarding_screens;

                // Log.d(TAG, "image url: " + response.body().onboarding_screens.get(0).getUrl());
                // Log.d(TAG, "title: " + response.body().onboarding_screens.get(0).getTitle());
                // Log.d(TAG, "description: " + response.body().onboarding_screens.get(0).getDescription());

            }

            @Override
            public void onFailure(Call<GetPage> call, Throwable t) {
                description.setText("Error: " + t.getMessage());

                // Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

    public void gotoNext(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void gotoMain(View view) {
        Intent intent = new Intent(this, ConverterActivity.class);
        startActivity(intent);
    }
}
