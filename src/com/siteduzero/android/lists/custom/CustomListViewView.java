package com.siteduzero.android.lists.custom;

import com.siteduzero.android.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListViewView extends LinearLayout {
	private TextView mTextView;

	public CustomListViewView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CustomListViewView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CustomListViewView(Context context) {
		super(context);
		init();
	}

	private void init() {
		inflate(getContext(), R.layout.view_custom_listview, this);
		mTextView = (TextView) findViewById(R.id.textView);
	}

	public void bind(int text) {
		mTextView.setText(getResources().getString(text));
	}
}
