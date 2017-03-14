package org.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;



@Entity
@NamedQueries({
	@NamedQuery(name="NotificationType.findByType",
            query="SELECT nt FROM NotificationType nt"
                		+ " WHERE nt.TypeNotification = :TypeNotification"),
})
@JsonRootName(value = "NotificationType")
public class NotificationType extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdNotificationType;
	private String TypeNotification;
	
	@OneToMany(mappedBy="NotificationType")
	private Collection<Notification> Notifications;
	public NotificationType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotificationType(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public NotificationType(int idNotificationType, String typeNotification, Collection<Notification> notifications) {
		super();
		IdNotificationType = idNotificationType;
		TypeNotification = typeNotification;
		Notifications = notifications;
	}
	public int getIdNotificationType() {
		return IdNotificationType;
	}
	public void setIdNotificationType(int idNotificationType) {
		IdNotificationType = idNotificationType;
	}

	public String getTypeNotification() {
		return TypeNotification;
	}
	public void setTypeNotification(String typeNotification) {
		TypeNotification = typeNotification;
	}
	@JsonIgnore
	public Collection<Notification> getNotifications() {
		return Notifications;
	}

	public void setNotifications(Collection<Notification> notifications) {
		Notifications = notifications;
	}
	
	public JSONObject GetJSON() throws JSONException{
		JSONObject object = new JSONObject();
		object.put("IdNotificationType", this.IdNotificationType);
		object.put("TypeNotification", this.TypeNotification);
		object.put("DateCreated", this.getDateCreated());
		return object;
	}
	
	
}
