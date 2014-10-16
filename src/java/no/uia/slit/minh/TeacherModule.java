/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.minh;
/**
 *
 * @author MinhNguyenDinh
 */

public class TeacherModule {
 
    private Integer id;
    private String teachername;
    private String teachermail;
    
    public TeacherModule(Integer id, String teachername, String teachermail) {
        
        this.id = id;
        this.teachername = teachername;
        this.teachermail = teachermail;
    }

    
    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeachername() {
        return teachername;
    }
    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getTeachermail() {
        return teachermail;
    }
    public void setTeachermail(String teachermail) {
        this.teachermail = teachermail;
    }
   
   
    
}


