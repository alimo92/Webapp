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
@NamedQuery(name="Rating.findByUserPost",
        query="SELECT nt FROM Rating nt"
            		+ " WHERE nt.User.IdUser = :IdUser AND nt.PostRating.IdPost=:IdPost"),
})
public class Rating extends GenericEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdRating;
	private int RatingValue;
	@ManyToOne
	private Post PostRating;
	@ManyToOne
	private User User;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public Rating(int idRating, int ratingValue, Post postRating, org.ws.entities.User user) {
		super();
		IdRating = idRating;
		RatingValue = ratingValue;
		PostRating = postRating;
		User = user;
	}
	public int getIdRating() {
		return IdRating;
	}
	public void setIdRating(int idRating) {
		IdRating = idRating;
	}
	public int getRatingValue() {
		return RatingValue;
	}
	public void setRatingValue(int ratingValue) {
		RatingValue = ratingValue;
	}
	public Post getPostRating() {
		return PostRating;
	}
	public void setPostRating(Post postRating) {
		PostRating = postRating;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
}