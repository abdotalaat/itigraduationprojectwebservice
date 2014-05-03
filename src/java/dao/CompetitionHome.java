/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.Competition;

/**
 *
 * @author abdotalaat
 */
public class CompetitionHome {

    private Session session;

    public CompetitionHome() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    public List<Competition> getOpenCompetion()
    {
        String hql  = "from Competition";
        session.getTransaction().begin();
        Query query = session.createQuery(hql);
        return query.list();
    }
    
    public static void main(String [] args)
    {
        CompetitionHome home = new CompetitionHome();
        home.getOpenCompetion();
        System.out.println(home.getOpenCompetion().size());
    }
}
