/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.kristian;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author kristianandersson
 */
@Entity
    public class ModuleKA {
   @Id @GeneratedValue
   private long id;
   @Column(unique=true)
    private String learningObjectives;
    private String approvalCriterias;
    private String deadline;
    
    
    
    public ModuleKA(){
        
        
    }
    /*
    public ModuleKA(Integer id,String learningObj, String approvalCrit,String deadline){
        
        this.id = id;
        this.learningObjectives = learningObj;
        this.approvalCriterias = approvalCrit;
        this.deadline = deadline;

        
        
    }
   */
 
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
