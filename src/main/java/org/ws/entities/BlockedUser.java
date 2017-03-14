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
@NamedQuery(name="BlockedUser.findByUserAndBlocked",
        query="SELECT a FROM BlockedUser a"
            		+ "  WHERE a.User.IdUser = :IdUser And a.BlockedUser.IdUser=:IdBlocked"),
})
public class BlockedUser extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdBlockedUser;	
	@ManyToOne
	private User BlockedUser;
	private String ReasonBlockedUser;
    @ManyToOne
	private User User;
	public BlockedUser(int idBlockedUser, org.ws.entities.User blockedUser, String reasonBlockedUser,
			org.ws.entities.User user) {
		super();
		IdBlockedUser = idBlockedUser;
		BlockedUser = blockedUser;
		ReasonBlockedUser = reasonBlockedUser;
		User = user;
	}
	public BlockedUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlockedUser(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public int getIdBlockedUser() {
		return IdBlockedUser;
	}
	public void setIdBlockedUser(int idBlockedUser) {
		IdBlockedUser = idBlockedUser;
	}
	public User getBlockedUser() {
		return BlockedUser;
	}
	public void setBlockedUser(User blockedUser) {
		BlockedUser = blockedUser;
	}
	public String getReasonBlockedUser() {
		return ReasonBlockedUser;
	}
	public void setReasonBlockedUser(String reasonBlockedUser) {
		ReasonBlockedUser = reasonBlockedUser;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
}
