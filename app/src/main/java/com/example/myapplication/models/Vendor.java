package com.example.myapplication.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Vendor {
    private String uid;
    private String firstName;
    private String lastName;
    private String vendorName;
    private String password;
    private String email;

    public Vendor(JSONObject vendorInfo) throws JSONException {
        try{
            this.uid = vendorInfo.getString("uid");
            this.firstName = vendorInfo.getString("firstName");
            this.lastName = vendorInfo.getString("lastName");
            this.password = vendorInfo.getString("password");
            this.email = vendorInfo.getString("email");
        } catch (JSONException e){
            e.printStackTrace();
        }
    }




}
