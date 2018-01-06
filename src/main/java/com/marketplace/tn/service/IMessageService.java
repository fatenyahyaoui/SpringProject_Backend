package com.marketplace.tn.service;

import java.util.List;

import com.marketplace.tn.model.Message;

public interface IMessageService {
     List<Message> getAllMessages();
     Message getMessageById(int messageId);
     boolean createMessage(Message message);
     
     void deleteMessage(int messageId);
}
