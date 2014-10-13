/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.kristian;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author kristianandersson
 */

@Named("kristianBean")
public class KristianBean {
   
    
    private ArrayList<ModuleKA> modules;
    public KristianBean(){
        
        
    }
    
    
  public ArrayList<ModuleKA> getModules(){
      
      modules = new ArrayList<>();
      
      /* Dummy data. Should be replaced with call to DB */
      modules.add(new ModuleKA(1, "To learn you must...","To approve the students must...","In the future"));
      modules.add(new ModuleKA(2, "To learn you must...","To approve the students must...","In the future"));
      modules.add(new ModuleKA(3, "To learn you must...","To approve the students must...","In the future"));
      

    return modules;
            
  }
    
}
