package org.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity
@NamedQueries({
@NamedQuery(name="GroupeMessage.findByGroupe",
        query="SELECT mg FROM GroupeMessage mg"
            		+ " WHERE mg.Groupe.IdGroup = :Groupe"),
})
public class GroupeMessage extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdGroupMessage;
	private String ContentGroupMessage;
	@ManyToOne
	private User User;
	@ManyToOne
	private Groupe Groupe;
	public GroupeMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupeMessage(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public GroupeMessage(int idGroupMessage, String contentGroupMessage, org.ws.entities.User user,
			org.ws.entities.Groupe groupe) {
		super();
		IdGroupMessage = idGroupMessage;
		ContentGroupMessage = contentGroupMessage;
		User = user;
		Groupe = groupe;
	}
	public GroupeMessage(int idGroupMessage, String contentGroupMessage) {
		super();
		IdGroupMessage = idGroupMessage;
		ContentGroupMessage = contentGroupMessage;
	}
	public int getIdGroupMessage() {
		return IdGroupMessage;
	}
	public void setIdGroupMessage(int idGroupMessage) {
		IdGroupMessage = idGroupMessage;
	}
	public String getContentGroupMessage() {
		return ContentGroupMessage;
	}
	public void setContentGroupMessage(String contentGroupMessage) {
		ContentGroupMessage = contentGroupMessage;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public Groupe getGroupe() {
		return Groupe;
	}
	public void setGroupe(Groupe groupe) {
		Groupe = groupe;
	}
}
