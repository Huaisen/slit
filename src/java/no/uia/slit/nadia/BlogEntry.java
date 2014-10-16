package no.uia.slit.nadia;

 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/*
 * @author Nadia
 */
public class BlogEntry {
    private int id;
    private String blog;
    private String calendar;
    private int studentid;

    public int getId() {
        return id;
    }
   

    public BlogEntry(int id, String blog, String calendar, int studentid){
        this.id = id;
        this.blog = blog;
        this.calendar = calendar;
        this.studentid = studentid;
    }

       
    public int id() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getBlog() {
        return blog;
    }

   
    public void setBlog(String blog) {
        this.blog=blog;
    }
    

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
     
