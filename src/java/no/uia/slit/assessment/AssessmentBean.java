/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.assessment;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import no.uia.slit.entity.Assessment;
import no.uia.slit.web.JsfUtils;
import no.uia.slit.web.Page;
/**
 *
 * @author kristianandersson
 */
@Named(value="assessmentBean")
@SessionScoped
public class AssessmentBean implements Serializable {
    
    private String testString;
    public AssessmentBean(){   
    }
    
    //Assessment assessment
    public Page submitAssessment(){
        
        //if(assessment.getFiles().size()>0){
          JsfUtils.addMessage("overviewForm:submit", "No files have been uploaded");
        //}
             return Page.student;  

            
        //}
        

    }
    
    
    
}
