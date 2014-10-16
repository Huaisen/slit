/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.simon;
import java.util.ArrayList;
import javax.inject.Named;
/**
 *
 * @author Simon
 */
@Named("simonBean")
public class Simon {

//fields
private ArrayList<PlanEntry> plan;
//Constructor
public Simon()
{
}



  
  


/* lager en ny plan for studentX */

 public ArrayList<PlanEntry> getPlan(){
      
      plan = new ArrayList<>();
      
    
      plan.add(new PlanEntry( 1, 1, "15. Januar", "30. Januar", null, " Dager"));
      plan.add(new PlanEntry( 1, 2, "30. Januar", "15. Februar", null, " Dager"));
      plan.add(new PlanEntry( 1, 3, "15. Februar", "30. Februar", null, " Dager"));
      plan.add(new PlanEntry( 1, 4, "30. Februar", "15. Mars", null, " Dager"));
      plan.add(new PlanEntry( 1, 5, "15. Mars", "30. Mars", null, " Dager"));
      plan.add(new PlanEntry( 1, 6, "30. Mars", "15. April", null, " Dager"));
      
      

    return plan;

    

    
  }















}