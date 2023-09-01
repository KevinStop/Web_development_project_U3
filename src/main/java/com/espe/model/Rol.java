package com.espe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @Column
    private String rol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                '}';
    }
}
