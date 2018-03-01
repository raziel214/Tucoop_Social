
package com.taylor_johnson.realsocialnew.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RedesSocialesResult {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("imagen")
    @Expose
    private String imagen;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RedesSocialesResult() {
    }

    /**
     * 
     * @param nombre
     * @param imagen
     * @param link
     * @param iD
     */
    public RedesSocialesResult(Integer iD, String imagen, String link, String nombre) {
        super();
        this.iD = iD;
        this.imagen = imagen;
        this.link = link;
        this.nombre = nombre;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
