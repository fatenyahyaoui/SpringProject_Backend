package com.marketplace.tn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.tn.dao.IMessageDAO;
import com.marketplace.tn.model.Message;
@Service
public class MessageService implements IMessageService {
	@Autowired
	private IMessageDAO messageDAO;
	@Override
	public Message getMessageById(int messageId) {
		Message obj = messageDAO.getMessageById(messageId);
		return obj;
	}	
	@Override
	public List<Message> getAllMessages(){
		return messageDAO.getAllMessages();
	}
	@Override
	public synchronized boolean createMessage(Message message){
       if (messageDAO.messageExists(message.getSource_msg(), message.getDestinataire_msg(), message.getContenu_msg())) {
    	   return false;
       } else {
    	   messageDAO.createMessage(message);
    	   return true;
       }
	}

	
	
	@Override
	public void deleteMessage(int messageId) {
		messageDAO.deleteMessage(messageId);
	}
}
