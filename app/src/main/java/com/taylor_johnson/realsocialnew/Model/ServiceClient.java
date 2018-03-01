package com.taylor_johnson.realsocialnew.Model;



/**
 * Created by desarrolladorjf on 27/02/2017.
 */

public class ServiceClient  {
    //public String descripcion;
    //public String activo;
    public String ciudad;
    public String coordenadas;
    public String direccion;
    public String empresa;
    public String horario;
    public int id;
    public String imagen;
    public String nombre;
    public String tipo;
    public String telefono;



    public ServiceClient(Integer id, String coordenadas, String imagen, String horario, String ciudad, String nombre, String telefono, String tipo, String nombre1, String direccion) {

        this.ciudad = ciudad;
        this.coordenadas = coordenadas;
        this.direccion = direccion;
        this.empresa = empresa;
        this.horario = horario;
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.tipo = tipo;
        this.telefono = telefono;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ServiceClient() {

    }
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo1) {
        this.tipo = tipo1;
    }
}
