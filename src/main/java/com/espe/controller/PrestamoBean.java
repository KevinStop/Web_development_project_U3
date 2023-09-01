package com.espe.controller;

import com.espe.dao.IPestamoDAO;
import com.espe.idao.PrestamoDAOImpl;
import com.espe.model.Prestamo;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestScoped
@Named
public class PrestamoBean {
    IPestamoDAO prestamoDAO = new PrestamoDAOImpl();

    public List<Prestamo> obtenerPrestamos(){

        /*List<Prestamo> listaPrestamos = new ArrayList<>();
        Prestamo p1 = new Prestamo();
        p1.setId(1);
        p1.setUsuarioId(1);
        p1.setLibroId(1);
        p1.setFechaPrestamo(Date.valueOf("2023-07-17"));
        p1.setFechaDevolucion(Date.valueOf("2023-07-24"));

        listaPrestamos.add(p1);

        return listaPrestamos;*/

        return prestamoDAO.obtenerPrestamos();
    }

    public String editarPrestamos(int id){
        Prestamo oPrestamo;
        oPrestamo = prestamoDAO.buscarPrestamos(id);
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("Prestamos", oPrestamo);
        System.out.println(oPrestamo);
        return "/Prestamo/Editar.xhtml";
    }
}