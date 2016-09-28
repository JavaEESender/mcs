/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.magento.dao;

import javax.persistence.EntityManager;
import ua.obolon.ponovoy.magento.entity.SalesFlatOrderAddress;
import ua.obolon.ponovoy.impl.UserImpl;
import ua.obolon.ponovoy.interfaces.User;
import ua.obolon.ponovoy.inerfaces.dao.UserDao;

/**
 *
 * @author Alexander
 * @version 1.0
 */
public class UserDaoImpl extends JPA implements UserDao {

    EntityManager manager;

    /**
     * @param telephone Номер телефона по которому осуществляется поиск в базе
     * Маgento
     * @author Alexander хахаха
     *
     */
    @Override
    public User getUserByTelephone(String telephone) {

        manager = getManager();
        User user = new UserImpl();
        try {
            SalesFlatOrderAddress salesFlatOrderAddress = (SalesFlatOrderAddress) manager.createQuery("SELECT s FROM SalesFlatOrderAddress s WHERE s.telephone = :telephone AND s.addressType = :addressType ORDER BY s.parentId.createdAt DESC")
                    .setParameter("telephone", telephone).setParameter("addressType", "shipping").setMaxResults(1).getSingleResult();
            if (salesFlatOrderAddress != null) {
                user.setId(salesFlatOrderAddress.getParentId().getEntityId());
                user.setFirstName(salesFlatOrderAddress.getFirstname());
                user.setLastName(salesFlatOrderAddress.getLastname());
                user.setTelephone(telephone);
            }
            return user;
        } catch (Exception ex) {
            return null;
        } finally {
            manager.close();
        }
    }
}
