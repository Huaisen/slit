/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package no.uia.slit.nadia;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Nadia
 */
@Named("blogBean")
@SessionScoped
public class BlogBean implements Serializable {
    

private ArrayList<BlogEntry> blogs;
public BlogBean(){
        
        
    }
    
    
  public ArrayList<BlogEntry> getBlogs(){
      
      blogs = new ArrayList<>();
      
      
      blogs.add(new BlogEntry(1,"Jeg skriver om Module 1...","15.10.14 kl.13:00",1));
      blogs.add(new BlogEntry(2,"Jeg skriver om Module 2...","12.11.14 kl.18:00",1));
      blogs.add(new BlogEntry(3,"Jeg skriver om Module 3...","10.12.14 kl.13:00",1));
      

    return blogs;
            
  }
    
}
