/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.web;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author kristianandersson
 */
    @FacesValidator("dateRangeValidator")
public class DateRangeValidator implements Validator{
    
   @Override
   public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException{
     
       if (value == null) {
            return; // Let required="true" handle.
        }

        UIInput planDateComponent = (UIInput) component.getAttributes().get("planDateComponent");
        UIInput moduleDateComponent = (UIInput) component.getAttributes().get("moduleDateComponent");

        if (!planDateComponent.isValid()) {
            return; // Already invalidated. Don't care about it then.
        }
        if (!moduleDateComponent.isValid()) {
            return; // Already invalidated. Don't care about it then.
        }

        Date startDate = (Date) value;
        Date endDate = (Date) moduleDateComponent.getValue();
    
     
        if (endDate == null) {
            return; // Let required="true" handle.
        }

        if (startDate.after(endDate)) {
            planDateComponent.setValid(false);
            throw new ValidatorException(new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "Feil: Dato må være før modulets deadline", null));
        }
       
   }
  
}
