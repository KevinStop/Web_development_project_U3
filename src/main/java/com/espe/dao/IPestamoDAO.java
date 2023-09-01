package com.espe.dao;

import com.espe.model.Prestamo;

import java.util.List;

public interface IPestamoDAO {
    List<Prestamo> obtenerPrestamos();

    Prestamo buscarPrestamos(int id);

    void editarPrestamos(Prestamo prestamo);
}