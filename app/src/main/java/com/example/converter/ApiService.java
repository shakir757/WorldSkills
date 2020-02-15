package com.example.converter;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("onboarding")
    Call<GetPage> getScreens();
}
