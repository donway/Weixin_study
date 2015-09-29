package com.example.wdong.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by wdong on 2015/9/23.
 */
public class MyListAdapter extends BaseAdapter {

    private Context context;
    LayoutInflater mInflater;

    MyListAdapter(LayoutInflater inflater) {
        mInflater = inflater;
    }
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {

            convertView = mInflater.inflate(R.layout.friendlist_layout, null);
        }

        if((position % 2) == 1) {
            convertView.findViewById(R.id.textview_number).setVisibility(View.GONE);
            convertView.findViewById(R.id.imageview_new).setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}
