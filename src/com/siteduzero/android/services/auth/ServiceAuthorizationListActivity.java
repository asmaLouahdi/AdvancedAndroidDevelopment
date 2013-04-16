package com.siteduzero.android.services.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.google.android.gms.auth.GoogleAuthUtil;

public class ServiceAuthorizationListActivity extends ListActivity {
	private AccountManager mAccountManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final String[] accounts = getAccountNames();
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, accounts);
		setListAdapter(adapter);
	}

	private String[] getAccountNames() {
		mAccountManager = AccountManager.get(this);
		Account[] accounts = mAccountManager
				.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
		String[] names = new String[accounts.length];
		for (int i = 0; i < names.length; i++) {
			names[i] = accounts[i].name;
		}
		return names;
	}
}
