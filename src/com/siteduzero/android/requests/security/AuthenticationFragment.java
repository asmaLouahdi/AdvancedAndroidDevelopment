package com.siteduzero.android.requests.security;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.siteduzero.android.R;

public class AuthenticationFragment extends TokenFragment {
	// Connection
	private final Authentication mAuthentication = new Authentication();

	// GUI
	private EditText mEmail;
	private EditText mPassword;
	private Button mLogin;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_authentication, container,
				false);
		mEmail = (EditText) v.findViewById(R.id.edit_text_email);
		mPassword = (EditText) v.findViewById(R.id.edit_text_password);
		mLogin = (Button) v.findViewById(R.id.button_login);

		mPassword.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (actionId == EditorInfo.IME_NULL) {
					attemptLogin();
					return true;
				}
				return false;
			}
		});

		mLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				attemptLogin();
			}
		});

		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// If we have a valid email and password, we execute a request to get a
		// new token.
		SessionStore.restoreLogin(mAuthentication, getActivity());
		if (mAuthentication.isLoginValid()) {
			login();
		}
	}

	private void attemptLogin() {
		// Reset errors.
		mEmail.setError(null);
		mPassword.setError(null);

		// Get values of edit text.
		final String email = mEmail.getText().toString();
		final String password = mPassword.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check values of edit text.
		if (TextUtils.isEmpty(password)) {
			mPassword
					.setError(getString(R.string.security_error_field_required));
			cancel = true;
			focusView = mPassword;
		} else if (password.length() < 6) {
			mPassword.setError(getString(R.string.security_invalid_password));
			cancel = true;
			focusView = mPassword;
		}
		if (TextUtils.isEmpty(email)) {
			mEmail.setError(getString(R.string.security_error_field_required));
			cancel = true;
			focusView = mEmail;
		} else if (!email.contains("@")) {
			// TODO change for a complex regular expression.
			mEmail.setError(getString(R.string.security_invalid_email));
			cancel = true;
			focusView = mEmail;
		}
		if (cancel) {
			focusView.requestFocus();
		} else {
			login();
		}
	}

	private void login() {
		final Bundle bundle = new Bundle();
		bundle.putString(KEY_EMAIL, mAuthentication.getEmail());
		bundle.putString(KEY_PASSWORD, mAuthentication.getPassword());
		getLoaderManager().initLoader(ID_LOADER_AUTH, bundle, this);
	}
}
