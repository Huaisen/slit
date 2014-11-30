/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import no.uia.slit.auth.AuthPersistenceService;
import no.uia.slit.auth.AuthUser;
import no.uia.slit.ejb.ModulePersistenceService;
import no.uia.slit.ejb.PlanItemPersistenceService;
import no.uia.slit.entity.Assessment;
import no.uia.slit.entity.Module;
import no.uia.slit.entity.PlanItem;

/**
 *
 * @author kristianandersson
 */
@Named("studentBean")
@SessionScoped
public class StudentBean implements Serializable {
    
    
   @EJB private PlanItemPersistenceService planItemSvc;
   @EJB private ModulePersistenceService moduleSvc;
   @EJB private AuthPersistenceService authSvc;
   
   Module selectedModule;

    public Module getSelectedModule() {
        return selectedModule;
    }

    public void setSelectedModule(Module selectedModule) {
        this.selectedModule = selectedModule;
    }
    
     public Page showOverview(long id){
      
         
        Module module = moduleSvc.find(id);
        
        setSelectedModule(module);
        
        return Page.student;
    }
    

   public ArrayList<String> getModulesStatus(){
      
      AuthUser currentUser = authSvc.findUser(JsfUtils.getUserName());
      HashMap<Module,String> statusMap = new HashMap<>();
      ArrayList<Assessment> assessments = new ArrayList();
      ArrayList<String> statusList = new ArrayList<>();
      
      ArrayList<Module> modules = new ArrayList(moduleSvc.findAll());
      ArrayList<PlanItem> planItems = new ArrayList(planItemSvc.findAllLockedPlanItemsByUser(currentUser));
      for(Module module:modules){
          
      statusMap.put(module, "inactive");  
      } 
      
      Iterator it = statusMap.entrySet().iterator();
      
      
    while (it.hasNext()) {
        Map.Entry pairs = (Map.Entry)it.next();
    
        for(PlanItem planItem:planItems){
      

            if(planItem.getModule().equals(pairs.getKey())){
                  
                pairs.setValue("none");
            }
                
        }
        
        for(Assessment assessment:assessments){
               if(assessment.getModule().equals(pairs.getKey())){
                   

                   if(assessment.isApproved()== false && !pairs.getValue().equals("finished") && assessment.getTeachersComment() == null){
                    
                        pairs.setValue("waiting");
                       
                   }
                   else{
                       
                        pairs.setValue("finished");
                       
                   }
                  
            }   
        
        
        }
    }

               
    it = statusMap.entrySet().iterator();
      
      
    while (it.hasNext()) {
     
        Map.Entry pairs = (Map.Entry)it.next();
        
            switch((String) pairs.getValue()){
                    
                    case "inactive":
                    statusList.add("module_inactive");
                    break;
                    
                    case "none":
                    statusList.add("");
                    break;
                        
                    case "waiting":
                    statusList.add("awaiting_approval");
                    break;
                    
                    case "finished":
                    statusList.add("finished_module");
                    break;
                }
        
        
        
                
        }
          
           
          
      
      
      
      
      
      return statusList;
  }
   
     public ArrayList<Module> getCurrentModule(){
      AuthUser currentUser = authSvc.findUser(JsfUtils.getUserName());

      ArrayList<Module> plannedModules = new ArrayList(getPlannedModulesForStudent(currentUser));
      
      ArrayList<Assessment> assessments = new ArrayList(); 
      
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

  public ArrayList<Module> getPlannedModulesForStudent(AuthUser u){
      
      ArrayList<PlanItem> plan = new ArrayList(planItemSvc.findAllLockedPlanItemsByUser(u));
      ArrayList<Module> modules = new ArrayList(moduleSvc.findAll());
      
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


}
    

