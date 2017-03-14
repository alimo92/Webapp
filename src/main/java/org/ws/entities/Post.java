package org.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity
@NamedQueries({
@NamedQuery(name="Post.findLastPostOfUser",
        query="SELECT p FROM Post p"
            		+ " WHERE p.User.IdUser = :IdUser Order By p.IdPost DESC"),
})
public class Post extends GenericEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdPost;
	private String TitlePost;
	private String DescriptionPost;
	private String ImagePost;
	@ManyToOne
	private User User;
	@ManyToOne
	private Location LocationPost;
	@OneToMany(mappedBy="PostRating")
	private Collection<Rating> RatingsPost;
	@OneToMany(mappedBy="Post")
	private Collection<Comment> CommentsPost;
	@OneToMany(mappedBy="Post")
	private Collection<Tag> TagsPost;
	@OneToMany(mappedBy="Tagged")
	private Collection<Tag> Tags;
	@OneToMany(mappedBy="Post")
	private Collection<PostCategoryValue> PostCategoryValues;
	@OneToMany(mappedBy="Post")
	private Collection<ReportPost> ReportsPost;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}
	public Post(int idPost, String titlePost, String descriptionPost, String imagePost, org.ws.entities.User user,
			Location locationPost, Collection<Rating> ratingsPost, Collection<Comment> commentsPost,
			Collection<Tag> tagsPost, Collection<Tag> tags, Collection<PostCategoryValue> postCategoryValues,
			Collection<ReportPost> reportsPost) {
		super();
		IdPost = idPost;
		TitlePost = titlePost;
		DescriptionPost = descriptionPost;
		ImagePost = imagePost;
		User = user;
		LocationPost = locationPost;
		RatingsPost = ratingsPost;
		CommentsPost = commentsPost;
		TagsPost = tagsPost;
		Tags = tags;
		PostCategoryValues = postCategoryValues;
		ReportsPost = reportsPost;
	}
	public int getIdPost() {
		return IdPost;
	}
	public void setIdPost(int idPost) {
		IdPost = idPost;
	}
	public String getTitlePost() {
		return TitlePost;
	}
	public void setTitlePost(String titlePost) {
		TitlePost = titlePost;
	}
	public String getDescriptionPost() {
		return DescriptionPost;
	}
	public void setDescriptionPost(String descriptionPost) {
		DescriptionPost = descriptionPost;
	}
	public String getImagePost() {
		return ImagePost;
	}
	public void setImagePost(String imagePost) {
		ImagePost = imagePost;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public Location getLocationPost() {
		return LocationPost;
	}
	public void setLocationPost(Location locationPost) {
		LocationPost = locationPost;
	}
	public Collection<Rating> getRatingsPost() {
		return RatingsPost;
	}
	public void setRatingsPost(Collection<Rating> ratingsPost) {
		RatingsPost = ratingsPost;
	}
	public Collection<Comment> getCommentsPost() {
		return CommentsPost;
	}
	public void setCommentsPost(Collection<Comment> commentsPost) {
		CommentsPost = commentsPost;
	}
	public Collection<Tag> getTagsPost() {
		return TagsPost;
	}
	public void setTagsPost(Collection<Tag> tagsPost) {
		TagsPost = tagsPost;
	}
	public Collection<Tag> getTags() {
		return Tags;
	}
	public void setTags(Collection<Tag> tags) {
		Tags = tags;
	}
	public Collection<PostCategoryValue> getPostCategoryValues() {
		return PostCategoryValues;
	}
	public void setPostCategoryValues(Collection<PostCategoryValue> postCategoryValues) {
		PostCategoryValues = postCategoryValues;
	}
	public Collection<ReportPost> getReportsPost() {
		return ReportsPost;
	}
	public void setReportsPost(Collection<ReportPost> reportsPost) {
		ReportsPost = reportsPost;
	}
	
}
