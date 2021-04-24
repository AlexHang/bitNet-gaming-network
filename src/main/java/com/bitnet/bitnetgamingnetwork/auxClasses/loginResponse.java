package com.bitnet.bitnetgamingnetwork.auxClasses;

public class loginResponse {
    private int UserID;
    private boolean status;
    public loginResponse(int id, boolean status){
        this.UserID =id;
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public int getUserID() {
        return UserID;
    }
}
