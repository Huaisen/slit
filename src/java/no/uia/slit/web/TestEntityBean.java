/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.web;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import no.uia.slit.ejb.TestEntityPersistenceService;
import no.uia.slit.entity.PlanItem;
import no.uia.slit.entity.TestEntity;

/**
 *
 * @author kristianandersson
 */
@Named("testEntityBean")
@SessionScoped
public class TestEntityBean implements Serializable {
    
   @EJB private TestEntityPersistenceService testEntitySvc;
    private TestEntity selectedTestEntity;

    public TestEntityBean() {
    }


    public List<TestEntity> getAllTestEntities() {
        return testEntitySvc.findAll();
    }

    /** Set up module form for adding a new module */
    public Page createTestEntity() {
        selectedTestEntity = new TestEntity();
        return Page.plan;
    }

    /** Prepare module form for editing an existing module.
     * If the requested module does not exist, a new module
     * will be created instead. */
    public Page editTestEntity(long id) {
        selectedTestEntity = testEntitySvc.find(id);
        if (null == selectedTestEntity) {
            selectedTestEntity = new TestEntity();
        }
        return Page.plan;
    }

    public TestEntity getSelectedTestEntity() {
        return selectedTestEntity;
    }
    
    public Page saveTestEntity(){
        
        testEntitySvc.save(selectedTestEntity);
        
        return Page.admin;
    }
    
        public Page deleteTestEntity(long id){
        
         selectedTestEntity = testEntitySvc.find(id);   
        testEntitySvc.remove(selectedTestEntity);
        
        return Page.planItems;
    }  
    
    
 
}
