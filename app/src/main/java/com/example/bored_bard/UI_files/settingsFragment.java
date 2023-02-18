package com.example.bored_bard.UI_files;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.preference.PreferenceFragmentCompat;

import com.example.bored_bard.R;

public class settingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}
