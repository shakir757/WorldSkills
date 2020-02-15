package com.example.converter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPage {

    @SerializedName("onboarding_screens")
    @Expose
    public List<Get> onboarding_screens;

    public GetPage(){}

    public GetPage(List<Get> onboarding_screens) {
        this.onboarding_screens = onboarding_screens;
    }

    public List<Get> getOnboarding_screens() {
        return onboarding_screens;
    }
}
