package at.technikum.android.example;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView helloTextView = (TextView) findViewById(R.id.hello);

		AccountManager accountManager = AccountManager.get(this);
		Account[] accounts = accountManager.getAccountsByType(getString(R.string.accountType));

		if (accounts.length != 0) {
			helloTextView.setText(getString(R.string.hello) + " " + accounts[0].name);
		}

	}

}
