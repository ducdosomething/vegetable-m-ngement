package org.example.springjpahibernatevegetablelist.repository;

import org.example.springjpahibernatevegetablelist.model.Vegetable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class VegetableRepository implements IVegetableRepository {


    public static final String SELECT_ALL_VEGETABLE_C = "select c from Vegetable c";
    public static final String SELECT_VEGETABLE_BY_ID = "select c from Vegetable c where c.id=:id";
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Vegetable> findAll() {
        TypedQuery<Vegetable> query = entityManager.createQuery(SELECT_ALL_VEGETABLE_C, Vegetable.class);
        return query.getResultList();
    }

    @Override
    public Vegetable findById(Long id) {
        TypedQuery<Vegetable> query = entityManager.createQuery(SELECT_VEGETABLE_BY_ID, Vegetable.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Vegetable vegetable) {
        if (vegetable.getId() != null) {
            entityManager.merge(vegetable);
        } else {
            entityManager.persist(vegetable);
        }
    }

    @Override
    public void remove(Long id) {
        Vegetable vegetable = findById(id);
        if (vegetable != null) {
            entityManager.remove(vegetable);
        }
    }
}
