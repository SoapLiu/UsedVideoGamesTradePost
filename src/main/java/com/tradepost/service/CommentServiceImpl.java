package com.tradepost.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradepost.dao.CommentDao;
import com.tradepost.entity.Article;
import com.tradepost.entity.Comment;
import com.tradepost.entity.User;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentDao commentDao;
	
	@Autowired
	public void getCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	@Override
	@Transactional
	public void addComment(String content, Article article, String author, User user, Timestamp timestamp) {
		commentDao.addComment(content, article, author, user, timestamp);
	}

	@Override
	@Transactional
	public List<Comment> getComment(Integer aid, Integer uid) {
		return commentDao.getComment(aid, uid);
	}
	
	@Override
	@Transactional
	public List<Comment> getCommentByAid(Integer aid) {
		return commentDao.getCommentByAid(aid);
	}

	@Override
	@Transactional
	public int getCommentCount(Integer aid) {
		return commentDao.getCommentCount(aid);
	}
	
	@Override
	@Transactional
	public void deleteCommentByCid(Integer cid) {
		commentDao.deleteCommentByCid(cid);
	}

	@Override
	@Transactional
	public void deleteCommentByAid(Integer aid) {
		commentDao.deleteCommentByAid(aid);
	}

}
