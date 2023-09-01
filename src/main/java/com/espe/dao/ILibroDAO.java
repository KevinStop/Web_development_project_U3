package com.espe.dao;

import com.espe.model.Libro;

import java.util.List;

public interface ILibroDAO {

    void guardar(Libro libro);
    void editar(Libro libro);
    Libro buscar(int id);
    List<Libro> obtenerLibros();
    void eliminar(int id);

}
