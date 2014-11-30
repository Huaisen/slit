/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import no.uia.slit.auth.AuthPersistenceService;
import no.uia.slit.auth.AuthUser;
import no.uia.slit.ejb.ModulePersistenceService;
import no.uia.slit.ejb.PlanItemPersistenceService;
import no.uia.slit.entity.Module;
import no.uia.slit.entity.PlanItem;

/**
 *
 * @author kristianandersson
 */
@Named("planBean")
@SessionScoped
public class PlanBean implements Serializable {
    
   @EJB private PlanItemPersistenceService planItemSvc;
   @EJB private ModulePersistenceService moduleSvc;
   @EJB private AuthPersistenceService authSvc;

    private PlanItem selectedPlanItem;
    private List<PlanItem> tempPlanItems;
    private Date tempDate;

  
    public PlanBean() {
        
    }
    public Page openCreatePlan(){
        
        return Page.plan;
    }
   
    public Date getTempDate() {
        return tempDate;
    }

    public void setTempDate(Date tempDate) {
        this.tempDate = tempDate;
    }
     
    
    public List<PlanItem> getTempPlanItems() {
        return tempPlanItems;
    }

    public void setTempPlanItems(List<PlanItem> tempPlanItems) {
        this.tempPlanItems = tempPlanItems;
    }
    public Page clearSelectedPlanItem(){
        
        selectedPlanItem = null;
        
        return Page.plan;
    }
    
  

    public List<PlanItem> getAllPlanItems() {
        return planItemSvc.findAll();
        
    }
    public Page createTempPlanItems(AuthUser user){
        
        List<Module> modules = moduleSvc.findAll();
        
        tempPlanItems = new ArrayList<>();
        
        Iterator it = modules.iterator();
        int i = 0;
        while(it.hasNext()){
            Module module = (Module) it.next();
            PlanItem planItem = new PlanItem();
            planItem.setModule(module);
            
            tempPlanItems.add(planItem);
            i++;
        }
        
      
        return Page.plan;
       
    }
    
    public PlanItem getTempPlanItem(Module m){
        
        for(PlanItem planItem: tempPlanItems){
            
           if(planItem.getModule().equals(m)){
             
             return planItem;

           }
        }
        return null;
    }
    
    
    /** Set up module form for adding a new module */
   
    public Page openPlanItem(Module m,AuthUser u) {
        
        selectedPlanItem = planItemSvc.findOneByUserAndModule(m,u);
        
        if(selectedPlanItem == null){
            
            PlanItem p = new PlanItem();
            p.setModule(m);
            p.setUser(u);
            selectedPlanItem = p;

        }
        else{
            
            tempDate = selectedPlanItem.getPlannedDate();
            
        }
        
        
        return Page.plan;
    }
    public Page getPlanItemByModuleAndUser(Module m, AuthUser u){
        
         tempPlanItems = planItemSvc.findAllByUserAndModule(m, u);
        
         return Page.planItems;
    }
    
    public PlanItem getFirstPlanItemByModuleAndUser(Module m, AuthUser u){
        
         return planItemSvc.findOneByUserAndModule(m, u);
        
    }

    
    
    

    /** Prepare module form for editing an existing module.
     * If the requested module does not exist, a new module
     * will be created instead. */
    public Page editPlanItem(long id) {
        selectedPlanItem = planItemSvc.find(id);
        if (null == selectedPlanItem) {
            selectedPlanItem = new PlanItem();
        }
        return Page.plan;
    }

    public PlanItem getSelectedPlanItem() {
        return selectedPlanItem;
    }
    
    public int calculateDateDiff(Date date1, Date date2){
        
        Calendar calendar1 = Calendar.getInstance(JsfUtils.returnTimeZone());
        calendar1.setTime(date1);
        
        Calendar calendar2 = Calendar.getInstance(JsfUtils.returnTimeZone());
        
        int diffInMilliSeconds = calendar1.compareTo(calendar2);
        
        JsfUtils.addMessage(null, "Diff: " + diffInMilliSeconds);
        
        return diffInMilliSeconds;
    }
        public boolean isPlanItemDateAfterModuleDeadline(){
        
        boolean result;
            
        if(null != tempDate){
        if(selectedPlanItem.getModule().getDeadline() != null){    
        Calendar calendar1 = Calendar.getInstance(JsfUtils.returnTimeZone());
        calendar1.setTime(selectedPlanItem.getModule().getDeadline());

        Calendar calendar2 = Calendar.getInstance(JsfUtils.returnTimeZone());
        calendar2.setTime(tempDate);
        
        int compareValue = calendar1.compareTo(calendar2);
                
        if(compareValue < 1){
            result = false;
            JsfUtils.addMessage(null, "1. Dato er ikke gyldig");
                        JsfUtils.addMessage(null, tempDate.toString());


        }
        else{
            result = true;
        }
       
        }else{
            
            result = false;
  
        }
        }
        else{
            
            result = true;
            JsfUtils.addMessage(null, "2. Dato er ikke gyldig");

        }
        
        return result;
    }
    
        
    public Page savePlanItem(){
        
        //selectedPlanItem.setPlannedDate(tempDate);
        planItemSvc.save(selectedPlanItem);
        selectedPlanItem = null;
    
        
        return Page.plan;
    }
    
        public Page deletePlanItem(long id){
        
         selectedPlanItem = planItemSvc.find(id);   
        planItemSvc.remove(selectedPlanItem);
        
        return Page.planItems;
    }  
        
        public Page lockPlanItems(AuthUser u){
        
        List<PlanItem> planItems = planItemSvc.findAllByUser(u);
        List<Module> modules = moduleSvc.findAll();
        
        boolean stopLocking = false;
        for(Module module:modules){
         
            if(module.getMandatory() == true){
                
            PlanItem planItem = planItemSvc.findOneByUserAndModule(module, u);
                if(planItem == null){
                  stopLocking = true;
                }
                else{
                if(planItem.getPlannedDate() == null){
                stopLocking = true;
                }
                
            
            }
        }
        }
            
        if(stopLocking == false){
            for(PlanItem planItem:planItems){
                
                
                if(planItem.getPlannedDate() != null){
                planItem.setPlanItemLocked(true);
                planItemSvc.save(planItem);
                }
                else{

                    planItemSvc.remove(planItem);
                }


            }
        
        }
        else{
          
                    JsfUtils.addMessage(null, "Feil: Der må settes dato for obligatoriske moduler");
        return Page.plan;

            
        }
        
        return Page.student;
    }
        
   public boolean doesLockedPlanItemsExistForUser(AuthUser u){
       
       List<PlanItem> planItems = planItemSvc.findAllLockedPlanItemsByUser(u);
       
       if(planItems.isEmpty()){
           
           return false;
       }
       else{
       
          
           return true;
        }
           
       
   }

    
    
 
}
