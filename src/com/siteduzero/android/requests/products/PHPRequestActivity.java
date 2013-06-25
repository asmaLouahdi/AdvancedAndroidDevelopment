package com.siteduzero.android.requests.products;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.siteduzero.android.R;

public class PHPRequestActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		super.onCreate(arg0);
		setContentView(R.layout.activity_requests_php);
	}
}
