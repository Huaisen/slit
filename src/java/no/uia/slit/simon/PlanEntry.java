/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.simon;

import java.util.ArrayList;


/**
 *
 * @author Simon
 */
public class PlanEntry {
    
    //Fields   
    private int studentID;
    private int moduleID;
    private String planEntryDate;
    private String moduleDeadline;
    private String expectedDelivery;
    private String deadlineExpectedDeliveryDiff;
   
    
    
    //Constructor
    public PlanEntry(int studentID, int moduleID, String planEntryDate, 
            String moduleDeadline, String expectedDelivery, String deadlineExpectedDeliveryDiff)
    {
    this.studentID = studentID;
    this.moduleID = moduleID;
    this.planEntryDate = planEntryDate;
    this.moduleDeadline = moduleDeadline;
    this.expectedDelivery = expectedDelivery;
    this.deadlineExpectedDeliveryDiff = deadlineExpectedDeliveryDiff;
    }




 

   
            
    //metoder        

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public String getplanEntryDate() {
        return planEntryDate;
    }

    public void setplanEntryDate(String planEntryDate) {
        this.planEntryDate = planEntryDate;
    }

        public String getModuleDeadline() {
        return moduleDeadline;
    }

    public void setModuleDeadline(String moduleDeadline) {
        this.moduleDeadline = moduleDeadline;
    }


    public String getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(String expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    

    public String getDeadlineExpectedDeliveryDiff() {
        return deadlineExpectedDeliveryDiff;
    }

    public void setDeadlineExpectedDeliveryDiff(String deadlineExpectedDeliveryDiff) {
        this.deadlineExpectedDeliveryDiff = deadlineExpectedDeliveryDiff;
    }
    

    
 
  
    
    
    
    
    
    
    
    
    
    
    
}
