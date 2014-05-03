/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CompetitionHome;
import dao.UserHome;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import pojo.Competition;
import pojo.User;

/**
 *
 * @author abdotalaat
 */
@Path("/user")
public class ProgrammingForKidsServices {

    
    //this service for add new user to server database
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String addUser(@QueryParam(value = "fName") String fName, @QueryParam(value = "lName") String lName, @QueryParam(value = "userName") String userName, @QueryParam(value = "birthOfDate") String dateOfBirth) {
        UserHome userHome = new UserHome();
        User user = new User(fName, lName, userName, dateOfBirth);
        userHome.addUser(user);
        return "true";
    }
    
    
    
    @GET
    @Path("/competion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Competition> getDailyCompetition()
    {
        CompetitionHome competitionHome = new CompetitionHome();
        List<Competition> competitions = competitionHome.getOpenCompetion();
        return competitions;
        
    }
    
    
    
}
