package at.technikum.android.example.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import at.technikum.android.example.R;

public class SettingsFragment extends PreferenceFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.pref);
	}

}