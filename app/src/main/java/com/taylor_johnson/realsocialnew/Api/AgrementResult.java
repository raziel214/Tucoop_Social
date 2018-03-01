package com.taylor_johnson.realsocialnew.Api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by desarrolladorjf on 10/03/2017.
 */

public class AgrementResult {


    @SerializedName(value = "agreementResult")
    public List<AgrementResult> agreementResult;

    public String toString(){
        return("OK");}
}
