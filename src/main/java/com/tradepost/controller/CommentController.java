package com.tradepost.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tradepost.entity.User;
import com.tradepost.service.ArticleService;
import com.tradepost.service.CommentService;
import com.tradepost.service.UserService;

@Controller
public class CommentController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;

	@RequestMapping(value="/addcomment/{aid}", method = RequestMethod.POST)
	public String addArticle(Model model, HttpSession session, @PathVariable("aid") Integer aid,
				@RequestParam(value = "content") String content) {
		
		User user = (User) session.getAttribute("user");
		session.setAttribute("user", userService.getUserByID(user.getUid()));

//		User user = userService.getUserByID(4);
		
		if(StringUtils.isEmpty(content)) {
			model.addAttribute("message", "Content cannot be blank, redirect to previous post in");
			model.addAttribute("redirectPage", "/controller/articledetail/"+aid);
			return "message";
		}
		commentService.addComment(content, articleService.getArticleByID(aid), user.getUsername(),user, new Timestamp(new Date().getTime()));
		model.addAttribute("message", "Successfully reply, redirect to home page in");
		model.addAttribute("redirectPage", "/controller/articledetail/"+aid);
		return "message";
	}
	
	@RequestMapping(value="/userdeletecomment/{aid}/{cid}", method = RequestMethod.GET)
	public String articleDelete(HttpSession session, @PathVariable("cid") Integer cid, @PathVariable("aid") Integer aid) {
		commentService.deleteCommentByCid(cid);
		return ("redirect:/" + ("articledetail/" + aid));
	}

}
