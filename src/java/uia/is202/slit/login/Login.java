/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uia.is202.slit.login;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author kristianandersson
 */
@Named("Login")
@SessionScoped

public class Login implements Serializable{
    
    

    
    private String name;
    private String pwd;
    
    
    public Login(){
        
       name = "Teacher";
       pwd = "Teacher";
 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public String checkPwd(){

        if(this.name.equals("Student") && this.pwd.equals("Student")){
               return "studentHomePage.xhtml";  
  
        }
        else if(this.name.equals("Teacher") && this.pwd.equals("Teacher")){
               return "teacherHomePage.xhtml";  
  
        }
    
            return "error.xhtml";
    }
}


