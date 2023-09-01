package com.espe.controller;

import com.espe.dao.ILibroDAO;
import com.espe.idao.LibroDAOImpl;
import com.espe.model.Libro;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;


import java.util.List;
import java.util.Map;

@RequestScoped
@Named
public class LibroBean {

    ILibroDAO libroDAO = new LibroDAOImpl();

    public List<Libro> obtenerLibros() {
        return libroDAO.obtenerLibros();
    }

    public String editar(int id) {
        Libro oLibro;
        oLibro = libroDAO.buscar(id);

        // Create a session map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        // Pass the object through the SessionMap to the view
        sessionMap.put("libro", oLibro);
        System.out.println(oLibro);
        return "/Libro/Editar.xhtml";
    }

    public String actualizar(Libro libro) {
        libroDAO.editar(libro);
        return "/Libro/Admin.xhtml";
    }

    public String eliminar(int id) {
        libroDAO.eliminar(id);
        return "/Libro/Admin.xhtml";
    }

    public String nuevo() {
        Libro oLibro = new Libro();

        // Create a session map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        // Pass the object through the SessionMap to the view
        sessionMap.put("libro", oLibro);
        return "/Libro/Nuevo.xhtml";
    }

    public String guardar(Libro libro) {
        libroDAO.guardar(libro);
        return "/Libro/Admin.xhtml";
    }
}

