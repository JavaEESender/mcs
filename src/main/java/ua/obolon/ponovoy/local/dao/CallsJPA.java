/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.local.dao;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import ua.obolon.ponovoy.local.entity.CallRecriverCalls;

/**
 *
 * @author Alexander
 */
public class CallsJPA extends JPA_calls {

    public void setNewCall(String man, String client, Date date) {
        EntityManager manager = getManager();
        try {
            GregorianCalendar gc = new GregorianCalendar();
            CallRecriverCalls calls = new CallRecriverCalls(Integer.SIZE, man, client, date);
            manager.getTransaction().begin();
            manager.persist(calls);
            manager.getTransaction().commit();
        } catch (Exception ex) {
        } finally {
            manager.close();
        }
    }

}
