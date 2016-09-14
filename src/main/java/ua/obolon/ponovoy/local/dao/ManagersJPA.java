/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.local.dao;

import javax.persistence.EntityManager;
import ua.obolon.ponovoy.local.entity.ManagersCalls;

/**
 *
 * @author Alexander
 */
public class ManagersJPA extends JPA_calls {

    public boolean getLogin(String username, String password) {
        EntityManager manager = getManager();
        try {
            ManagersCalls managersCalls = (ManagersCalls) manager.createQuery("SELECT m FROM ManagersCalls m WHERE m.username = :username AND m.password = :password")
                    .setParameter("username", username).setParameter("password", password).getSingleResult();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            manager.close();
        }
    }
}
