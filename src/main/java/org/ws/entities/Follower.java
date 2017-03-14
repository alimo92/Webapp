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
@NamedQuery(name="Follower.findByUserAndFollowed",
        query="SELECT f FROM Follower f"
            		+ " WHERE f.User.IdUser = :User And f.Followed.IdUser=:Followed"),
})
public class Follower extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdFollower;
	@ManyToOne
	private User Followed;
	@ManyToOne
	private User User;
	public Follower() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Follower(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public Follower(int idFollower, org.ws.entities.User followed, org.ws.entities.User user) {
		super();
		IdFollower = idFollower;
		Followed = followed;
		User = user;
	}
	public int getIdFollower() {
		return IdFollower;
	}
	public void setIdFollower(int idFollower) {
		IdFollower = idFollower;
	}
	public User getFollowed() {
		return Followed;
	}
	public void setFollowed(User followed) {
		Followed = followed;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	
	
}
