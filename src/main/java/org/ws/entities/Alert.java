package org.ws.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
//@NamedQueries({
//@NamedQuery(name="NotificationType.findByType",
//        query="SELECT nt FROM NotificationType nt"
//            		+ " WHERE nt.TypeNotification = :TypeNotification"),
//})
public class Alert extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdAlert;
	private String NameAlert;
	@ManyToOne
	private User User;
	@ManyToMany(mappedBy="Alerts")
	private Collection<CategoryValue> CategoryValue;
}
