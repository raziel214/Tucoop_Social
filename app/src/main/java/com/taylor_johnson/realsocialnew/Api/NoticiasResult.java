
package com.taylor_johnson.realsocialnew.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NoticiasResult {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("activo")
    @Expose
    private String activo;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("empresa")
    @Expose
    private String empresa;
    @SerializedName("expiraDias")
    @Expose
    private String expiraDias;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("imagen")
    @Expose
    private String imagen;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("titulo")
    @Expose
    private String titulo;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getExpiraDias() {
        return expiraDias;
    }

    public void setExpiraDias(String expiraDias) {
        this.expiraDias = expiraDias;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
