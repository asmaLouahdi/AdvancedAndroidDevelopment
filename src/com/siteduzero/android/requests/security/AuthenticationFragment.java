package com.siteduzero.android.requests.security;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.siteduzero.android.R;
import com.siteduzero.android.utils.Utils;

public class AuthenticationFragment extends Fragment {
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
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// If we have a valid email and password, we execute a request to get a
		// new token.
		SessionStore.restoreLogin(mAuthentication, getActivity());
		if (mAuthentication.isLoginValid()) {
			Toast.makeText(getActivity(), "Get a new token on the server.",
					Toast.LENGTH_SHORT).show();
		}

		mLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				clickLogin();
			}
		});
	}

	private void clickLogin() {
		final String email = mEmail.getText().toString();
		final String password = mPassword.getText().toString();
		if (Utils.checkString(email)) {
			Toast.makeText(getActivity(), "You must specify an email.",
					Toast.LENGTH_SHORT).show();
			return;
		}
		if (Utils.checkString(password)) {
			Toast.makeText(getActivity(), "You must specify a password.",
					Toast.LENGTH_SHORT).show();
			return;
		}
		Toast.makeText(getActivity(), "Successful login.", Toast.LENGTH_SHORT)
				.show();
	}
}
