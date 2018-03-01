
package com.taylor_johnson.realsocialnew.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OficinasResult {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("ciudad")
    @Expose
    private String ciudad;
    @SerializedName("coordenadas")
    @Expose
    private String coordenadas;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("empresa")
    @Expose
    private String empresa;
    @SerializedName("horario")
    @Expose
    private String horario;
    @SerializedName("imagen")
    @Expose
    private String imagen;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("tipo")
    @Expose
    private String tipo;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
