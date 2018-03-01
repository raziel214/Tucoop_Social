package com.taylor_johnson.realsocialnew.Model.Office;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by desarrolladorjf on 27/02/2017.
 */

public class ServiceClient implements Serializable {
    private int ServiceClient;
    private int ID;
    private String city;
    private String coordinate;
    private String address;
    private String company;
    private String schedule;
    private String image;
    private String name;
    private String telephone;
    private String type;
    private int ID_list;



    public ServiceClient(int guilin) {

    }

    public int getServiceClient() {
        return ServiceClient;
    }

    public void setServiceClient(int ServiceClient) {
        ServiceClient = ServiceClient;
    }

    public ServiceClient(int ID, String city, String coordinate, String address, String company, String schedule, String image, String name, String telephone, String type, int ID_list) {
        this.ID = ID;
        this.city = city;
        this.coordinate = coordinate;
        this.address = address;
        this.company = company;
        this.schedule = schedule;
        this.image = image;
        this.name = name;
        this.telephone = telephone;
        this.type = type;
        this.ID_list = ID_list;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getID_list() {
        return ID_list;
    }

    public void setID_list(int ID_list) {
        this.ID_list = ID_list;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



}
