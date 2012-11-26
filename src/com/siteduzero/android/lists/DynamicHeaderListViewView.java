package com.siteduzero.android.lists;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siteduzero.android.R;

public class DynamicHeaderListViewView extends RelativeLayout {
	private ImageView mImageView;
	private TextView mTextView;

	public DynamicHeaderListViewView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public DynamicHeaderListViewView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public DynamicHeaderListViewView(Context context) {
		super(context);
		init();
	}

	private void init() {
		inflate(getContext(), R.layout.view_dynamic_header_listview, this);
		mImageView = (ImageView) findViewById(R.id.imageViewAvatar);
		mTextView = (TextView) findViewById(R.id.textView);
	}

	public void bind(int image, int text) {
		mImageView.setImageResource(image);
		mTextView.setText(getResources().getString(text));
	}
}
