package com.akvelon.ivanmatkov.mobilecentertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String MOBILE_CENTER_APP_ID = "4250a53c-8bf1-4057-9bf5-32e4179ccd33";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileCenter.start(getApplication(), MOBILE_CENTER_APP_ID, Analytics.class, Crashes.class);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.send_event_button)
    public void sendEvent() {
        Analytics.trackEvent("Test event");
    }

    @OnClick(R.id.test_crach_button)
    public void testCrash() {
        Crashes.generateTestCrash();
    }
}
