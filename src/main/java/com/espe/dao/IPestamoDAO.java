package com.espe.dao;

import com.espe.model.Prestamo;

import java.util.List;

public interface IPestamoDAO {
    List<Prestamo> getAllPrestamos();

    Prestamo getPrestamoById(int id);

    void addPrestamo(Prestamo prestamo);

    void updatePrestamo(Prestamo prestamo);

    void deletePrestamo(int id);
}