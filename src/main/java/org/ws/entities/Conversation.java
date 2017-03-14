package org.ws.entities;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
@NamedQuery(name="Conversation.findByNameConversation",
        query="SELECT cu FROM Conversation cu"
            		+ " WHERE cu.NameConversation = :NameConversation"),
@NamedQuery(name="Conversation.findByfUser",
		query="SELECT cu FROM Conversation cu "
				+ "JOIN cu.ConversationUsers a "
					+ " WHERE a.User.IdUser = :IdUser"),
})
public class Conversation extends GenericEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int IdConversation;
	private String NameConversation;
	@OneToMany(mappedBy="Conversation")
	private Collection<ConversationUser> ConversationUsers;
	@OneToMany(mappedBy="Conversation")
	private Collection<Message> Messages;
	public Conversation(int idConversation, String nameConversation, Collection<ConversationUser> conversationUsers,
			Collection<Message> messages) {
		super();
		IdConversation = idConversation;
		NameConversation = nameConversation;
		ConversationUsers = conversationUsers;
		Messages = messages;
	}
	public Conversation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conversation(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public int getIdConversation() {
		return IdConversation;
	}
	public void setIdConversation(int idConversation) {
		IdConversation = idConversation;
	}
	public String getNameConversation() {
		return NameConversation;
	}
	public void setNameConversation(String nameConversation) {
		NameConversation = nameConversation;
	}
	public Collection<ConversationUser> getConversationUsers() {
		return ConversationUsers;
	}
	public void setConversationUsers(Collection<ConversationUser> conversationUsers) {
		ConversationUsers = conversationUsers;
	}
	public Collection<Message> getMessages() {
		return Messages;
	}
	public void setMessages(Collection<Message> messages) {
		Messages = messages;
	}
	
}
