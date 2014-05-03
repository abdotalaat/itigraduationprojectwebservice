/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import pojo.User;

/**
 *
 * @author abdotalaat
 */
public class UserHome {

    private Session session;
    
    public UserHome() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public boolean addUser(User user) {
    session.beginTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        return true;

    }

    

    public static void main(String[] args) {

        

    }
}
