
package com.taylor_johnson.realsocialnew.Api;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SocialApiResponse {

    @SerializedName("redesSocialesResult")
    @Expose
    private List<RedesSocialesResult> redesSocialesResult = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SocialApiResponse() {
    }

    /**
     * 
     * @param redesSocialesResult
     */
    public SocialApiResponse(List<RedesSocialesResult> redesSocialesResult) {
        super();
        this.redesSocialesResult = redesSocialesResult;
    }

    public List<RedesSocialesResult> getRedesSocialesResult()
    {
        return redesSocialesResult;
    }

    public void setRedesSocialesResult(List<RedesSocialesResult> redesSocialesResult) {
        this.redesSocialesResult = redesSocialesResult;
    }

}
