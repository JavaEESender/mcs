/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.magento.caller.interfaces;

/**@author Alexander
 */
public interface User {
    
    void setId(long id);
    long getId();
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setIsActive(boolean isActive);
    void setTelephone(String telephone);
    void setCallDate(long callDate);
    String getFirstName();
    String getLastName();
    boolean isActive();
    String getTelephone();
    long getCallDate();
}
