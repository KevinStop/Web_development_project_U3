package com.espe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id_usu;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String password_usu;
    @Column
    private String correo;
    @Column
    private String telefono;
    @Column
    private String direccion;
    @Column
    private Integer id_rol;

    public Integer getId_usu() {
        return id_usu;
    }

    public void setId_usu(Integer id_usu) {
        this.id_usu = id_usu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword_usu() {
        return password_usu;
    }

    public void setPassword_usu(String password_usu) {
        this.password_usu = password_usu;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usu=" + id_usu +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", password_usu='" + password_usu + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", id_rol=" + id_rol +
                '}';
    }
}
