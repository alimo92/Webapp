package org.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
//@NamedQueries({
//@NamedQuery(name="NotificationType.findByType",
//        query="SELECT nt FROM NotificationType nt"
//            		+ " WHERE nt.TypeNotification = :TypeNotification"),
//})
public class Comment extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdComment;
	private String ContentComment;
	@ManyToOne
	private Post Post;
	@ManyToOne
	private User User;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public Comment(int idComment, String contentComment, org.ws.entities.Post post, org.ws.entities.User user) {
		super();
		IdComment = idComment;
		ContentComment = contentComment;
		Post = post;
		User = user;
	}
	public int getIdComment() {
		return IdComment;
	}
	public void setIdComment(int idComment) {
		IdComment = idComment;
	}
	public String getContentComment() {
		return ContentComment;
	}
	public void setContentComment(String contentComment) {
		ContentComment = contentComment;
	}
	public Post getPost() {
		return Post;
	}
	public void setPost(Post post) {
		Post = post;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
}
