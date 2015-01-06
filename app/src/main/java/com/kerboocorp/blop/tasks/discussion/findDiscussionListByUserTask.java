package com.kerboocorp.blop.tasks.discussion;

import android.os.AsyncTask;

import com.kerboocorp.blop.managers.impl.DiscussionManagerImpl;
import com.kerboocorp.blop.model.Discussion;
import com.kerboocorp.blop.observers.discussion.FindDiscussionListByUserObserver;
import com.kerboocorp.blop.utilities.AsyncTaskResult;

import java.util.List;

/**
 * Created by cgo on 6/01/2015.
 */
public class findDiscussionListByUserTask extends AsyncTask<Object,String,AsyncTaskResult<List<Discussion>>> {

    private String apiKey;
    private FindDiscussionListByUserObserver observer;

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setObserver(FindDiscussionListByUserObserver observer) {
        this.observer = observer;
    }

    @Override
    protected AsyncTaskResult<List<Discussion>> doInBackground(Object... params) {
        return new AsyncTaskResult<List<Discussion>>(DiscussionManagerImpl.getInstance().findDiscussionListByUser(apiKey));
    }

    protected void onPostExecute(AsyncTaskResult<List<Discussion>> result) {

        if (result.getError() != null) {

        } else if (isCancelled()) {
            // cancel handling here
        } else {

            observer.onDiscussionListFound(result.getResult());
        }
    }

}
