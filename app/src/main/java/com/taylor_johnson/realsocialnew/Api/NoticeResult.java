package com.taylor_johnson.realsocialnew.Api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by desarrolladorjf on 08/03/2017.
 */

public class NoticeResult {

    @SerializedName(value = "noticeresult")
    public List<NoticeResult> noticeresult;

    public String toString(){return("OK");}
}
