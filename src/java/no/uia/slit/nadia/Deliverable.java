/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package no.uia.slit.nadia;

import java.util.ArrayList;

/**
 *
 * @author Nadia
 */
public class Deliverable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private int studentid; 
    private String planEntry;
    private int datetime;
    private String status;
    
    
    public Deliverable(int id,int studentid,String planEntry,int datetime,String status){
      this.id = id;    
      this.studentid = studentid;
     this.planEntry = planEntry;
     this.datetime = datetime;
     this.status = status;
}
     

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getPlanEntry() {
        return planEntry;
    }

    public void setPlanEntry(String planEntry) {
        this.planEntry = planEntry;
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }
    
  
    public String isStatus() {
        return status;
    }

  
         
    public void listFile(){
    
        
    }
    public void editStatus(){
        
    }
    
    public void createComment(){
        
        
    }
        
    
     public void getComment(){
         
    }
     
     
    
 
}
