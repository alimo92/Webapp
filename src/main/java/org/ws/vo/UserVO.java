package org.ws.vo;

public class UserVO {
	private int IdUser;
	private String FirstNameUser;
	private String LastNameUser;
	private String EmailUser;

	public UserVO(int IdUser, String firstNameUser, String lastNameUser, String emailUser, String passwordUser) {
		super();
		this.IdUser = IdUser;
		FirstNameUser = firstNameUser;
		LastNameUser = lastNameUser;
		EmailUser = emailUser;
	}
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getIdUser() {
		return IdUser;
	}
	public void setIdUser(int IdUser) {
		this.IdUser = IdUser;
	}
	
}
