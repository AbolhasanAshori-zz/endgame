package com.endgame.entity;

import javax.persistence.*;

@Entity
@Table(name = "newsletter", indexes = @Index(name = "ix_news_email", columnList = "email", unique = true))
public class Newsletter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String email;
	
	public Newsletter() {
		
	}
}
