package com.espe.dao;

import com.espe.model.Prestamo;
import com.espe.model.Usuario;

import java.util.List;

public interface IPestamoDAO {

    void guardar(Prestamo prestamo);
    void editar(Prestamo prestamo);
    List<Prestamo> obtenerPrestamo();
    Prestamo buscar(int id);
    void eliminar(int id);
}