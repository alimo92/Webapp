package org.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
//@NamedQueries({
//@NamedQuery(name="NotificationType.findByType",
//        query="SELECT nt FROM NotificationType nt"
//            		+ " WHERE nt.TypeNotification = :TypeNotification"),
//})
public class Message extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdMessage;
	private String ContentMessage;
	@ManyToOne
	private Conversation Conversation;
	@ManyToOne
	private User User;
	public Message(int idMessage, String contentMessage, org.ws.entities.Conversation conversation,
			org.ws.entities.User user) {
		super();
		IdMessage = idMessage;
		ContentMessage = contentMessage;
		Conversation = conversation;
		User = user;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public int getIdMessage() {
		return IdMessage;
	}
	public void setIdMessage(int idMessage) {
		IdMessage = idMessage;
	}
	public String getContentMessage() {
		return ContentMessage;
	}
	public void setContentMessage(String contentMessage) {
		ContentMessage = contentMessage;
	}
	public Conversation getConversation() {
		return Conversation;
	}
	public void setConversation(Conversation conversation) {
		Conversation = conversation;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	
}
