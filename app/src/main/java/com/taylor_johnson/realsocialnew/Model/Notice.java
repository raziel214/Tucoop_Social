package com.taylor_johnson.realsocialnew.Model;

/**
 * Created by desarrolladorjf on 24/02/2017.
 */

public class Notice {

     /*esta variable sera usada por el recyclerview de los convenios llamado
    * agreement para la presentacion de todos las noticias  se debe cambiar a string cuando se llame desde los web services*/

    public String descripcion;
    public int ID;
    public String activo;
    public String empresa;
    public String expiraDias;
    public String fecha;
    public String imagen;
    public String titulo;
    public String link;


    public Notice(int ID, String activo, String empresa, String expiraDias) {
        this.descripcion = descripcion;
        this.ID = ID;
        this.activo = activo;
        this.empresa = empresa;
        this.expiraDias = expiraDias;
        this.fecha = fecha;
        this.imagen = imagen;
        this.titulo = titulo;
        this.link = link;
        //Notice = notice;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private int Notice;

    public Notice(int notice) {
        Notice = notice;
    }

    public int getNotice() {
        return Notice;
    }

    public void setNotice(int notice) {
        Notice = notice;
    }
}
