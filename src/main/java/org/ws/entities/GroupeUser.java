package org.ws.entities;

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
@NamedQuery(name="GroupeUser.findUserAdded",
        query="SELECT gu FROM GroupeUser gu"
            		+ " WHERE gu.Groupe.IdGroup = :IdGroup And gu.User.IdUser= :IdUser"),
})
public class GroupeUser extends GenericEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdGroupeUser;
	@ManyToOne
	private User User;
	@ManyToOne
	private Groupe Groupe;
	public GroupeUser(int idGroupeUser, org.ws.entities.User user, org.ws.entities.Groupe groupe) {
		super();
		IdGroupeUser = idGroupeUser;
		User = user;
		Groupe = groupe;
	}
	public GroupeUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupeUser(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public int getIdGroupeUser() {
		return IdGroupeUser;
	}
	public void setIdGroupeUser(int idGroupeUser) {
		IdGroupeUser = idGroupeUser;
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
