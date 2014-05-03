package pojo;
// Generated May 3, 2014 1:08:24 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Competition generated by hbm2java
 */
@XmlRootElement
public class Competition  implements java.io.Serializable {


     private Integer id;
     private String compName;
     private String startDate;
     private String endDate;
     private String compMaze;
     private String compCategory;
     private Set userCompetions = new HashSet(0);

    public Competition() {
    }

    public Competition(String compName, String startDate, String endDate, String compMaze, String compCategory, Set userCompetions) {
       this.compName = compName;
       this.startDate = startDate;
       this.endDate = endDate;
       this.compMaze = compMaze;
       this.compCategory = compCategory;
       this.userCompetions = userCompetions;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCompName() {
        return this.compName;
    }
    
    public void setCompName(String compName) {
        this.compName = compName;
    }
    public String getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getCompMaze() {
        return this.compMaze;
    }
    
    public void setCompMaze(String compMaze) {
        this.compMaze = compMaze;
    }
    public String getCompCategory() {
        return this.compCategory;
    }
    
    public void setCompCategory(String compCategory) {
        this.compCategory = compCategory;
    }
    public Set getUserCompetions() {
        return this.userCompetions;
    }
    
    public void setUserCompetions(Set userCompetions) {
        this.userCompetions = userCompetions;
    }




}

