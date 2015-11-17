package com.siteduzero.android.samples;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siteduzero.android.R;

public class SamplesView extends RelativeLayout {
	private TextView mTextViewTitle;
	private TextView mTextViewChapter;
	
	public SamplesView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public SamplesView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public SamplesView(Context context) {
		super(context);
		init();
	}

	private void init() {
		inflate(getContext(), R.layout.view_samples, this);
		mTextViewTitle = (TextView) findViewById(R.id.textViewTitle);
		mTextViewChapter = (TextView) findViewById(R.id.textViewChapter);
	}
	
	public void bind(int title, int chapter) {
		mTextViewTitle.setText(title);
		mTextViewChapter.setText(chapter);
	}
}
