package org.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
//@NamedQueries({
//@NamedQuery(name="NotificationType.findByType",
//        query="SELECT nt FROM NotificationType nt"
//            		+ " WHERE nt.TypeNotification = :TypeNotification"),
//})
public class Location extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdLocation;
	private String NameLocation;
	private double LatitudeLocation;
	private double LongitudeLocation;
	@OneToMany(mappedBy="LocationPost")
	private Collection<Post> Posts;
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public Location(int idLocation, String nameLocation, double latitudeLocation, double longitudeLocation,
			Collection<Post> posts) {
		super();
		IdLocation = idLocation;
		NameLocation = nameLocation;
		LatitudeLocation = latitudeLocation;
		LongitudeLocation = longitudeLocation;
		Posts = posts;
	}
	public int getIdLocation() {
		return IdLocation;
	}
	public void setIdLocation(int idLocation) {
		IdLocation = idLocation;
	}
	public String getNameLocation() {
		return NameLocation;
	}
	public void setNameLocation(String nameLocation) {
		NameLocation = nameLocation;
	}
	public double getLatitudeLocation() {
		return LatitudeLocation;
	}
	public void setLatitudeLocation(double latitudeLocation) {
		LatitudeLocation = latitudeLocation;
	}
	public double getLongitudeLocation() {
		return LongitudeLocation;
	}
	public void setLongitudeLocation(double longitudeLocation) {
		LongitudeLocation = longitudeLocation;
	}
	public Collection<Post> getPosts() {
		return Posts;
	}
	public void setPosts(Collection<Post> posts) {
		Posts = posts;
	}
	
}
