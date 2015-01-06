package com.kerboocorp.blop.managers;

import com.kerboocorp.blop.model.User;

/**
 * Created by cgo on 6/01/2015.
 */
public interface UserManager {

    public boolean isUserConnected();
    public User findUser();
    public void saveUser(User user);
    public void deleteUser();
}
