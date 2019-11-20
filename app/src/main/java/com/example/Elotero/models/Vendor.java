package com.example.Elotero.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Vendor {
    private String uid;
    private String firstName;
    private String lastName;
    private String vendorCartName;
    private String email;
    private String phone;

    public Vendor(){
        //default constructor::
    }
    public Vendor(String firstName, String lastName, String vendorCartName, String email, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.vendorCartName = vendorCartName;
        this.email = email;
        this.phone = phone;
    }


    public Vendor(JSONObject vendorInfo) throws JSONException {
        try{
            checkNull(vendorInfo, "uid", this.uid);
            checkNull(vendorInfo, "firstName", this.firstName);
            checkNull(vendorInfo, "lastName", this.lastName);
            checkNull(vendorInfo, "email", this.email);
            checkNull(vendorInfo, "phone", this.phone);
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("uid", this.uid);
        jo.put("firstName", this.firstName);
        jo.put("lastName", this.lastName);
        jo.put("vendorCartName", this.vendorCartName);
        jo.put("email", this.email);
        jo.put("phone", this.phone);
        return jo;
    }

    public void checkNull(JSONObject jsonObject, String field, String value) throws JSONException {
        if(jsonObject.isNull(field)){
            value = "";
        } else {
            value = jsonObject.getString(field);
        }
    }

    public void setUid(String uid){
        this.uid = uid;
    }
}
