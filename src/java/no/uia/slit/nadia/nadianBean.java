/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package no.uia.slit.nadia;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author Nadia
 */
@Named ("nadianBean")
public class nadianBean { 
    
    private ArrayList<Deliverable> deliverables;
    public nadianBean(){
        
    }
    public ArrayList<Deliverable> getDeliverables(){
    
        deliverables = new ArrayList<>();
        
        deliverables.add(new Deliverable(1,1,"Planen....",1300,"Godkjent"));
        deliverables.add(new Deliverable(2,1,"Planen...",1400,"Godkjent"));
        deliverables.add(new Deliverable(3,1,"Planen...",1430,"Godkjent"));
        deliverables.add(new Deliverable(4,1,"Planen..",1830,"Godkjent"));
        deliverables.add(new Deliverable(5,1,"Planen ...",1500,"Ikke Godkjent"));
  
        
        return deliverables;
    }
    
    
        
    }
