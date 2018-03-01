
package com.taylor_johnson.realsocialnew.Api;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NoticeApiResponse {

    @SerializedName("noticiasResult")
    @Expose
    private List<NoticiasResult> noticiasResult = null;

    public List<NoticiasResult> getNoticiasResult() {
        return noticiasResult;
    }

    public void setNoticiasResult(List<NoticiasResult> noticiasResult) {
        this.noticiasResult = noticiasResult;
    }

}
