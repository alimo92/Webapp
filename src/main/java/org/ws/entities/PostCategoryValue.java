package org.ws.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
//@NamedQueries({
//@NamedQuery(name="NotificationType.findByType",
//      query="SELECT nt FROM NotificationType nt"
//          		+ " WHERE nt.TypeNotification = :TypeNotification"),
//})
public class PostCategoryValue extends GenericEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdPostCategoryValue;
	@ManyToOne
	private Post Post;
	@ManyToOne
	private CategoryValue CategoryValue;
	public PostCategoryValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostCategoryValue(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public PostCategoryValue(int idPostCategoryValue, org.ws.entities.Post post,
			org.ws.entities.CategoryValue categoryValue) {
		super();
		IdPostCategoryValue = idPostCategoryValue;
		Post = post;
		CategoryValue = categoryValue;
	}
	public int getIdPostCategoryValue() {
		return IdPostCategoryValue;
	}
	public void setIdPostCategoryValue(int idPostCategoryValue) {
		IdPostCategoryValue = idPostCategoryValue;
	}
	public Post getPost() {
		return Post;
	}
	public void setPost(Post post) {
		Post = post;
	}
	public CategoryValue getCategoryValue() {
		return CategoryValue;
	}
	public void setCategoryValue(CategoryValue categoryValue) {
		CategoryValue = categoryValue;
	}
}
