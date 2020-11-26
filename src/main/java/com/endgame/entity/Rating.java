package com.endgame.entity;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(nullable = false)
	private Game game;
	
	private Integer top;
	
	private Float price;
	
	private Float graphics;
	
	private Float levels;
	
	private Float gameplay;
	
	private Float difficulty;
	
	private Float overall;
	
	public Rating() {
		
	}

	public Rating(int id, Game game, int top, Float price, Float graphics, Float levels, Float gameplay,
			Float difficulty, Float overall) {
		this.id = id;
		this.game = game;
		this.top = top;
		this.price = price;
		this.graphics = graphics;
		this.levels = levels;
		this.gameplay = gameplay;
		this.difficulty = difficulty;
		this.overall = overall;
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

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getGraphics() {
		return graphics;
	}

	public void setGraphics(Float graphics) {
		this.graphics = graphics;
	}

	public Float getLevels() {
		return levels;
	}

	public void setLevels(Float levels) {
		this.levels = levels;
	}

	public Float getGameplay() {
		return gameplay;
	}

	public void setGameplay(Float gameplay) {
		this.gameplay = gameplay;
	}

	public Float getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Float difficulty) {
		this.difficulty = difficulty;
	}

	public Float getOverall() {
		return overall;
	}

	public void setOverall(Float overall) {
		this.overall = overall;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", game=" + game + ", top=" + top + ", price=" + price + ", graphics=" + graphics
				+ ", levels=" + levels + ", gameplay=" + gameplay + ", difficulty=" + difficulty + ", overall="
				+ overall + "]";
	}
}
