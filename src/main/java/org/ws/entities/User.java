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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
@NamedQuery(name="User.FindByEmail",
        query="SELECT u FROM User u"
            		+ " WHERE u.EmailUser = :EmailUser"),
@NamedQuery(name="User.FindByEmailAndPassWord",
query="SELECT u FROM User u"
    		+ " WHERE u.EmailUser = :EmailUser AND u.PasswordUser =:PasswordUser"),
})
public class User extends GenericEntity implements Serializable{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdUser;
	private String FirstNameUser;
	private String LastNameUser;
	private String EmailUser;
	private String PasswordUser;
	@OneToMany(mappedBy="User")
	private Collection<BlockedUser> BlockedUsers;
	@OneToMany(mappedBy="BlockedUser")
	private Collection<BlockedUser> Blocked;
	@OneToMany(mappedBy="User")
	private Collection<Follower> Followed;
	@OneToMany(mappedBy="Followed")
	private Collection<Follower> Followers;
	@OneToMany(mappedBy="User")
	private Collection<Message> MessagesUser;
	@OneToMany(mappedBy="User")
	private Collection<ConversationUser> ConversationsUser;
	@OneToMany(mappedBy="User")
	private Collection<Notification> NotificationsUser;
	@OneToMany(mappedBy="AdminUser")
	private Collection<AdminGroupe> IsAdmin;
	@OneToMany(mappedBy="User")
	private Collection<ReportPost> ReportsPost;
	@OneToMany(mappedBy="User")
	private Collection<Rating> Ratings;
	@OneToMany(mappedBy="User")
	private Collection<GroupeMessage> GroupMessages;
	@OneToMany(mappedBy="User")
	private Collection<GroupeUser> GroupeUser;
	@OneToMany(mappedBy="User")
	private Collection<Alert> Alerts;
	@OneToMany(mappedBy="User")
	private Collection<Tag> Tags;
	@OneToMany(mappedBy="User")
	private Collection<Post> Posts;
	@OneToMany(mappedBy="User")
	private Collection<Comment> Comments;
	public User(int idUser, String firstNameUser, String lastNameUser, String emailUser, String passwordUser,
			Collection<BlockedUser> blockedUsers, Collection<BlockedUser> blocked, Collection<Follower> followed,
			Collection<Follower> followers, Collection<Message> messagesUser,
			Collection<ConversationUser> conversationsUser, Collection<Notification> notificationsUser,
			Collection<AdminGroupe> isAdmin, Collection<ReportPost> reportsPost, Collection<Rating> ratings,
			Collection<GroupeMessage> groupMessages, Collection<org.ws.entities.GroupeUser> groupeUser,
			Collection<Alert> alerts, Collection<Tag> tags, Collection<Post> posts, Collection<Comment> comments) {
		super();
		IdUser = idUser;
		FirstNameUser = firstNameUser;
		LastNameUser = lastNameUser;
		EmailUser = emailUser;
		PasswordUser = passwordUser;
		BlockedUsers = blockedUsers;
		Blocked = blocked;
		Followed = followed;
		Followers = followers;
		MessagesUser = messagesUser;
		ConversationsUser = conversationsUser;
		NotificationsUser = notificationsUser;
		IsAdmin = isAdmin;
		ReportsPost = reportsPost;
		Ratings = ratings;
		GroupMessages = groupMessages;
		GroupeUser = groupeUser;
		Alerts = alerts;
		Tags = tags;
		Posts = posts;
		Comments = comments;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Timestamp dateCreated, Timestamp dateUpdated) {
		super(dateCreated, dateUpdated);
		// TODO Auto-generated constructor stub
	}

	public int getIdUser() {
		return IdUser;
	}
	public void setIdUser(int idUser) {
		IdUser = idUser;
	}
	public String getFirstNameUser() {
		return FirstNameUser;
	}
	public void setFirstNameUser(String firstNameUser) {
		FirstNameUser = firstNameUser;
	}
	public String getLastNameUser() {
		return LastNameUser;
	}
	public void setLastNameUser(String lastNameUser) {
		LastNameUser = lastNameUser;
	}
	public String getEmailUser() {
		return EmailUser;
	}
	public void setEmailUser(String emailUser) {
		EmailUser = emailUser;
	}
	public String getPasswordUser() {
		return PasswordUser;
	}
	public void setPasswordUser(String passwordUser) {
		PasswordUser = passwordUser;
	}
	public Collection<BlockedUser> getBlockedUsers() {
		return BlockedUsers;
	}
	public void setBlockedUsers(Collection<BlockedUser> blockedUsers) {
		BlockedUsers = blockedUsers;
	}
	public Collection<Follower> getFollowed() {
		return Followed;
	}
	public void setFollowed(Collection<Follower> followed) {
		Followed = followed;
	}
	public Collection<Message> getMessagesUser() {
		return MessagesUser;
	}
	public void setMessagesUser(Collection<Message> messagesUser) {
		MessagesUser = messagesUser;
	}
	public Collection<Notification> getNotificationsUser() {
		return NotificationsUser;
	}
	public void setNotificationsUser(Collection<Notification> notificationsUser) {
		NotificationsUser = notificationsUser;
	}
	public Collection<AdminGroupe> getIsAdmin() {
		return IsAdmin;
	}
	public void setIsAdmin(Collection<AdminGroupe> isAdmin) {
		IsAdmin = isAdmin;
	}
	public Collection<ReportPost> getReportsPost() {
		return ReportsPost;
	}
	public void setReportsPost(Collection<ReportPost> reportsPost) {
		ReportsPost = reportsPost;
	}
	public Collection<Rating> getRatings() {
		return Ratings;
	}
	public void setRatings(Collection<Rating> ratings) {
		Ratings = ratings;
	}
	public Collection<GroupeMessage> getGroupMessages() {
		return GroupMessages;
	}
	public void setGroupMessages(Collection<GroupeMessage> groupMessages) {
		GroupMessages = groupMessages;
	}
	public Collection<Alert> getAlerts() {
		return Alerts;
	}
	public void setAlerts(Collection<Alert> alerts) {
		Alerts = alerts;
	}
	public Collection<Tag> getTags() {
		return Tags;
	}
	public void setTags(Collection<Tag> tags) {
		Tags = tags;
	}

	public Collection<ConversationUser> getConversationsUser() {
		return ConversationsUser;
	}

	public void setConversationsUser(Collection<ConversationUser> conversationsUser) {
		ConversationsUser = conversationsUser;
	}

	public Collection<GroupeUser> getGroupeUser() {
		return GroupeUser;
	}

	public void setGroupeUser(Collection<GroupeUser> groupeUser) {
		GroupeUser = groupeUser;
	}

	public Collection<BlockedUser> getBlocked() {
		return Blocked;
	}

	public void setBlocked(Collection<BlockedUser> blocked) {
		Blocked = blocked;
	}

	public Collection<Follower> getFollowers() {
		return Followers;
	}

	public void setFollowers(Collection<Follower> followers) {
		Followers = followers;
	}

	public Collection<Post> getPosts() {
		return Posts;
	}

	public void setPosts(Collection<Post> posts) {
		Posts = posts;
	}

	public Collection<Comment> getComments() {
		return Comments;
	}

	public void setComments(Collection<Comment> comments) {
		Comments = comments;
	}
}
