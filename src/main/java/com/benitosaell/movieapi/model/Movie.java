package com.benitosaell.movieapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String synopsis;
	private String poster = "image.jpg";
	private String review;
	private Date releaseDate;

	
	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER,orphanRemoval=true) private List<Comment>
	 comments;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public void setReleaseDate(Date release) {
		this.releaseDate = release;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	/*
	 * public List<Comment> getComments() { return comments; }
	 * 
	 * public void setComments(List<Comment> comments) { this.comments = comments; }
	 */

	public void setSypnosis(String sypnosis) {
		this.synopsis = sypnosis;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", synopsis=" + synopsis + ", poster=" + poster + ", review="
				+ review + ", releaseDate=" + releaseDate + ", comments=" + "]";
	}

}
