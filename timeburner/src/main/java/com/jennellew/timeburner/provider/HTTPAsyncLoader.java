package com.jennellew.timeburner.provider;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwong on 11/16/13.
 * Generic loader for grabbing data
 * @param <T1> item type
 */
public abstract class HTTPAsyncLoader<T1> extends AsyncTaskLoader {

    private final static int TIMEOUT_PERIOD = 100000;
    private final static String TAG = HTTPAsyncLoader.class.getSimpleName();

    protected List<T1> results;
    protected Document mDocument;
    private String mUrl;
    //private ArrayList<T1> results;

    public HTTPAsyncLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<T1> loadInBackground() {
        results = new ArrayList<T1>();
        try {
            mDocument = Jsoup.connect(mUrl).timeout(TIMEOUT_PERIOD).get();
            results = loadResults();
        } catch (IOException e) {
            Log.d(TAG, "Problem retrieving results- connection failed or timed out.");
        }
        return results;
    }

    protected abstract List<T1> loadResults();
}
