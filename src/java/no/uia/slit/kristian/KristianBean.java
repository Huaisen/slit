/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.kristian;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import no.uia.slit.entity.Assessment;
import no.uia.slit.entity.Module;
import no.uia.slit.entity.PlanItem;
import no.uia.slit.entity.Student;
import no.uia.slit.web.Page;


/**
 *
 * @author kristianandersson
 */

@Named("kristianBean")
@SessionScoped
        public class KristianBean implements Serializable {
   
    
    private ArrayList<Module> modules;
    
    private Module selectedModule;

    public Module getSelectedModule() {
        return selectedModule;
    }

    public void setSelectedModule(Module selectedModule) {
        this.selectedModule = selectedModule;
    }
    public KristianBean(){
        
        getModules();
    }
    
    public Page showOverview(long id){
        
        
        Module module = getModuleById(id);
        setSelectedModule(module);
        return Page.student;
    }
    
  public ArrayList<Module> getModules(){
      
      Calendar calendar = Calendar.getInstance();
      
      

      modules = new ArrayList<>();
      /* Dummy data. Should be replaced with call to DB */
      
      /*
      modules.add(new ModuleKA(1, "To learn you must...","To approve the students must...","In the future"));
      modules.add(new ModuleKA(2, "To learn you must...","To approve the students must...","In the future"));
      modules.add(new ModuleKA(3, "To learn you must...","To approve the students must...","In the future"));
      
*/
      
      Module module1 = new Module();
      module1.setName("Modul 1");
      module1.setDescription("Dette er læringsmål for modul 1");
      module1.setId(1);
      modules.add(module1);
      
      calendar.set(2015, 3, 14);
      Module module2 = new Module();
      module2.setName("Modul 2");
      module2.setDescription("Dette er læringsmål for modul 2");
      module2.setId(2);
      module2.setDeadline(calendar.getTime());
      modules.add(module2);
      
      Module module3 = new Module();
      module3.setName("Modul 3");
      module3.setDescription("Dette er læringsmål for modul 3");
      module3.setId(3);
      modules.add(module3);
      
      calendar.set(2015, 5, 7);

      Module module4 = new Module();
      module4.setName("Modul 4");
      module4.setId(4);
      module4.setDeadline(calendar.getTime());
      modules.add(module4);
      
      
      Module module5 = new Module();
      module5.setName("Modul 5");
      module5.setId(5);
      modules.add(module5);
      
      Module module6 = new Module();
      module6.setName("Modul 6");
      module6.setId(6);
      modules.add(module6);
      
      Module module7 = new Module();
      module7.setName("Modul 7");
      module7.setId(7);
      modules.add(module7);
      
      Module module8 = new Module();
      module8.setName("Modul 8");
      module8.setId(8);
      modules.add(module8);
      
      Module module9 = new Module();
      module9.setName("Modul 9");
      module9.setId(9);
      modules.add(module9);
      
      Module module10 = new Module();
      module10.setName("Modul 10");
      module10.setId(10);
      modules.add(module10);
      
     /* 
          if(i==0) {
         
            return modules;
 
     }
     else{
         ArrayList<Module> singleModuleList = new ArrayList<>();
         singleModuleList.add(modules.get(i));
         
         return singleModuleList;
  
      
     }
             */
         return modules;
   
 
            
  }
  
  public Module getModuleById(long i){
      
      int z = 0;
      while(z<modules.size()){
      
          if(modules.get(z).getId()==i){
              
              return modules.get(z);
             
          }
          
      z++;
      
        }
      return null;
  }
     
      
      
  
  
  public Student getStudent(){ 
     
      Student student = new Student();
      
      student.setId(9);
      student.setUsername("Kristian Andersson");
      
      return student;
      
  }
  
  public ArrayList<PlanItem> getAllPlanItems(){
      
      ArrayList <PlanItem> planEntries = new ArrayList();

      PlanItem planItem = new PlanItem();
      planItem.setId(1);
      planItem.setModule(getModuleById(1));
      planItem.setStudent(getStudent());
      planItem.setPlannedDate(new Date());
      planEntries.add(planItem);
      
      planItem = new PlanItem();
      planItem.setId(2);
      planItem.setModule(getModuleById(2));
      planItem.setStudent(getStudent());
      planItem.setPlannedDate(new Date());
      planEntries.add(planItem);
      
      
      planItem = new PlanItem();
      planItem.setId(3);
      planItem.setModule(getModuleById(3));
      planItem.setStudent(getStudent());
      planItem.setPlannedDate(new Date());
      planEntries.add(planItem);
      
      return planEntries;
      
  }
  
  
  
  public ArrayList<Assessment> getAllAssesments(){
      
      ArrayList<Assessment> assessments = new ArrayList<>();
      
      Assessment assessment = new Assessment();
      assessment.setId(1);
      assessment.setStudent(getStudent());
      assessment.setModule(getModuleById(1));
      assessment.setApproved(true);
      assessment.setTeachersComment("Goooood!");
      assessment.setApprovedDate(new java.sql.Date(new Date().getTime()));
      assessments.add(assessment);

      
      assessment = new Assessment();
      assessment.setId(2);
      assessment.setStudent(getStudent());
      assessment.setModule(getModuleById(2));
      assessment.setApproved(false);
          assessments.add(assessment);
      
      /*
      assessment = new Assessment();
      assessment.setId(3);
      assessment.setStudent(getStudent());
      assessment.setModule(getModuleById(2));
      assessment.setApproved(true);
      assessment.setTeachersComment("Very Goooood!");
      assessment.setApprovedDate(new java.sql.Date(new Date().getTime()));
      assessments.add(assessment);
*/

      
      
      
      
      return assessments;
  }
  
  public ArrayList<String> getModulesStatus(){
      
      ArrayList<PlanItem> planItems = getAllPlanItems();
      HashMap<Module,Integer> statusMap = new HashMap<>();
      ArrayList<Assessment> assessments = getAllAssesments();
      ArrayList<String> statusList = new ArrayList<>();
      

      for(Module module:modules){
          
      statusMap.put(module, 0);  
      } 
      
      Iterator it = statusMap.entrySet().iterator();
      
      
    while (it.hasNext()) {
        Map.Entry pairs = (Map.Entry)it.next();
    
        for(PlanItem planItem:planItems){
      

            if(planItem.getModule().equals(pairs.getKey())){
                  
                pairs.setValue(1);
            }
                
        }
        
        for(Assessment assessment:assessments){
               if(assessment.getModule().equals(pairs.getKey())){
                   

                   if(assessment.isApproved()== false && !pairs.getValue().equals(3) && assessment.getTeachersComment() == null){
                    
                        pairs.setValue(2);
                       
                   }
                   else{
                       
                        pairs.setValue(3);
                       
                   }
                  
            }   
        
        
        }
    }

               
    it = statusMap.entrySet().iterator();
      
      
    while (it.hasNext()) {
     
        Map.Entry pairs = (Map.Entry)it.next();
        
            switch((int) pairs.getValue()){
                    
                    case 0:
                    statusList.add("module_inactive");
                    break;
                    
                    case 1:
                    statusList.add("");
                    break;
                        
                    case 2:
                    statusList.add("awaiting_approval");
                    break;
                    
                    case 3:
                    statusList.add("finished_module");
                    break;
                }
        
        
        
                
        }
          
           
          
      
      
      
      
      
      return statusList;
  }
  
  public List<Module> getPlannedModulesForStudent(){
      
      ArrayList<PlanItem> plan = getAllPlanItems();
      List<Module> modules = getModules();
      
      Iterator it = modules.iterator();
      
      Boolean isPlanned;
      
    while (it.hasNext()) {
        Object module = it.next();
    isPlanned = false;
        for(PlanItem planItem:plan){
      
            if(planItem.getModule().equals(module)){
                
                isPlanned = true;
            }
        }
            if(isPlanned == false){
                it.remove();
                
            }
        
                
        }
      
      return modules;
  }
  
  public List<Module> getCurrentModule(){
      
      List<Module> plannedModules = getPlannedModulesForStudent();
      
      List <Assessment> assessments = getAllAssesments(); 
      
      Iterator it = plannedModules.iterator();
      boolean shouldBeRemoved;
        while (it.hasNext()) {
          Object module = it.next();
          shouldBeRemoved = false;
      for(Assessment assessment: assessments){
          
          if(assessment.getModule().equals(module) && assessment.isApproved()==true){
          
              shouldBeRemoved = true;
          
          }
          
      }
      if(shouldBeRemoved == true){
          
          it.remove();
      }
      }
        return plannedModules;
  }
      
 

      
  
    
}
