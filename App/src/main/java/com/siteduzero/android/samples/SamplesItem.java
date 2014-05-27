package com.siteduzero.android.samples;

public class SamplesItem {
	private final int mTitle;
	private final int mPart;
	private final int mChapter;
	private final Class<?> mActivityToStart;

	public SamplesItem(int title, int part, int chapter, Class<?> activityToStart) {
		super();
		this.mTitle = title;
		this.mPart = part;
		this.mChapter = chapter;
		this.mActivityToStart = activityToStart;
	}
	
	public int getTitle() {
		return mTitle;
	}
	
	public int getPart() {
		return mPart;
	}

	public int getChapter() {
		return mChapter;
	}

	public Class<?> getActivityToStart() {
		return mActivityToStart;
	}
}
