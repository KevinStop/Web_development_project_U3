package com.espe.idao;

import com.espe.dao.IPestamoDAO;
import com.espe.model.JPAUtil;
import com.espe.model.Prestamo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class PrestamoDAOImpl implements IPestamoDAO {

    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public Prestamo buscarPrestamos(int id) {
        Prestamo oPrestamo = new Prestamo();
        oPrestamo = entityManager.find(Prestamo.class, id);
        return oPrestamo;
    }

    @Override
    public List<Prestamo> obtenerPrestamo() {
        List<Prestamo> listaPrestamos;
        Query query = entityManager.createQuery("SELECT P FROM Prestamo P");
        listaPrestamos = query.getResultList();
        return listaPrestamos;
    }

    @Override
    public void editar(Prestamo prestamo) {
        entityManager.getTransaction().begin();
        entityManager.merge(prestamo);
        entityManager.getTransaction().commit();
    }
}