package com.BasicAuthentication.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@ToString
//@Getter
//@Setter
@Entity
@Table(name = "security_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String username;
	private String password;
	private String contactnumber;
	private String roles;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long id, String username, String password, String contactnumber, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.contactnumber = contactnumber;
		this.roles = roles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", contactnumber="
				+ contactnumber + ", roles=" + roles + "]";
	}

	
}
