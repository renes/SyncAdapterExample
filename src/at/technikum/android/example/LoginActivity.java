package at.technikum.android.example;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AccountAuthenticatorActivity {
	EditText userNameEditText;
	EditText passwordEditText;
	Button loginButton;
	ProgressDialog dialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		userNameEditText = (EditText) findViewById(R.id.user);
		passwordEditText = (EditText) findViewById(R.id.password);
		loginButton = (Button) findViewById(R.id.loginBtn);

		dialog = new ProgressDialog(this);
		dialog.setMessage(getString(R.string.inProgress));
		dialog.setCancelable(true);

		loginButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				String user = userNameEditText.getText().toString().trim().toLowerCase();
				String password = passwordEditText.getText().toString().trim().toLowerCase();

				if (user.length() > 0 && password.length() > 0) {
					CheckLoginTask checkLoginTask = new CheckLoginTask(LoginActivity.this);
					checkLoginTask.execute(user, password);
				}
			}

		});
	}

	private class CheckLoginTask extends AsyncTask<String, Void, Boolean> {
		Context context;

		CheckLoginTask(Context c) {
			context = c;

			runOnUiThread(new Runnable() {
				public void run() {
					loginButton.setEnabled(false);
					dialog.show();
				}
			});
		}

		@Override
		public Boolean doInBackground(String... params) {
			String user = params[0];
			String password = params[1];

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				Log.e("Error", "failed to wait");
			}

			Account account = new Account(user, context.getString(R.string.accountType));
			AccountManager accountManager = AccountManager.get(context);
			ContentResolver.setIsSyncable(account, "at.technikum.android.example.someData", 1);
			if (accountManager.addAccountExplicitly(account, password, null)) {
				Bundle result = new Bundle();
				result.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
				result.putString(AccountManager.KEY_ACCOUNT_TYPE, account.type);
				setAccountAuthenticatorResult(result);
				return true;
			} else {
				return false;
			}
		}

		@Override
		public void onPostExecute(Boolean result) {
			loginButton.setEnabled(true);
			dialog.dismiss();
			if (result) {
				finish();
			}

		}
	}
}