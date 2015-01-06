package com.kerboocorp.blop.observers.discussion;

import com.kerboocorp.blop.model.Discussion;

import java.util.List;

/**
 * Created by cgo on 6/01/2015.
 */
public interface FindDiscussionListByUserObserver {

    public void onDiscussionListFound(List<Discussion> discussionList);
}
