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
@NamedQuery(name="AdminGroupe.findByAdminUserGroupe",
        query="SELECT a FROM AdminGroupe a"
            		+ " WHERE a.AdminUser.IdUser= :IdUser AND a.Groupe.IdGroup=:IdGroup"),
})
public class AdminGroupe extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdAdminGroup;
	@ManyToOne
	private User AdminUser;
	@ManyToOne
	private Groupe Groupe;
	public AdminGroupe(int idAdminGroup, User adminUser, org.ws.entities.Groupe groupe) {
		super();
		IdAdminGroup = idAdminGroup;
		AdminUser = adminUser;
		Groupe = groupe;
	}
	public AdminGroupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminGroupe(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public int getIdAdminGroup() {
		return IdAdminGroup;
	}
	public void setIdAdminGroup(int idAdminGroup) {
		IdAdminGroup = idAdminGroup;
	}
	public User getAdminUser() {
		return AdminUser;
	}
	public void setAdminUser(User adminUser) {
		AdminUser = adminUser;
	}
	public Groupe getGroupe() {
		return Groupe;
	}
	public void setGroupe(Groupe groupe) {
		Groupe = groupe;
	}
	
}
