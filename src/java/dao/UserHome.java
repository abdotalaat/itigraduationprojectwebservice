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
import pojo.User;
import pojo.UserCompetion;

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
    
    public User getUser(int id)
    {
        String hql = "from User where id="+id+"";
        Query query = session.createQuery(hql);
        return (User) query.uniqueResult();
    }
    
    
    
    public List<Integer> addUserScore(int userID,int compID,int score)
    {   
        User user = getUser(userID);
        List<UserCompetion> competitions = new ArrayList<UserCompetion>();
        competitions.addAll(user.getUserCompetions());
        UserCompetion userCompetion =null;
        for (UserCompetion userCompetion1 : competitions) {
            if(userCompetion1.getUser().getIdUser() == userID && userCompetion1.getCompetition().getId() == compID)
            {
                userCompetion = userCompetion1;
                break;
            }
        }
       
        if(userCompetion != null)
        {
            userCompetion.setCompScore(score);
        
        session.beginTransaction().begin();
        session.save(userCompetion);
        session.getTransaction().commit();
        }
        
        return getScoreForCompetiton(compID);
    }

    
    
    
    public List<Integer> getScoreForCompetiton(int id)
    {
        List<Integer> scores = new ArrayList<Integer>();
        String hql = " from UserCompetion e where e.competition.id="+id+" ORDER BY compScore DESC";
        List<UserCompetion> userCompetions = session.createQuery(hql).list();
        
        for (UserCompetion userCompetion : userCompetions) {
            scores.add(userCompetion.getCompScore());
        }
        return scores;
        
    }

    public static void main(String[] args) {

        UserHome userHome = new UserHome();
        System.out.println(userHome.getScoreForCompetiton(1).get(0));
    }
}
