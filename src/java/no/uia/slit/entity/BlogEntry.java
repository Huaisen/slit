package no.uia.slit.entity;

 
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * @author Nadia
 */

@Entity
public class BlogEntry implements Serializable {
     @Id @GeneratedValue
   private long id;
   @Column(unique=true)
    private String blogText;
    private String calendar;
    private int studentid;

    
//constractor for klassen som inneholder id, blogtext,calendar og studetid
    public BlogEntry(){
       
    }
    
    public BlogEntry(int id,String blogText, String calendar, int studentid){
     this.id= id;
     this.blogText = blogText;
     this.calendar = calendar;
     this.studentid = studentid;
    }
    

        
   //blogEntry id
    public long getid() {
        return id;
    }

      //set metode for id
    public void setId(int id){
        this.id = id;
        
    }
//blog teksten 
    public String getBlogText() {
        return blogText;
    }

   
    public void setBlogText(String blogText) {
        this.blogText=blogText;
    }
    
// dato for innkrivet blogText
    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid; 
    }

}