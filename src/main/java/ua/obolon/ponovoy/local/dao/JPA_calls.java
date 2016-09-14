/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.local.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alexander
 */
public class JPA_calls {
private EntityManagerFactory factory;

    public JPA_calls() {
        this.factory = Persistence.createEntityManagerFactory("Calls_PU");
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public EntityManager getManager() {
        return factory.createEntityManager();
    }

    public void refresh() {
        factory.getCache().evictAll();
    }
}
