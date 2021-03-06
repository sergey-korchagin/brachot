package com.brakhot.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.brakhot.R;
import com.backendless.Backendless;
import com.brakhot.manager.AdsDataManager;

import java.util.Map;

public class SplashScreenActivity extends AppCompatActivity {
    private static final String TAG = SplashScreenActivity.class.getSimpleName();
    private static final String APP_ID = "4881BFCC-812C-1252-FF39-934E74AE8000";
    private static final String SECRET_KEY = "927023F8-39AF-EF4B-FFF8-0F8E410D6900";
    private AdsDataManager mAdsDataManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        String appVersion = getString(R.string.version);
        mAdsDataManager = AdsDataManager.getInstance();
        mAdsDataManager.init();

        Backendless.initApp(this, APP_ID, SECRET_KEY, appVersion);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                getAdsData();

            }
        }, 1000);
    }

    private void getAdsData() {
        Backendless.Persistence.of("advertising").find(new AsyncCallback<BackendlessCollection<Map>>() {
            @Override
            public void handleResponse(BackendlessCollection<Map> mapBackendlessCollection) {
                for (int i = 0; i < mapBackendlessCollection.getCurrentPage().size(); i++) {
                    Log.v(TAG, mapBackendlessCollection.getCurrentPage().get(i).get("ad_text").toString());
                    Log.v(TAG, mapBackendlessCollection.getCurrentPage().get(i).get("image").toString());
                    mAdsDataManager.addItemToList(mapBackendlessCollection.getCurrentPage().get(i).get("ad_text").toString(), mapBackendlessCollection.getCurrentPage().get(i).get("image").toString());
                }
                startMainActivity();
            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {
                Log.w(TAG, "Error reading data from server");
                //need to add to list with no internet
                mAdsDataManager.addItemToList("test", "no url");
                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, ChoiceBookActivity.class);
        startActivity(intent);
        finish();
    }
}
