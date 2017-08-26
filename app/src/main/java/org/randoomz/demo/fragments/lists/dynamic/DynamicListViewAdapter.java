package org.randoomz.demo.fragments.lists.dynamic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.randoomz.demo.R;

import java.util.ArrayList;
import java.util.List;

public class DynamicListViewAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<Object> mModels = new ArrayList<Object>();

    public DynamicListViewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mModels.size();
    }

    @Override
    public Object getItem(int position) {
        return mModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Object item = getItem(position);

        if (item instanceof DynamicListViewModel) {
            HeaderViewHolder headerHolder;
            if (convertView == null) {
                // It's the first instantiation, we create our view.
                convertView = LayoutInflater.from(mContext).inflate(R.layout.view_dynamic_header_listview, parent, false);
                headerHolder = new HeaderViewHolder(convertView);
                convertView.setTag(headerHolder);
            } else {
                // Android is awesome, we can retrieve an older version of our view.
                headerHolder = (HeaderViewHolder) convertView.getTag();
            }

            DynamicListViewModel headerModel = (DynamicListViewModel) getItem(position);
            headerHolder.bind(headerModel.getTextRessource(), headerModel.getImageRessource());
        } else if (item instanceof Integer) {
            BodyViewHolder bodyHolder;
            if (convertView == null) {
                // It's the first instantiation, we create our view.
                convertView = LayoutInflater.from(mContext).inflate(R.layout.view_dynamic_body_listview, parent, false);
                bodyHolder = new BodyViewHolder(convertView);
                convertView.setTag(bodyHolder);
            } else {
                // Android is awesome, we can retrieve an older version of our view.
                bodyHolder = (BodyViewHolder) convertView.getTag();
            }
            Integer bodyModel = (Integer) getItem(position);
            bodyHolder.bind(bodyModel);
        }

        return convertView;
    }

    public void add(Object model) {
        mModels.add(model);
    }

    private static class HeaderViewHolder {
        private ImageView mImageView;
        private TextView mTextView;

        public HeaderViewHolder(final View view) {
            mImageView = (ImageView) view.findViewById(R.id.imageViewAvatar);
            mTextView = (TextView) view.findViewById(R.id.textView);
        }

        public void bind(int text, int image) {
            mImageView.setImageResource(image);
            mTextView.setText(text);
        }
    }

    private static class BodyViewHolder {
        private TextView mTextView;

        public BodyViewHolder(final View view) {
            mTextView = (TextView) view.findViewById(R.id.textView);
        }

        public void bind(int text) {
            mTextView.setText(text);
        }
    }
}
