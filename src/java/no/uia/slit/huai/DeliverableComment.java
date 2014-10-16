/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package no.uia.slit.huai;


/**
 *
 * @author Administrator
 */
public class DeliverableComment {
    private String ID;
    private String UserID;
    private String DeliverableID;
    private String DateTime;
    private String Text;
    
    public DeliverableComment(String ID,String UserID,String DeliverableID,String DateTime, String Text) {
    
        this.ID=ID;
        this.UserID=UserID;
        this.DeliverableID=DeliverableID;
        this.DateTime=DateTime;
        this.Text=Text;
        
        
        
}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getDeliverableID() {
        return DeliverableID;
    }

    public void setDeliverableID(String DeliverableID) {
        this.DeliverableID = DeliverableID;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String DateTime) {
        this.DateTime = DateTime;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }
    
    
}
