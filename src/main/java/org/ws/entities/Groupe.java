package org.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@NamedQueries({
@NamedQuery(name="Groupe.findCreatedByUser",
        query="SELECT g FROM Groupe g"
            		+ " WHERE g.CreatorGroup = :CreatorGroup ORDER BY g.IdGroup DESC"),
})
public class Groupe extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdGroup;
	private String NameGroup;
	private int CreatorGroup;
	@OneToMany(mappedBy="Groupe")
	private Collection<GroupeUser> GroupeUser;
	@OneToMany(mappedBy="Groupe")
	private Collection<AdminGroupe> GroupeAdmins;
	@OneToMany(mappedBy="Groupe")
	private Collection<GroupeMessage> GroupMessages;
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groupe(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}

	public Groupe(int idGroup, String nameGroup, int creatorGroup, Collection<org.ws.entities.GroupeUser> groupeUser,
			Collection<AdminGroupe> groupeAdmins, Collection<GroupeMessage> groupMessages) {
		super();
		IdGroup = idGroup;
		NameGroup = nameGroup;
		CreatorGroup = creatorGroup;
		GroupeUser = groupeUser;
		GroupeAdmins = groupeAdmins;
		GroupMessages = groupMessages;
	}
	public Groupe(int idGroup, String nameGroup) {
		super();
		IdGroup = idGroup;
		NameGroup = nameGroup;
	}
	public int getIdGroup() {
		return IdGroup;
	}
	public void setIdGroup(int idGroup) {
		IdGroup = idGroup;
	}
	public String getNameGroup() {
		return NameGroup;
	}
	public void setNameGroup(String nameGroup) {
		NameGroup = nameGroup;
	}
	public int getCreatorGroup() {
		return CreatorGroup;
	}
	public void setCreatorGroup(int creatorGroup) {
		CreatorGroup = creatorGroup;
	}

	public Collection<AdminGroupe> getGroupeAdmins() {
		return GroupeAdmins;
	}
	public void setGroupeAdmins(Collection<AdminGroupe> groupeAdmins) {
		GroupeAdmins = groupeAdmins;
	}
	public Collection<GroupeMessage> getGroupMessages() {
		return GroupMessages;
	}
	public void setGroupMessages(Collection<GroupeMessage> groupMessages) {
		GroupMessages = groupMessages;
	}
	
}
