/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package no.uia.slit.huai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Backing bean for createStudent.xhtml
 *
 * @author huai
 */
@Named("studBean")
@ApplicationScoped
public class StudentBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private StudentEntity studententity;
    private HashMap<Long,StudentEntity> studententitys;
   
    public StudentBean(){
    studententity = new StudentEntity();
    studententitys = new HashMap<Long,StudentEntity>();
    }
    /** Return the list of students. We are not going to insert a new
     * list, so the getter is sufficient
     * @return  */
    public List<StudentEntity> getStudentEntitys() {
        ArrayList l;
        l = new ArrayList<StudentEntity>(studententitys.values());
        return l;
    }
    // if the user changes the student id, we assume that he wants to
    // edit another student
    public void setStudentid(long studentid) {
        System.out.println("studentid = "+studentid);
        System.out.println("studententitys = "+studententitys);
        studententity = studententitys.get(studentid);
        if (null == studententity) {
            studententity = new StudentEntity();
            studententity.setStudentid((int) studentid);
            studententitys.put(studentid, studententity);
        }
    }
    
    public long getStudentid() {
        if (null == studententity) {
            return 0;
        } else {
            return studententity.getStudentid();
        }
    }
     public StudentEntity getStudentEntity() {
        return studententity;
    }
     // We do not save the student yet
    public void saveStudent() {
        studententitys.put(studententity.getStudentid(), studententity);
    }
    
    public void cancelStudent() {
        studententitys.put(studententity.getStudentid(), null);
        studententity = new StudentEntity();
    }
}
