package com.example.wdong.myapplication;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;

/**
 * Created by wdong on 2015/9/28.
 */
public class SearchActivity extends AbstratActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");

        ActionBar ab = getActionBar();
//        ab.hide();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowHomeEnabled(false);
        setContentView(R.layout.search_content);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
