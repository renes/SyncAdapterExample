package at.technikum.android.example.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SyncAdapter extends Service {

	private static SyncAdapterImpl syncAdapterImpl = null;

	public SyncAdapter() {
		super();
	}

	@Override
	public IBinder onBind(Intent intent) {
		IBinder ret = null;
		ret = getSyncAdapter().getSyncAdapterBinder();
		return ret;
	}

	private SyncAdapterImpl getSyncAdapter() {
		if (syncAdapterImpl == null) {
			syncAdapterImpl = new SyncAdapterImpl(this);
		}
		return syncAdapterImpl;
	}

}
