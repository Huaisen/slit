/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.sondre;



import java.util.ArrayList;
import javax.inject.Named;

/**
 *
 * @author sondre
 */
@Named("sondrebean")

public class SondreBean  {
 
private ArrayList<Studenterne> stud;
public SondreBean(){}

public ArrayList<Studenterne> Student(){
    
    
    stud = new ArrayList<>();
    
    stud.add(new Studenterne(101, "Navn1", "Epost1" )); 
    stud.add(new Studenterne(102, "Navn2", "Epost2" )); 
    stud.add(new Studenterne(103, "Navn3", "Epost3" ));
    stud.add(new Studenterne(104, "Navn4", "Epost4" )); 
    stud.add(new Studenterne(105, "Navn5", "Epost5" ));
    stud.add(new Studenterne(106, "Navn6", "Epost6" )); 
    stud.add(new Studenterne(107, "Navn7", "Epost7" )); 
    stud.add(new Studenterne(108, "Navn8", "Epost8" ));
    stud.add(new Studenterne(109, "Navn9", "Epost9" )); 
    stud.add(new Studenterne(110, "Navn10", "Epost10" ));
    
    
    return stud;
}






}