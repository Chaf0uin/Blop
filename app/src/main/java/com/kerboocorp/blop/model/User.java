package com.kerboocorp.blop.model;

/**
 * Created by cgo on 6/01/2015.
 */
public class User extends BaseModel {

    private String username;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
