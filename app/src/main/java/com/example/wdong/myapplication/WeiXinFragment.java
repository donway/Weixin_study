package com.example.wdong.myapplication;

//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by wdong on 2015/9/16.
 */
public class WeiXinFragment extends Fragment implements AdapterView.OnItemClickListener{

    ListView lv;
    Toast mToast;
    View barSearch;
    View barAction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment1, container, false);
        lv = (ListView)view.findViewById(R.id.weixin_listview);
        lv.setAdapter(new MyListAdapter(getActivity().getLayoutInflater()));
        lv.setOnItemClickListener(this);
//        barSearch = view.findViewById(R.id.bar_search);
//        barAction = view.findViewById(R.id.bar_action);
//        barSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                //startActivity(new Intent(getActivity(), SearchActivity.class));
//            }
//        });
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mToast == null ) {
            mToast = Toast.makeText(getActivity(), "hi friend you click " + position, Toast.LENGTH_SHORT);
            mToast.show();
        } else {
            mToast.setText("hi friend you clicked " + position);
            mToast.show();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
    }
}
