package com.marketplace.tn.dao;
import java.util.List;

import com.marketplace.tn.model.*;
public interface IMessageDAO {
    List<Message> getAllMessages();
    Message getMessageById(int messageId);
    void createMessage(Message message);
    
    void deleteMessage(int messageId);
    boolean messageExists(int source_msg, int destinataire_msg,String contenu_msg);
    
}
 