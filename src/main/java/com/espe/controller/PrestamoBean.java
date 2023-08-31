package com.espe.controller;

import com.espe.dao.IPestamoDAO;
import com.espe.idao.PrestamoDAOImpl;
import com.espe.model.Prestamo;

import java.util.List;

public class PrestamoBean {
    private IPestamoDAO prestamoDAO;
    public PrestamoBean() {
        prestamoDAO = new PrestamoDAOImpl();
    }
    public List<Prestamo> getAllPrestamos() {
        return prestamoDAO.getAllPrestamos();
    }
}