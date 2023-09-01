package com.espe.dao;

import com.espe.model.Prestamo;

import java.util.List;

public interface IPestamoDAO {

    void editar(Prestamo prestamo);

    Prestamo buscarPrestamos(int id);

    List<Prestamo> obtenerPrestamo();
}