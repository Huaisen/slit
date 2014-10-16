/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.redirect;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import no.uia.slit.auth.AuthGroup;
import no.uia.slit.auth.AuthInfoBean;
import no.uia.slit.auth.AuthPersistenceService;
import no.uia.slit.auth.AuthUser;
import no.uia.slit.web.JsfUtils;

/**
 *
 * @author kristianandersson
 */

@Named("bean")
@SessionScoped


public class RedirectBean implements Serializable {
        @EJB private AuthPersistenceService authDb;


    public RedirectBean(){
        
        
    }
    

    public void check() throws IOException {
   
         String userName = JsfUtils.getUserName();
        String highestUserGroup = "student";

        if (null != userName && !(userName.equals(""))) {
            AuthUser user = authDb.findUser(userName);
            if (null != user) {
                
                
                for (AuthGroup g : user.getGroups()) {
                    switch (g.name()) {
                        case "admin":
                            highestUserGroup = g.name();
                            break;
                        case "teacher":
                            if(!highestUserGroup.equals("admin")){
                            highestUserGroup = g.name();
                            }
                            break;
                       /* case "student":
                            if(!highestUserGroup.equals("teacher") || !highestUserGroup.equals("admin")){
                            highestUserGroup = g.name();
                            }
                            break;  */   
                    }
         
                }
            }
        }
   
     if(!highestUserGroup.equals("")){ 
   
  
        //FacesContext.getCurrentInstance().getExternalContext().redirect(userGroup + "/index.xhtml");
    FacesContext.getCurrentInstance().getExternalContext().redirect(highestUserGroup + "/index.xhtml");
     }
     else{
         
         FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
         
     }
           
     } 
    

}