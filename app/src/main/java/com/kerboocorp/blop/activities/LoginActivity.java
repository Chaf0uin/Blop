package com.kerboocorp.blop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kerboocorp.blop.R;
import com.kerboocorp.blop.managers.impl.UserManagerImpl;
import com.kerboocorp.blop.model.User;

/**
 * Created by cgo on 6/01/2015.
 */
public class LoginActivity extends ActionBarActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button connectButton;

    private UserManagerImpl userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userManager = new UserManagerImpl(this);

        if (isUserConnected()) {
            startActivity(new Intent(this, MainActivity.class));
        } else {

            emailEditText = (EditText) findViewById(R.id.emailEditText);
            passwordEditText = (EditText) findViewById(R.id.passwordEditText);
            connectButton = (Button) findViewById(R.id.connectButton);

            connectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    connectUser();
                }
            });
        }

    }


    private boolean isUserConnected() {
        return userManager.isUserConnected();
    }

    private void connectUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("Lala");
        user.setEmail(emailEditText.getText().toString());
        userManager.saveUser(user);

        startActivity(new Intent(this, MainActivity.class));
    }

}
