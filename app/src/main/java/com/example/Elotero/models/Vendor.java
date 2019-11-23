package com.example.Elotero.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Vendor {
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVendorCartName() {
        return vendorCartName;
    }

    public void setVendorCartName(String vendorCartName) {
        this.vendorCartName = vendorCartName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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
            this.email = vendorInfo.getString("email");
            this.phone = vendorInfo.getString("phone");
            this.firstName = vendorInfo.getString("firstName");
            this.lastName = vendorInfo.getString("lastName");
            this.vendorCartName = vendorInfo.getString("vendorCartName");
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

    public void addFields(JSONObject jsonObject, String field, String value) throws JSONException {
        value = jsonObject.getString("field");
    }

    public String toString(){
          return  this.uid + "\r\n" + this.firstName + "\r\n" + this.lastName + "\r\n" +
                        this.vendorCartName + "\r\n" + this.email  + "\r\n" +
                        this.phone + "\r\n";
    }
}
