package com.endgame.entity;

import javax.persistence.*;

@Entity
@Table(name = "testimonial")
public class Testimonial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(nullable = false)
	private Game game;
	
	@Column(length = 1000)
	private String content;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private User author;
	
	public Testimonial() {
		
	}

	public Testimonial(int id, Game game, String content, User author) {
		this.id = id;
		this.game = game;
		this.content = content;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Testimonial [id=" + id + ", game=" + game + ", content=" + content + ", author=" + author + "]";
	}
}
