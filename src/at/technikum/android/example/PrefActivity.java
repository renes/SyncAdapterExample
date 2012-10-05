package at.technikum.android.example;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import at.technikum.android.example.fragments.SettingsFragment;

public class PrefActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
	}
}
