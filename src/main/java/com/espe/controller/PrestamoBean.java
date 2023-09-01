package com.espe.controller;

import com.espe.dao.IPestamoDAO;
import com.espe.idao.PrestamoDAOImpl;
import com.espe.model.Libro;
import com.espe.model.Prestamo;
import com.espe.model.Usuario;
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

    public String editar(int id){
        Prestamo oPrestamo;
        oPrestamo = prestamoDAO.buscar(id);

        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        sessionMap.put("prestamo", oPrestamo);
        System.out.println(oPrestamo);
        return "/Prestamo/Editar.xhtml";
    }
    public String actualizar(Prestamo prestamo) {
        prestamoDAO.editar(prestamo);
        return "/Prestamo/Prestamo.xhtml";
    }

    public String eliminar(int id){
        prestamoDAO.eliminar(id);
        return "/Prestamo/Prestamo.xhtml";
    }

    public String nuevo(){
        Prestamo oPrestamo = new Prestamo();
        //crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("prestamo", oPrestamo);
        System.out.println(oPrestamo);
        return "/Prestamo/Nuevo.xhtml";
    }

    public String guardar(Prestamo prestamo){
        prestamoDAO.guardar(prestamo);
        return "/Prestamo/Prestamo.xhtml";
    }

    public String prestamo(){
        return "/Prestamo/Prestamo.xhtml";
    }
}