package com.tradepost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tradepost.entity.Article;
import com.tradepost.entity.User;
import com.tradepost.service.ArticleService;
import com.tradepost.service.CommentService;
import com.tradepost.service.UserService;

@Controller
public class UserController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;

	@RequestMapping("/userdetail/{uid}")
	public String getUserDetail(Model model, @PathVariable("uid") Integer uid) {
		User user = userService.getUserByID(uid);
		List<Article> articleList = articleService.getArticleByUID(uid);
		model.addAttribute("userdetail", user);
		model.addAttribute("userdetailarticlelist", articleList);
		return "userDetail";
	}
}
