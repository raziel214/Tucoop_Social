
package com.taylor_johnson.realsocialnew.Api;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OptionsApiResponse {

    @SerializedName("opcionesResult")
    @Expose
    private List<OpcionesResult> opcionesResult = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OptionsApiResponse() {
    }

    /**
     * 
     * @param opcionesResult
     */
    public OptionsApiResponse(List<OpcionesResult> opcionesResult) {
        super();
        this.opcionesResult = opcionesResult;
    }

    public List<OpcionesResult> getOpcionesResult() {
        return opcionesResult;
    }

    public void setOpcionesResult(List<OpcionesResult> opcionesResult) {
        this.opcionesResult = opcionesResult;
    }

}
