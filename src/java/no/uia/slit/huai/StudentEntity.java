/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package no.uia.slit.huai;

import no.uia.slit.entity.*;
import no.uia.slit.huai.*;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The StudentEntity class is a "data" class. The student objects are used to
 * store data. The functionality of the application (the business logic) is
 * defined in the backing beans. We will collect all these entity classes in
 * the entity package.
 *
 * This class has input validation annotations. Adding the input validation
 * to the entity classes, rather than to the input forms,
 *
 * @author huai
 */
@Entity
@NamedQuery(name = "StudentEntity.byStudentid",
        query = "select s from StudentEntity s where s.Studentid = :studentid")

public class StudentEntity implements Serializable{
    @Id @GeneratedValue
    private static final long serialVersionUID = 1L;
    
    // id must have a value, and it must be zero or larger
    @Min(1)
    @Id
    private long studentid;
    
    // the student must have a firstname and lastname with at least 1 character
    @NotNull @Size(min=1)
    private String firstname;
    
    @NotNull @Size(min=1)
    private String lastname;
    
    @NotNull @Size(min=1)
    private String email;
    
    public StudentEntity(){
    }

    public long getStudentid() {
        return studentid;
    }

    public void setStudentid(long studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
