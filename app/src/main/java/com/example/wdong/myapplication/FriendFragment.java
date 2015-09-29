package com.example.wdong.myapplication;

import android.app.Fragment;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by wdong on 2015/9/16.
 */
public class FriendFragment extends Fragment {

    ListView lv;
    LayoutInflater inflater;
    SiderBar sb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.friend_fragment, container, false);
        lv = (ListView) view.findViewById(R.id.list);
        inflater = getActivity().getLayoutInflater();
        lv.setAdapter(new ContactAdapter(getActivity(), inflater));
        sb = (SiderBar)view.findViewById(R.id.siderbar);
        View header = inflater.inflate(R.layout.listview_header, null);
        lv.addHeaderView(header);
        View foot = inflater.inflate(R.layout.listview_foot, null);
        lv.addFooterView(foot);
        sb.setListView(lv);
        return view;
    }
}
