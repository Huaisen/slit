/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package no.uia.slit.huai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.inject.New;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Administrator
 */
@Named ("huaiBean")
@ApplicationScoped

public class huaiBean {
    private static final long serialVersionUID = 1L;
    private DeliverableComment deliverableComment  ;
    private ArrayList<DeliverableComment> deliverableComments;
    


    public ArrayList<DeliverableComment> getDeliverables(){
   deliverableComment = new DeliverableComment("1","01","001","30.09.2014","This is a nice delivery.....");
   deliverableComments = new ArrayList<DeliverableComment>();
     
   
   return deliverableComments;
    }

    public DeliverableComment getDeliverableComment() {
        return deliverableComment;
    }

    public void setDeliverableComment(DeliverableComment deliverableComment) {
        this.deliverableComment = deliverableComment;
    }

    public ArrayList<DeliverableComment> getDeliverableComments() {
        return deliverableComments;
    }

    public void setDeliverableComments(ArrayList<DeliverableComment> deliverableComments) {
        this.deliverableComments = deliverableComments;
    }
    
}