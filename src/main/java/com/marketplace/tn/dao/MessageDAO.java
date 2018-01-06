package com.marketplace.tn.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketplace.tn.model.Message;
@Transactional
@Repository
public class MessageDAO implements IMessageDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Message getMessageById(int messageId) {
		return entityManager.find(Message.class, messageId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getAllMessages() {
		String hql = "FROM Message as atcl ORDER BY atcl.messageId DESC";
		return (List<Message>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createMessage(Message message) {
		entityManager.persist(message);
	}
	
	
	@Override
	public boolean messageExists(int source_msg, int destinataire_msg,String contenu_msg) {
		String hql = "FROM Message as atcl WHERE atcl.source_msg = ? and atcl.destinataire_msg = ? and atcl.contenu_msg = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, source_msg)
		              .setParameter(2, destinataire_msg).setParameter(3, contenu_msg)
		              .getResultList().size();
		return count > 0 ? true : false;		
	}

	@Override
	public void deleteMessage(int messageId) {
		entityManager.remove(getMessageById(messageId));
	}
	
}
