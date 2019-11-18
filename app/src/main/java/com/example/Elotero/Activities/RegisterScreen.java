package com.example.Elotero.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Elotero.R;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
    }

    @Override
    public void onStart() {
        super.onStart();

        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());



        Button auth_button = (Button)findViewById(R.id.authButton);
        auth_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(providers)
                                .build(),
                        Globals.RC_SIGN_IN);
            }
        });






    }
}
