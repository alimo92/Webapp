package org.ws.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
//@NamedQueries({
//@NamedQuery(name="NotificationType.findByType",
//      query="SELECT nt FROM NotificationType nt"
//          		+ " WHERE nt.TypeNotification = :TypeNotification"),
//})
public class ConversationUser extends GenericEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdConversationUser;
	@ManyToOne
	private Conversation Conversation;
	@ManyToOne
	private User User;
	public ConversationUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConversationUser(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public ConversationUser(int idConversationUser, org.ws.entities.Conversation conversation,
			org.ws.entities.User user) {
		super();
		IdConversationUser = idConversationUser;
		Conversation = conversation;
		User = user;
	}
	public int getIdConversationUser() {
		return IdConversationUser;
	}
	public void setIdConversationUser(int idConversationUser) {
		IdConversationUser = idConversationUser;
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
