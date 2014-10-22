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
import javax.persistence.NamedQuery;
import no.uia.slit.web.ModuleBean;

/**
 *
 * @author even
 */
@Entity
@NamedQuery(name = "Student.byUsername",
        query = "select s from Student s where s.username = :username")
public class Student {
   @Id @GeneratedValue
   private long Id;

   @Column(unique=true)
   private String username;
   
   private String email; //Added by Team Reunion 

   public Student() {
   }

   public long getId() {
      return Id;
   }

   public void setId(long Id) {
      this.Id = Id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }
   

   @Override
   public int hashCode() {
      int hash = 3;
      hash = 67 * hash + (int) (this.Id ^ (this.Id >>> 32));
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
      final Student other = (Student) obj;
      if (this.Id != other.Id) {
         return false;
      }
      return true;
   }
}
