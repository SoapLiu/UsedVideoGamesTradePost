package com.tradepost.service;

import java.sql.Timestamp;
import java.util.List;

import com.tradepost.entity.Article;
import com.tradepost.entity.Comment;
import com.tradepost.entity.User;

public interface CommentService {

	public void addComment(String content, Article article, User user, Timestamp timestamp);
	
	public List<Comment> getComment(Integer aid, Integer uid);
	
	public int getCommentCount(Integer aid);

	List<Comment> getCommentByAid(Integer aid);

}
