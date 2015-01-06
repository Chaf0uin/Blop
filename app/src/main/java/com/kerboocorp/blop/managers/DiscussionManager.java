package com.kerboocorp.blop.managers;

import com.kerboocorp.blop.model.Discussion;

import java.util.List;

/**
 * Created by cgo on 6/01/2015.
 */
public interface DiscussionManager {

    public List<Discussion> findDiscussionListByUser(String apiKey);

}
