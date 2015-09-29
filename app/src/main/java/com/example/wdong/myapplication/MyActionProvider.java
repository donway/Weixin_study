package com.example.wdong.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/**
 * Created by wdong on 2015/9/18.
 */
public class MyActionProvider extends android.support.v4.view.ActionProvider {

    private Context context;

    public MyActionProvider(Context context) {

        super(context);
        this.context = context;
    }
    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {

        subMenu.clear();
        subMenu.add(context.getString(R.string.group_chat)).setIcon(R.drawable.an6)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
        subMenu.add(context.getString(R.string.add_friend)).setIcon(R.drawable.amh)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
        subMenu.add(context.getString(R.string.scan_code)).setIcon(R.drawable.anm)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
        subMenu.add(context.getString(R.string.help_feedback)).setIcon(R.drawable.an1)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
        super.onPrepareSubMenu(subMenu);
    }

    @Override
    public boolean hasSubMenu() {
        return true;
    }
}
