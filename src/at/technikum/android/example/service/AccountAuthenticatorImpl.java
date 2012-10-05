package at.technikum.android.example.service;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import at.technikum.android.example.LoginActivity;

class AccountAuthenticatorImpl extends AbstractAccountAuthenticator {
	private Context mContext;

	public AccountAuthenticatorImpl(Context context) {
		super(context);
		mContext = context;
	}

	@Override
	public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType,
			String[] requiredFeatures, Bundle options) throws NetworkErrorException {
		Bundle reply = new Bundle();

		Intent i = new Intent(mContext, LoginActivity.class);
		i.setAction("at.technikum.android.exmaple.someAction");
		i.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
		reply.putParcelable(AccountManager.KEY_INTENT, i);

		return reply;
	}

	@Override
	public Bundle confirmCredentials(AccountAuthenticatorResponse response, Account account, Bundle options) {
		return null;
	}

	@Override
	public Bundle editProperties(AccountAuthenticatorResponse response, String accountType) {
		return null;
	}

	@Override
	public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType,
			Bundle options) throws NetworkErrorException {
		return null;
	}

	@Override
	public String getAuthTokenLabel(String authTokenType) {
		return null;
	}

	@Override
	public Bundle hasFeatures(AccountAuthenticatorResponse response, Account account, String[] features)
			throws NetworkErrorException {
		return null;
	}

	@Override
	public Bundle updateCredentials(AccountAuthenticatorResponse response, Account account, String authTokenType,
			Bundle options) {
		return null;
	}
}