package edu.albany.se.app.repository;

import edu.albany.se.app.model.Country;
import edu.albany.se.app.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CountryRepository
{

    public void update(Country country)
    {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(country);
        entityManager.getTransaction().commit();
    }

    public static Country getCountry(int id){
        EntityManager entityManager = PersistenceUtil.getEntityManager();

        Query query = entityManager.createQuery("FROM Country WHERE id=:id")
                .setParameter("id", id);
        List<Country> result = query.getResultList();

        return result.size() > 0 ? result.get(0) : null;
    }
}
