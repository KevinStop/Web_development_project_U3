package com.espe.controller;

import com.espe.dao.IPestamoDAO;
import com.espe.idao.PrestamoDAOImpl;
import com.espe.model.Libro;
import com.espe.model.Prestamo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;

@RequestScoped
@Named
public class PrestamoBean {
    IPestamoDAO prestamoDAO = new PrestamoDAOImpl();

    public List<Prestamo> obtenerPrestamo(){return prestamoDAO.obtenerPrestamo();}

    public String editarPrestamo(int id){
        Prestamo oPrestamo;
        oPrestamo = prestamoDAO.buscarPrestamos(id);

        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        sessionMap.put("Prestamo", oPrestamo);
        System.out.println(oPrestamo);
        return "/Prestamo/Editar.xhtml";
    }
    public String actualizar(Prestamo prestamo) {
        prestamoDAO.editar(prestamo);
        return "/Prestamo/Prestamo.xhtml";
    }
}