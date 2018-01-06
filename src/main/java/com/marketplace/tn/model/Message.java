package com.marketplace.tn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="messages")
public class Message implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_msg")
    private int messageId;  
	@Column(name="source_msg ")
    private int source_msg ;
	@Column(name="destinataire_msg")	
	private int destinataire_msg;
	@Column(name="contenu_msg")	
	private String contenu_msg ;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	
	
	public int getSource_msg() {
		return source_msg;
	}
	public void setSource_msg(int source_msg) {
		this.source_msg = source_msg;
	}
	public int getDestinataire_msg() {
		return destinataire_msg;
	}
	public void setDestinataire_msg(int destinataire_msg) {
		this.destinataire_msg = destinataire_msg;
	}
	public String getContenu_msg() {
		return contenu_msg;
	}
	public void setContenu_msg(String contenu_msg) {
		this.contenu_msg = contenu_msg;
	}
	
	
}
