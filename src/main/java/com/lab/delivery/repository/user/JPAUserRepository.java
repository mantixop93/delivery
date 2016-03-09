package com.lab.delivery.repository.user;

import com.lab.delivery.domain.user.Role;
import com.lab.delivery.domain.user.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mantixop on 3/2/16.
 */
@Repository
public class JPAUserRepository implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public User save(User user) {
        if(user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        List<User> list = em.createQuery("SELECT t FROM User t where t.email = :email")
                .setParameter("email", email).getResultList();
        if  (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public Role findRoleByName(String name) {
        List<Role> list = em.createQuery("SELECT t FROM Role t where t.name = :name1")
                .setParameter("name1", name).getResultList();
        if  (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT t FROM User t ").getResultList();
    }
}
