package com.example.Elotero.Utils;

import com.example.Elotero.models.Vendor;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
public class FirebaseManager {
    private DatabaseReference dbRef;
    public FirebaseManager(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        dbRef = database.getReference();
    }

    public void addVendor(Vendor vendor) throws JSONException {
        dbRef = FirebaseDatabase.getInstance().getReference("vendors");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        vendor.setUid(user.getUid());
        dbRef.child(vendor.getUid()).setValue(vendor);
    }
    public void removeVendor(Vendor vendor){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        dbRef.child("vendors").child(user.getUid()).removeValue();
    }
    public void removeAllVendors(Vendor vendor){
        dbRef.child("vendors").removeValue();
    }
}
