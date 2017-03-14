package org.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;

@Entity
//@NamedQueries({
//@NamedQuery(name="NotificationType.findByType",
//        query="SELECT nt FROM NotificationType nt"
//            		+ " WHERE nt.TypeNotification = :TypeNotification"),
//})
public class Notification extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdNotification;
	private String ContentNotification;
	@ManyToOne
	private User User;
	@ManyToOne
	private NotificationType NotificationType;
	
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public Notification(int idNotification, String contentNotification, org.ws.entities.User user,
			org.ws.entities.NotificationType notificationType) {
		super();
		IdNotification = idNotification;
		ContentNotification = contentNotification;
		User = user;
		NotificationType = notificationType;
	}
	public int getIdNotification() {
		return IdNotification;
	}
	public void setIdNotification(int idNotification) {
		IdNotification = idNotification;
	}
	public String getContentNotification() {
		return ContentNotification;
	}
	public void setContentNotification(String contentNotification) {
		ContentNotification = contentNotification;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public NotificationType getNotificationType() {
		return NotificationType;
	}
	public void setNotificationType(NotificationType notificationType) {
		NotificationType = notificationType;
	}
}
