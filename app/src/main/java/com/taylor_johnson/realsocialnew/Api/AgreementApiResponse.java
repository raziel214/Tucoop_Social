
package com.taylor_johnson.realsocialnew.Api;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgreementApiResponse {

    @SerializedName("conveniosResult")
    @Expose
    private List<ConveniosResult> conveniosResult = null;

    public List<ConveniosResult> getConveniosResult() {
        return conveniosResult;
    }

    public void setConveniosResult(List<ConveniosResult> conveniosResult) {
        this.conveniosResult = conveniosResult;
    }

}
