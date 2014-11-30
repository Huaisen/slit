/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.entity;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author even
 */
@Entity
public class Module {
   @Id @GeneratedValue
   private long id;
   @Column(unique=true)
   private String name;
   private String learningGoals;
   private String approvalCriteria;
   
   private boolean mandatory;
      
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date deadline;
   
      public boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
   
   public Module() {
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getLearningGoals() {
        return learningGoals;
    }

    public void setLearningGoals(String learningGoals) {
        this.learningGoals = learningGoals;
    }

    public String getApprovalCriteria() {
        return approvalCriteria;
    }

    public void setApprovalCriteria(String approvalCriteria) {
        this.approvalCriteria = approvalCriteria;
    }


   
    public ArrayList<ModuleFile> getFiles(){
      
 
       ArrayList<ModuleFile> files = new ArrayList();
       
       
       ModuleFile moduleFile = new ModuleFile();
       moduleFile.setFilename("Test file 1");
       moduleFile.setModule(this);
       files.add(moduleFile);
       
       moduleFile = new ModuleFile();
       moduleFile.setFilename("Test file 2");
       moduleFile.setModule(this);       
       files.add(moduleFile);
       
       return files;
       
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
      return hash;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final Module other = (Module) obj;
      if (this.id != other.id) {
         return false;
      }
      return true;
   }
}
