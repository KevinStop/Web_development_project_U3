package com.espe.idao;

import com.espe.dao.ILibroDAO;
import com.espe.model.JPAUtil;
import com.espe.model.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class LibroDAOImpl implements ILibroDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void guardar(Libro libro) {
        entityManager.getTransaction().begin();
        entityManager.persist(libro);
        entityManager.getTransaction().commit();
        // No need to call JPAUtil.shutdown() anymore, as EntityManager is closed automatically
    }

    @Override
    public void editar(Libro libro) {
        entityManager.getTransaction().begin();
        entityManager.merge(libro);
        entityManager.getTransaction().commit();
    }

    @Override
    public Libro buscar(int id) {
        Libro oLibro = new Libro();
        oLibro = entityManager.find(Libro.class, id);
        return oLibro;
    }

    @Override
    public List<Libro> obtenerLibros() {
        List<Libro> listaLibros;
        // JPQL statement
        Query query = entityManager.createQuery("SELECT l FROM Libro l");
        listaLibros = query.getResultList();
        return listaLibros;
    }

    @Override
    public void eliminar(int id) {
        Libro oLibro = new Libro();
        oLibro = entityManager.find(Libro.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(oLibro);
        entityManager.getTransaction().commit();
    }
}

