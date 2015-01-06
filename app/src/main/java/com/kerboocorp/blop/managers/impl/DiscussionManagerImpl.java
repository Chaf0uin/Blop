package com.kerboocorp.blop.managers.impl;

import com.kerboocorp.blop.managers.DiscussionManager;
import com.kerboocorp.blop.model.Discussion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgo on 6/01/2015.
 */
public class DiscussionManagerImpl implements DiscussionManager {

    private static DiscussionManagerImpl instance = new DiscussionManagerImpl();

    private DiscussionManagerImpl() {}

    public static DiscussionManager getInstance() {
        return instance;
    }

    @Override
    public List<Discussion> findDiscussionListByUser(String apiKey) {
        return new ArrayList<Discussion>();
    }
}
