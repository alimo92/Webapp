package org.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
//@NamedQueries({
//@NamedQuery(name="NotificationType.findByType",
//        query="SELECT nt FROM NotificationType nt"
//            		+ " WHERE nt.TypeNotification = :TypeNotification"),
//})
public class Category extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdCategory;
	private String Category;
	@OneToMany(mappedBy="Category")
	private Collection<CategoryValue> CategoryValues;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public Category(int idCategory, String category, Collection<CategoryValue> categoryValues) {
		super();
		IdCategory = idCategory;
		Category = category;
		CategoryValues = categoryValues;
	}
	public int getIdCategory() {
		return IdCategory;
	}
	public void setIdCategory(int idCategory) {
		IdCategory = idCategory;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public Collection<CategoryValue> getCategoryValues() {
		return CategoryValues;
	}
	public void setCategoryValues(Collection<CategoryValue> categoryValues) {
		CategoryValues = categoryValues;
	}
}
