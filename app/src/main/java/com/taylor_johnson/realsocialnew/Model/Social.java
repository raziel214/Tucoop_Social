package com.taylor_johnson.realsocialnew.Model;

/**
 * Created by desarrolladorjf on 27/02/2017.
 */

public class Social {

    private int Social;
    public int ID;
    private int picture;
    public String code;
    public String name;
    public String Uri;


    public Social(int social, String code, String name) {
        Social = social;
        this.ID = ID;
        this.picture = picture;
        this.code = code;
        this.name = name;
    }

    public Social(String uri) {
        Uri = uri;
    }

    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }

    public int getSocial() {
        return Social;
    }

    public void setSocial(int social) {
        Social = social;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
