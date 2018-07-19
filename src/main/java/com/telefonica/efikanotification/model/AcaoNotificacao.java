/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikanotification.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author A0077749
 */
//@Document(collection = "acaonotificacao")
public class AcaoNotificacao {
    
    private boolean action;
    private String namebutton;
    private ColorEnum colorbutton;
    private String linkref;

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getNamebutton() {
        return namebutton;
    }

    public void setNamebutton(String namebutton) {
        this.namebutton = namebutton;
    }

    public ColorEnum getColorbutton() {
        return colorbutton;
    }

    public void setColorbutton(ColorEnum colorbutton) {
        this.colorbutton = colorbutton;
    }

    public String getLinkref() {
        return linkref;
    }

    public void setLinkref(String linkref) {
        this.linkref = linkref;
    }
    
    
}
