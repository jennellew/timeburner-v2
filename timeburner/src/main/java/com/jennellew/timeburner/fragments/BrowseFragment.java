package com.jennellew.timeburner.fragments;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jennellew.timeburner.R;
import com.jennellew.timeburner.activity.BrowseActivity;

/**
 * Created by jwong on 11/11/13.
 */
public class BrowseFragment extends Fragment implements ListView.OnItemClickListener {

    private ListView mListView;
    static String TAG = "Browse";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mListView = (ListView)inflater.inflate(R.layout.category_fragment, container, false);
        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.browse_categories)));
        mListView.setOnItemClickListener(this);
        return mListView;
    }

    public static BrowseFragment newInstance() {
        BrowseFragment fragment = new BrowseFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_USER_ID, userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), BrowseActivity.class);
        startActivity(intent);

    }
}
