package com.example.wdong.myapplication;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by wdong on 2015/9/17.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            String setting = getArguments().getString("key");
            if ("setting1".equals(setting)) {
                addPreferencesFromResource(R.xml.setting1);
            } else if ("setting2".equals(setting)) {
                addPreferencesFromResource(R.xml.setting2);
            } else {
                addPreferencesFromResource(R.xml.preference);
            }
        } else {
            addPreferencesFromResource(R.xml.preference);
        }
    }
}
