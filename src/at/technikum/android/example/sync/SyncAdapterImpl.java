package at.technikum.android.example.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

class SyncAdapterImpl extends AbstractThreadedSyncAdapter {
	@SuppressWarnings("unused")
	private Context context;

	public SyncAdapterImpl(Context context) {
		super(context, true);
		this.context = context;
	}

	@Override
	public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider,
			SyncResult syncResult) {

		Log.e("tag", "some sync");
	}
}