/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.kristian;

import java.util.Date;

/**
 *
 * @author kristianandersson
 */
public class ModuleKA {
  
    private Integer id;
    private String learningObjectives;
    private String approvalCriterias;
    private String deadline;
    
    public ModuleKA(Integer id,String learningObj, String approvalCrit,String deadline){
        
        this.id = id;
        this.learningObjectives = learningObj;
        this.approvalCriterias = approvalCrit;
        this.deadline = deadline;

        
        
    }
   
 
    
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLearningObjectives() {
        return learningObjectives;
    }

    public void setLearningObjectives(String learningObjectives) {
        this.learningObjectives = learningObjectives;
    }
    
    public String getApprovalCriterias() {
        return approvalCriterias;
    }

    public void setApprovalCriterias(String approvalCriterias) {
        this.approvalCriterias = approvalCriterias;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
   
    
 
    
    public void getModuleInfo(){
        
        
    }
    
    public void getModuleHistoryForStudent(){
        
        
    }
    
    
   public void createSOSCall(){
       
       
       
       
   }
    
    
    
    
}
