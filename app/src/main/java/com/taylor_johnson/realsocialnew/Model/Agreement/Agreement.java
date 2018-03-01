package com.taylor_johnson.realsocialnew.Model.Agreement;

/**
 * Created by desarrolladorjf on 22/02/2017.
 */

public class Agreement {

    /*esta variable sera usada por el recyclerview de los convenios llamado
    * agreement para la presentacion de todos los convenios*/
    private int Agreement;
    public int ID;
    private int picture;
    public String code;
    public String name;
    //public String Uri;

    public Agreement(int agreement, String code, String name) {
        Agreement = agreement;
        this.ID = ID;
        this.picture = picture;
        this.code = code;
        this.name = name;

    }

    public int getAgreement() {
        return Agreement;
    }

    public void setAgreement(int agreement) {
        Agreement = agreement;
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
