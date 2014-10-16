/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.sondre;

/**
 *
 * @author sondre
 */

public class Studenterne {
    
    private int id;
    private String studentname;
    private String studentpost;
    
    public Studenterne( int id, String studname, String studepost){
    
    this.id = id;
    this.studentname = studname;
    this.studentpost = studepost;
    
    
    }
    
    public void setAllInfo(int id, String studname,String studepost){
     
    this.id = id;
    this.studentname = studname;
    this.studentpost = studepost;
   
     } 
    
    
    public void setId( int id){
        this.id = id;
    }
    public int getId(){
    return id;
    }
    
    
   
    
    
    public void setStudName( String studname){
         this.studentname = studname;
     }
     public String getStudName(){
     return studentname;
     }
    
             
    
    
    
    public void setEpost( String studepost){
         this.studentpost = studepost;
     }
     public String getStudEpost(){
     return studentpost;
     }
     
     
     public void getAllInfo(){
     }
     
     public void getStudPlan(){
     }
     
     public void getModuleHistory(){
     }
     
     public void getStudPlanDate(){
     }
     
     public void getBlogEntries(){
     } 

     public void createBlogEntry(){
     }
     
             }



    








   
 
     
     
           




