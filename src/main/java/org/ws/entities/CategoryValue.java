package org.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
//@NamedQueries({
//@NamedQuery(name="NotificationType.findByType",
//        query="SELECT nt FROM NotificationType nt"
//            		+ " WHERE nt.TypeNotification = :TypeNotification"),
//})
public class CategoryValue extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdCategoryValue; 
	private String CategoryValue;
	@ManyToOne
	private Category Category;
	@OneToMany(mappedBy="CategoryValue")
	private Collection<PostCategoryValue> Posts;
	@ManyToMany
	@JoinTable(name="Alert_CategoryValue")
	private Collection<Alert> Alerts;
	public CategoryValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryValue(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public CategoryValue(int idCategoryValue, String categoryValue, org.ws.entities.Category category,
			Collection<PostCategoryValue> posts, Collection<Alert> alerts) {
		super();
		IdCategoryValue = idCategoryValue;
		CategoryValue = categoryValue;
		Category = category;
		Posts = posts;
		Alerts = alerts;
	}
	public int getIdCategoryValue() {
		return IdCategoryValue;
	}
	public void setIdCategoryValue(int idCategoryValue) {
		IdCategoryValue = idCategoryValue;
	}
	public String getCategoryValue() {
		return CategoryValue;
	}
	public void setCategoryValue(String categoryValue) {
		CategoryValue = categoryValue;
	}
	public Category getCategory() {
		return Category;
	}
	public void setCategory(Category category) {
		Category = category;
	}
	public Collection<PostCategoryValue> getPosts() {
		return Posts;
	}
	public void setPosts(Collection<PostCategoryValue> posts) {
		Posts = posts;
	}
	public Collection<Alert> getAlerts() {
		return Alerts;
	}
	public void setAlerts(Collection<Alert> alerts) {
		Alerts = alerts;
	}
}
