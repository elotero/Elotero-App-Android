package com.example.Elotero.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.Elotero.R;
import com.example.Elotero.Utils.FirebaseManager;
import com.example.Elotero.Utils.Globals;
import com.example.Elotero.models.Vendor;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
    }


    @Override
    protected void onStart(){
        super.onStart();

        FirebaseManager dbManager = new FirebaseManager();
        Button RegisterButton = (Button)findViewById(R.id.authButton);
        RegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RegisterScreen.this, MapsActivity.class);
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                try {
                    JSONObject vendorInfo = convertViewsToStrings();
                    System.out.println("vendor info: " + vendorInfo);
                    vendorInfo.put(Globals.uid, uid);
                    Vendor vendor = new Vendor(vendorInfo);
                    dbManager.addVendor(vendor);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JSONObject convertViewsToStrings() throws JSONException {
        JSONObject vendorInfo = new JSONObject();
        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText email = (EditText) findViewById(R.id.emailAddress);
        EditText phone = (EditText) findViewById(R.id.phoneNum);
        EditText vendorCartName = (EditText) findViewById(R.id.vendorCartName);
        EditText lastName = (EditText) findViewById(R.id.lastName);


        String str_first_name = firstName.getText().toString();
        String str_last_name  = lastName.getText().toString();
        String str_email = email.getText().toString();
        String str_phone = phone.getText().toString();
        String str_vendorCartName = vendorCartName.getText().toString();

        vendorInfo.put(Globals.firstName, str_first_name);
        vendorInfo.put(Globals.lastName, str_last_name);
        vendorInfo.put(Globals.email, str_email);
        vendorInfo.put(Globals.phone, str_phone);
        vendorInfo.put(Globals.vendorCartName, str_vendorCartName);
        return vendorInfo;
    }
}
