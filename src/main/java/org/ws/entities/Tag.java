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
@NamedQuery(name="Tag.findTagByUserTaggedPost",
        query="SELECT t FROM Tag t"
            		+ " WHERE t.User.IdUser= :IdUser AND t.Tagged.IdUser=:IdTagged AND t.Post.IdPost=:IdPost"),
})
public class Tag extends GenericEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdTag;
	@ManyToOne
	private User Tagged;
	@ManyToOne
	private Post Post;
	@ManyToOne
	private User User;
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tag(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public Tag(int idTag, org.ws.entities.User tagged, org.ws.entities.Post post, org.ws.entities.User user) {
		super();
		IdTag = idTag;
		Tagged = tagged;
		Post = post;
		User = user;
	}
	public int getIdTag() {
		return IdTag;
	}
	public void setIdTag(int idTag) {
		IdTag = idTag;
	}
	public User getTagged() {
		return Tagged;
	}
	public void setTagged(User tagged) {
		Tagged = tagged;
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
