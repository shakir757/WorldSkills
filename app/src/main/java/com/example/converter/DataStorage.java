package com.example.converter;

import java.util.List;

public final class DataStorage {

    private static DataStorage instance;

    public List<Get> onboardingScreens;

    private DataStorage() { }

    public static DataStorage getInstance() {
        if (instance == null) {
            instance = new DataStorage();
        }
        
        return instance;
    }
}