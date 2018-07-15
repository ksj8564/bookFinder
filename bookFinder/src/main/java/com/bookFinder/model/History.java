package com.bookFinder.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="history_id")	
	private int id;
	
	@Column(name="query")
	private String query;
	
	@Column(name="target")
	private String target;	
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name="date_created")
	private Date dateCreated;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", query=" + query + ", target=" + target + ", userId=" + userId + ", dateCreated="
				+ dateCreated + "]";
	}

	public History(int id, String query, String target, int userId, Date dateCreated) {
		super();
		this.id = id;
		this.query = query;
		this.target = target;
		this.userId = userId;
		this.dateCreated = dateCreated;
	}

	public History() {
		super();
	}

	public History(String query, String target) {
		super();
		this.query = query;
		this.target = target;
	}

	public History(String query, String target, Date dateCreated) {
		super();
		this.query = query;
		this.target = target;
		this.dateCreated = dateCreated;
	}

	
	

}
