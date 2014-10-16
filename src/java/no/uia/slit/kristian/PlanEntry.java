/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.kristian;

/**
 *
 * @author kristianandersson
 */
public class PlanEntry {

    public PlanEntry() {
    }
   
    private long id;
    private String dateForCompletion;
    private  long studentId;
    private long moduleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateForCompletion() {
        return dateForCompletion;
    }

    public void setDateForCompletion(String dateForCompletion) {
        this.dateForCompletion = dateForCompletion;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }
    
    
         
    
    
    
}
