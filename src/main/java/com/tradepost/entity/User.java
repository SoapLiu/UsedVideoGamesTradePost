package com.tradepost.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	private int uid;
	public String username;
	private String password;
	private String headimg;
	private String role;
	private Set<Comment> commentSet = new HashSet<Comment>();
	private Set<Article> articleSet = new HashSet<Article>();
	
	public User() {
	}
	
	public User(String username, String password, String headimg, Set<Comment> commentSet, Set<Article> articleSet) {
		this.username = username;
		this.password = password;
		this.headimg = headimg;
		this.commentSet = commentSet;
		this.articleSet = articleSet;
	}
	
	@Id
	@Column(name="uid", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	@Column(name = "username", unique = true)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "headimg")
	public String getHeadimg() {
		return this.headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	
	@Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Comment> getCommentSet() {
		return this.commentSet;
	}

	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Article> getArticleSet() {
		return this.articleSet;
	}

	public void setArticleSet(Set<Article> articleSet) {
		this.articleSet = articleSet;
	}

	
	
}
