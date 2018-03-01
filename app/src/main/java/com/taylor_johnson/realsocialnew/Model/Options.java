package com.taylor_johnson.realsocialnew.Model;

/**
 * Created by desarrolladorjf on 10/03/2017.
 */

public class Options  {


    public int ID;
    private int picture;
    public String code;
    public String name;

    public Options(int ID, String code, String name) {
        this.ID = ID;
        this.code = code;
        this.name = name;
        this.picture=picture;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
