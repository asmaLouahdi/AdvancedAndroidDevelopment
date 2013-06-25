package com.siteduzero.android.requests.security;

import com.siteduzero.android.requests.products.PHPRequestActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

public class TokenFragment extends Fragment implements
		LoaderManager.LoaderCallbacks<String> {
	protected static final int ID_LOADER_REGISTER = 0;
	protected static final int ID_LOADER_AUTH = 1;
	protected static final String KEY_EMAIL = "email";
	protected static final String KEY_PASSWORD = "password";

	@Override
	public Loader<String> onCreateLoader(int id, Bundle bundle) {
		final String email = bundle.getString(KEY_EMAIL);
		final String password = bundle.getString(KEY_PASSWORD);
		return new RegisterAsyncTaskLoader(getActivity(), email, password);
	}

	@Override
	public void onLoadFinished(Loader<String> loader, String data) {
		if (data != null && !data.isEmpty()) {
			SessionStore.saveAccessToken(data, getActivity());
			final Intent i = new Intent(getActivity(), PHPRequestActivity.class);
			startActivity(i);
			getActivity().finish(); // Finish this activity for back navigation.
		}
	}

	@Override
	public void onLoaderReset(Loader<String> arg0) {
		// Nothing to do here.
	}

}
