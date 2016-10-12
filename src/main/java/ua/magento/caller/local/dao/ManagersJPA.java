/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.magento.caller.local.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import ua.magento.caller.interfaces.User;
import ua.magento.caller.local.entity.CallRecriverCalls;
import ua.magento.caller.local.entity.ManagersCalls;
import ua.magento.caller.magento.dao.UserDaoImpl;

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

    public List<User> getCalls(String login, long date) {
        List<User> list = new ArrayList<>();
        long callData = System.currentTimeMillis() - date;
        EntityManager manager = getManager();
        try {
            List<CallRecriverCalls> calls = (List) manager.createQuery("SELECT c FROM CallRecriverCalls c WHERE c.login = :login AND c.callData > :callData")
                    .setParameter("login", login).setParameter("callData", new Date(callData)).getResultList();
            calls.forEach((c) -> {
                User user = new UserDaoImpl().getUserByTelephone(c.getClient());
                if (user != null) {
                    user.setFirstName(user.getFirstName());
                    user.setLastName(user.getLastName());
                    user.setTelephone(c.getClient());
                    user.setCallDate(c.getCallData().getTime());
                    list.add(user);
                } else {
                    user.setFirstName("unknow");
                    user.setLastName("unknow");
                    user.setTelephone(c.getClient());
                    user.setCallDate(c.getCallData().getTime());
                    list.add(user);
                }
            });
            return list;
        } catch (Exception ex) {
            return null;
        } finally {
            manager.close();
        }
    }
}
