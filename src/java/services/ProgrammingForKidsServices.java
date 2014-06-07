/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CompetitionHome;
import dao.UserHome;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/test")
    public String test(@FormParam("compID") String id) 
    {
        
          StringBuilder builder = new StringBuilder();
          
          try {
            
            String as = this.getClass().getResource("../../../mazes/"+id+".txt").getPath();
            
            
            BufferedReader br = null;
            
            
            
            
            String sCurrentLine;
            
            br = new BufferedReader(new FileReader(as.substring(0)));
            
            while ((sCurrentLine = br.readLine()) != null) {
                builder.append(sCurrentLine);
               
            }
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProgrammingForKidsServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProgrammingForKidsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
       String maze =builder.toString();
        return maze;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("submiteCom")
    public String submitComepetion(@QueryParam("userID") int userID,@QueryParam("compID")int compID,@QueryParam("score")int score)
    {
        try {
            UserHome userHome = new UserHome();
           List<Integer>  scores =  userHome.addUserScore(userID, compID, score);
            
            JSONObject jSONObject = new JSONObject();
            JSONArray array = new JSONArray(scores);
            jSONObject.put("scores", array);
            return jSONObject.toString();
        } catch (JSONException ex) {
            Logger.getLogger(ProgrammingForKidsServices.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/comps")
    public String getCompetions(@FormParam(value = "myNum") String mNum) 
    {
        //String name = selectImg("123");
        
        JSONArray obj = new JSONArray();
        
        HashMap<String, String> maze1 = new HashMap();
        maze1.put("id", "1");
        maze1.put("name", "Maze 1");
        maze1.put("description", " A7la Competions from server 1 desc");
        maze1.put("image", "");
        
        HashMap<String, String> maze2 = new HashMap();
        maze2.put("id", "2");
        maze2.put("name", "Maze 2");
        maze2.put("description", " A7la Competions from server 2 desc");
        maze2.put("image", "");
        
        
        HashMap<String, String> maze3 = new HashMap();
        maze3.put("id", "3");
        maze3.put("name", "Maze 3");
        maze3.put("description", " A7la Competions from server 3 desc");
        maze3.put("image", "");
        
        
        HashMap<String, String> maze4 = new HashMap();
        maze4.put("id", "4");
        maze4.put("name", "Maze 4");
        maze4.put("description", " A7la Competions from server 4 desc");
        maze4.put("image", "");
        
        obj.put(maze1);
        obj.put(maze2);
        obj.put(maze3);
        obj.put(maze4);
        
        return obj.toString();
    }
    
    
    
}
