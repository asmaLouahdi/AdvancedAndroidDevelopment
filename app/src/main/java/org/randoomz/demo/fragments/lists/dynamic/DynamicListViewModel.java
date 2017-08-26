package org.randoomz.demo.fragments.lists.dynamic;

public class DynamicListViewModel {
    private int mImageRessource;
    private int mTextRessource;

    public DynamicListViewModel(int image, int text) {
        super();
        this.mImageRessource = image;
        this.mTextRessource = text;
    }

    public int getImageRessource() {
        return mImageRessource;
    }

    public int getTextRessource() {
        return mTextRessource;
    }
}
