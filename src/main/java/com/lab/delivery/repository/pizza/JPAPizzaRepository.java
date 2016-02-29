package com.lab.delivery.repository.pizza;

import com.lab.delivery.domain.Pizza;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mantixop on 2/16/16.
 */
@Repository
public class JPAPizzaRepository implements PizzaRepository {

    @PersistenceContext
    EntityManager em;

    public Pizza findById(Integer id) {
        return em.find(Pizza.class, id);
    }

    public List getAll() {
        return em.createQuery("select pizza from Pizza pizza").getResultList();
    }

    public Pizza save(Pizza pizza) {
        if(pizza.getId() == null) {
            em.persist(pizza);
        } else {
            em.merge(pizza);
        }
        return pizza;
    }
}
