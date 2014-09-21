
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kristianandersson
 */
@Named("viewController")
@SessionScoped

public class viewController implements Serializable{
    
    public viewController(){
        
        
    }
    
    public String changeView(String buttonPressed){
          
        return null;
         
    }
    
    public String openApprovalOverviewPage(){
        
        
        return "ApprovalOverviewPage.xhtml";
    }
    
    
    public String openApprovalPage(){
        
        return "ApprovalPage.xhtml";
    }
    
    
    public String openHelpOverviewPage(){
        
        
        return "HelpOverviewPage.xhtml";
    }
        
        
    public String openAddEditModulePage(){
        
        
        return "addEditModule.xhtml";
    }
    

    public String returnToLastPage(){
        
        

        return "test";
    }
    public String openCreatePlan(){
        
        
      return "createPlan.xhtml"; 
        
    }
    public String openStudentHomePage(){
        
        return "studentHomePage.xhtml";  
    }
    
        public String openAddEditStudent(){
        
        return "addEditStudent.xhtml";
    }
    
    public String openStudentDetailsPage(){
        
        return "studentDetailsPage.xhtml";
    }
    
    public String openTeacherHomePage(){
        
        return "teacherHomePage.xhtml";  
    }

    
    public String openTeacherDetailsPage(){
        
        return "teacherDetailsPage.xhtml";
    }
    
     public String openLoginPage(){
        
        return "index.xhtml";
    }
    
}
