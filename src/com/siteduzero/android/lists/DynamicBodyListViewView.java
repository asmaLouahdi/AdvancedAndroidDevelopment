package com.siteduzero.android.lists;

import com.siteduzero.android.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DynamicBodyListViewView extends LinearLayout {
	private TextView mTextView;

	public DynamicBodyListViewView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public DynamicBodyListViewView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public DynamicBodyListViewView(Context context) {
		super(context);
		init();
	}

	private void init() {
		inflate(getContext(), R.layout.view_dynamic_body_listview, this);
		mTextView = (TextView) findViewById(R.id.textView);
	}

	public void bind(int text) {
		mTextView.setText(getResources().getString(text));
	}
}
