package com.example.wdong.myapplication;

//import android.app.Activity;
//import android.app.FragmentManager;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AbstratActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{


    View weixin;
    View friend;
    View discover;
    View mine;
    WeiXinFragment fragment1;
    FriendFragment fragment2;
    DiscoverFragment fragment3;
    MineFragment fragment4;
    ViewPager viewPager;
    FragmentManager fm;
    ImageView image_weixin;
    TextView text_weixin;
    ImageView image_friend;
    TextView text_friend;
    ImageView image_discover;
    TextView text_discover;
    ImageView image_mine;
    TextView text_mine;
    View barSearch;
    View barAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar bar = getActionBar();
        bar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weixin = (View)findViewById(R.id.button_weixin);
        friend = findViewById(R.id.button_friend);
        discover = findViewById(R.id.button_discover);
        mine = findViewById(R.id.button_mine);
        image_weixin = (ImageView)findViewById(R.id.image_weixin);
        text_weixin = (TextView)findViewById(R.id.text_weixin);
        viewPager = (ViewPager)findViewById(R.id.fragment1);
        image_friend = (ImageView)findViewById(R.id.image_friend);
        text_friend = (TextView)findViewById(R.id.text_friend);
        image_discover = (ImageView)findViewById(R.id.image_discover);
        text_discover = (TextView)findViewById(R.id.text_discover);
        image_mine = (ImageView)findViewById(R.id.image_mine);
        text_mine = (TextView)findViewById(R.id.text_mine);
        barSearch = findViewById(R.id.bar_search);
        barSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });
        barAction = findViewById(R.id.bar_action);
        barAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fm = getFragmentManager();
        weixin.setOnClickListener(this);
        friend.setOnClickListener(this);
        discover.setOnClickListener(this);
        mine.setOnClickListener(this);
        fragment1 = new WeiXinFragment();
        fragment2 = new FriendFragment();
        fragment3 = new DiscoverFragment();
        fragment4 = new MineFragment();
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        viewPager.setAdapter(new TabPagerAdapter(fm, list));
        viewPager.setOnPageChangeListener(this);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        setTabSelection(0);
        viewPager.setCurrentItem(0);
        registerForContextMenu(mine);
        //setOverflowShowingAlways();

        //setDefaultFragment();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        menu.add(0, 2, 0, "More").setIcon(R.drawable.alc);
        Log.e("11111111111", "11111111111");
//        MenuItem mi = menu.findItem(R.id.action_add);
//        mi.setSupportActionProvider(new MyActionProvider(MainActivity.this));
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 1, 0, "Menu1");
        menu.add(0, 2, 0, "Menu2");
        menu.add(0, 3, 0, "Menu3");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Intent intent = new Intent();
//            intent.setClass(MainActivity.this, AllActivity.class);
//            startActivity(intent);
//            Toast.makeText(this, "activity setting", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_weixin:
                setTabSelection(0);
                viewPager.setCurrentItem(0);
                break;
            case R.id.button_friend:
                setTabSelection(1);
                viewPager.setCurrentItem(1);
                break;
            case R.id.button_discover:
                setTabSelection(2);
                viewPager.setCurrentItem(2);
                break;
            case R.id.button_mine:
                setTabSelection(3);
                viewPager.setCurrentItem(3);
                break;
        }
    }

    public void setDefaultFragment() {
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        fragment1 = new Fragment1();
//        ft.replace(R.id.fragment1, fragment1);
//        ft.commit();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setTabSelection(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setTabSelection (int position) {
        clearSelection();
        switch(position) {
            case 0:
                image_weixin.setImageResource(R.drawable.weixin_clicked);
                text_weixin.setTextColor(0xFF66FF00);
                //weixin.setTextColor(Color.RED);
                break;
            case 1:
                image_friend.setImageResource(R.drawable.friend_clicked);
                text_friend.setTextColor(0xFF66FF00);
                break;
            case 2:
                image_discover.setImageResource(R.drawable.discover_clicked);
                text_discover.setTextColor(0xFF66FF00);
                break;
            case 3:
                image_mine.setImageResource(R.drawable.personal_clicked);
                text_mine.setTextColor(0xFF66FF00);
                break;

        }
    }

    public void clearSelection() {
        image_weixin.setImageResource(R.drawable.alc);
        text_weixin.setTextColor(Color.BLACK);
        image_friend.setImageResource(R.drawable.friend);
        text_friend.setTextColor(Color.BLACK);
        image_discover.setImageResource(R.drawable.discover);
        text_discover.setTextColor(Color.BLACK);
        image_mine.setImageResource(R.drawable.personal);
        text_mine.setTextColor(Color.BLACK);
    }

    private void setOverflowShowingAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    @Override
//    public boolean onMenuOpened(int featureId, Menu menu) {
//        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
//            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
//                //icon
//                try {
//                    Method m = menu.getClass().getDeclaredMethod(
//                            "setOptionalIconsVisible", Boolean.TYPE);
//                    m.setAccessible(true);
//                    m.invoke(menu, true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//        return super.onMenuOpened(featureId, menu);
//    }
}
