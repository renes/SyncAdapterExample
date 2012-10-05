package at.technikum.android.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AccountAuthenticatorService extends Service {

	private static AccountAuthenticatorImpl sAccountAuthenticator = null;

	public AccountAuthenticatorService() {
		super();
	}

	public IBinder onBind(Intent intent) {
		IBinder ret = null;
		if (intent.getAction().equals(android.accounts.AccountManager.ACTION_AUTHENTICATOR_INTENT))
			ret = getAuthenticator().getIBinder();
		return ret;
	}

	private AccountAuthenticatorImpl getAuthenticator() {
		if (sAccountAuthenticator == null) {
			sAccountAuthenticator = new AccountAuthenticatorImpl(this);
		}
		return sAccountAuthenticator;
	}
}