package com.endgame.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities", indexes = {@Index(name = "ix_auth_email", columnList = "email_ix")})
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "email_ix", referencedColumnName = "email", nullable = false, columnDefinition = "varchar(255)")
	private User email;
	
	private String authority;
	
	public Authority() {
		
	}

	public Authority(int id, User email, String authority) {
		this.id = id;
		this.email = email;
		this.authority = authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getEmail() {
		return email;
	}

	public void setEmail(User email) {
		this.email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", email=" + email + ", authority=" + authority + "]";
	}
}
