package com.jennellew.timeburner.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jennellew.timeburner.R;
import com.jennellew.timeburner.fragments.BrowseFragment;

public class BaseActivity extends ActionBarActivity {

    protected DrawerLayout mDrawerLayout;
    protected ListView mDrawerList;
    protected ActionBarDrawerToggle mDrawerToggle;
    protected ActionBar mActionBar;
    protected FragmentManager mFragmentManager;
    ArrayAdapter<String> navItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_activity);

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        navItems = new ArrayAdapter<String>(this, R.layout.drawer_item,
                getResources().getStringArray(R.array.drawer_items));
        mDrawerList.setAdapter(navItems);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        Fragment mFragment;
        switch (position) {
            case 1:
                mFragment = BrowseFragment.newInstance();
                break;
            default:
                Log.d("Navigation Drawer", "Selection not yet implemented");
                return;
        }
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .replace(R.id.content_frame, mFragment)
                .commit();
        mDrawerList.setItemChecked(position, true);
        //setTitle(mFragment.TAG);
        mDrawerLayout.closeDrawer(mDrawerList);
    }
}
