
package com.taylor_johnson.realsocialnew.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpcionesResult {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpcionesResult() {

    }

    /**
     * 
     * @param nombre
     * @param codigo
     * @param iD
     */
    public OpcionesResult(Integer iD, String codigo, String nombre) {
        super();
        this.iD = iD;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
