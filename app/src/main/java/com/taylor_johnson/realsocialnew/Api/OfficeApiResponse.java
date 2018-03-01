
package com.taylor_johnson.realsocialnew.Api;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OfficeApiResponse {

    @SerializedName("oficinasResult")
    @Expose
    private List<OficinasResult> oficinasResult = null;

    public List<OficinasResult> getOficinasResult() {
        return oficinasResult;
    }

    public void setOficinasResult(List<OficinasResult> oficinasResult) {
        this.oficinasResult = oficinasResult;
    }

}
