package com.espe.idao;

import com.espe.dao.IPestamoDAO;
import com.espe.model.JPAUtil;
import com.espe.model.Libro;
import com.espe.model.Prestamo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class PrestamoDAOImpl implements IPestamoDAO {

    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public Prestamo buscar(int id) {
        Prestamo oPrestamo = entityManager.find(Prestamo.class, id);
        return oPrestamo;
    }

    @Override
    public List<Prestamo> obtenerPrestamo() {
        List<Prestamo> listaPrestamos;
        Query query = entityManager.createQuery("SELECT p FROM Prestamo p");
        listaPrestamos = query.getResultList();
        return listaPrestamos;
    }

    @Override
    public void editar(Prestamo prestamo) {
        entityManager.getTransaction().begin();
        entityManager.merge(prestamo);
        entityManager.getTransaction().commit();
    }

    @Override
    public void guardar(Prestamo prestamo) {
        entityManager.getTransaction().begin();
        entityManager.persist(prestamo);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        Prestamo oPrestamo = buscar(id);
        if (oPrestamo != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(oPrestamo);
            entityManager.getTransaction().commit();
        }
    }
}
