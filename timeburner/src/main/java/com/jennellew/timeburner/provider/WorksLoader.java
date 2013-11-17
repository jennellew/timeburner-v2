package com.jennellew.timeburner.provider;

import android.content.Context;
import android.util.Log;

import com.jennellew.timeburner.models.Works;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwong on 11/16/13.
 */
public class WorksLoader extends HTTPAsyncLoader<Works> {

    private final String TAG = WorksLoader.class.getSimpleName();
    private String mQuery;
    private Works mData;

    public WorksLoader(Context context, String url, String query) {
        super(context, url);
        mQuery = query;
    }

    @Override
    protected List<Works> loadResults() {
        Elements links = mDocument.select("a[href*=" + mQuery + "]");
        for (Element text : links) {
            mData = new Works(text.ownText(),
                    text.select("span[class]").text(),
                    text.attr("href"));
            results.add(mData);
        }

        Log.d(TAG, mData.getTitle() + mData.getNoOfStories() + mData.getLink());
        return results;
    }
}
