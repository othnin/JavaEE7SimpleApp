/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author achilles
 */
@Named(value = "MessageView")
//@ManagedBean(name="MessageView") deprecated
@RequestScoped
public class MessageView {

    //create a new field
    private Message message;
    @EJB
    private MessageFacade messageFacade;

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.message = new Message();
    }
    
    //calls getMessage to retrieve the message
    public Message getMessage() {
        return message;
    }
    
    //return the total number of message
    public int getNumberOfMessages() {
        return messageFacade.findAll().size();
    }
    
    //saves the message and then returns the string "theend"
    public String postMessage() {
        this.messageFacade.create(message);
        return "theend";
    }
    
}
