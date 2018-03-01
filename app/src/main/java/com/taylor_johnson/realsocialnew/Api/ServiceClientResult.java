package com.taylor_johnson.realsocialnew.Api;

import com.taylor_johnson.realsocialnew.Model.ServiceClient;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by desarrolladorjf on 08/03/2017.
 */

public class ServiceClientResult implements Serializable {

    //@SerializedName(value="serviceclientresult")

    ArrayList<ServiceClient> postList = new ArrayList<>();


    public void setServicetList(ArrayList<ServiceClient> postList) {
        this.postList = postList;
    }

    public ArrayList<ServiceClient> getpostList() {
        return postList;
    }






}
