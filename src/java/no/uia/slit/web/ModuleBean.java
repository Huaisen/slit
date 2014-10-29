package no.uia.slit.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import no.uia.slit.ejb.ModulePersistenceService;
import no.uia.slit.entity.Module;


/**
 *
 * @author even
 */
@Named("moduleBean")
@SessionScoped
public class ModuleBean implements Serializable {
    @EJB private ModulePersistenceService moduleSvc;
    private Module selectedModule;

    public ModuleBean() {
    }


    public List<Module> getAllModules() {
        return moduleSvc.findAll();
    }

    /** Set up module form for adding a new module */
    public Page createModule() {
        selectedModule = new Module();
        return Page.module;
    }

    /** Prepare module form for editing an existing module.
     * If the requested module does not exist, a new module
     * will be created instead. */
    public Page editModule(long id) {
        selectedModule = moduleSvc.find(id);
        if (null == selectedModule) {
            selectedModule = new Module();
        }
        return Page.module;
    }

    public Module getSelectedModule() {
        return selectedModule;
    }
    
    public Page saveModule(){
        
        selectedModule = moduleSvc.save(selectedModule);
        
        return Page.modules;
    }
    
        public Page deleteModule(long id){
        
         selectedModule = moduleSvc.find(id);   
        moduleSvc.remove(selectedModule);
        
        return Page.modules;
    }
        
    public Module getLastId(){
        
        Module module = moduleSvc.getModuleFromDB(selectedModule);
        
        return module;
    }
    
    public static ArrayList<Module> getModules(){
      
      Calendar calendar = Calendar.getInstance();
      
      

      ArrayList<Module> modules = new ArrayList<>();
      /* Dummy data. Should be replaced with call to DB */
      
      /*
      modules.add(new ModuleKA(1, "To learn you must...","To approve the students must...","In the future"));
      modules.add(new ModuleKA(2, "To learn you must...","To approve the students must...","In the future"));
      modules.add(new ModuleKA(3, "To learn you must...","To approve the students must...","In the future"));
      
*/
      
      Module module1 = new Module();
      module1.setName("Modul 1");
      module1.setLearningGoals("Dette er læringsmål for modul 1");
      module1.setId(1);
      modules.add(module1);
      
      calendar.set(2015, 3, 14);
      Module module2 = new Module();
      module2.setName("Modul 2");
      module2.setLearningGoals("Dette er læringsmål for modul 2");
      module2.setId(2);
      module2.setDeadline(calendar.getTime());
      modules.add(module2);
      
      Module module3 = new Module();
      module3.setName("Modul 3");
      module3.setLearningGoals("Dette er læringsmål for modul 3");
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
      
      ArrayList<Module> modules = getModules();
   
      int z = 0;
      while(z<modules.size()){
      
          if(modules.get(z).getId()==i){
              
              return modules.get(z);
             
          }
          
      z++;
      
        }
      return null;
  } 
      
   public TimeZone getTimeZone() {
     return TimeZone.getDefault();
}
 
}
