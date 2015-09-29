package com.example.wdong.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by wdong on 2015/9/24.
 */
public class ContactAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    Activity activity;

    ContactAdapter(Activity activity, LayoutInflater inflater) {
        mInflater = inflater;
        this.activity = activity;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.contact_item, null);
        }
        View view = convertView.findViewById(R.id.listview_text);
        if((position % 2) == 1) view.setVisibility(View.GONE);
        return convertView;
    }

    public Object[] getSections() {
//        positionOfSection = new SparseIntArray();
//        sectionOfPosition = new SparseIntArray();
//        int count = getCount();
//        list = new ArrayList<String>();
//        list.add(getContext().getString(R.string.search_header));
//        positionOfSection.put(0, 0);
//        sectionOfPosition.put(0, 0);
//        for (int i = 1; i < count; i++) {
//
//            String letter = getItem(i).getHeader();
//            System.err.println("contactadapter getsection getHeader:" + letter
//                    + " name:" + getItem(i).getUsername());
//            int section = list.size() - 1;
//            if (list.get(section) != null && !list.get(section).equals(letter)) {
//                list.add(letter);
//                section++;
//                positionOfSection.put(section, i);
//            }
//            sectionOfPosition.put(i, section);
//        }
//        return list.toArray(new String[list.size()]);
        String[] s = {"A", "B"};
        return s;
    }

    public int getPositionForSection(int i) {
        return 3;
    }
}
