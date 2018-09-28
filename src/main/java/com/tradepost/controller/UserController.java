package com.tradepost.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tradepost.entity.Article;
import com.tradepost.entity.User;
import com.tradepost.service.ArticleService;
import com.tradepost.service.UserService;

@Controller
public class UserController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userdetail/{uid}")
	public String getUserDetail(HttpSession session, Model model, @PathVariable("uid") Integer uid) {
		User user = userService.getUserByID(uid);
		User realUser = (User)session.getAttribute("user");
		if(realUser == null) model.addAttribute("userFlag", false);
		else if(user.getUid() == realUser.getUid()) model.addAttribute("userFlag", true);
		else model.addAttribute("useraFlag", false);
		List<Article> articleList = articleService.getArticleByUID(uid);
		model.addAttribute("userdetail", user);
		model.addAttribute("userdetailarticlelist", articleList);
		return "userDetail";
	}
	
	@RequestMapping(value = "/registerform", method = RequestMethod.GET)
	public String registerForm() {
		return "registerForm";
	}
	
	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String changePassword() {
		return "changePassword";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
		if(userService.getUserByUsername(username) != null) {
			String errorMsg = "Duplicate username!";
			model.addAttribute("errorMsg", errorMsg);
			return "registerForm";
		}
		String headimg = "/resources/imgs/head.png";
		userService.addUser(username, password, headimg, "user");
		model.addAttribute("message", "Register Successed, redirect to home page in");
		model.addAttribute("redirectPage", "/controller/list/1");
		return "message";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
		
		User user = userService.getUser(username, password);
		if(user != null) {
			session.setAttribute("user", user);
			model.addAttribute("message", "Login Succeed, redirect to home page in");
			model.addAttribute("redirectPage", "/controller/list/1");
			return "message";
		}
		model.addAttribute("errorMsg", "Invalid username or password, please try again");
		return "loginForm";
	}
	
	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public String password(HttpSession session, Model model, @RequestParam("password") String password, @RequestParam("newpassword") String newpassword) {
		User user = (User) session.getAttribute("user");
		if(user != null) {
			String username = user.getUsername();
			userService.changePassword(username, newpassword);
			model.addAttribute("message", "Password Changed Succeed, redirect to home page in");
			model.addAttribute("redirectPage", "/controller/list/1");
			session.invalidate();
			return "message";
		}
		model.addAttribute("errorMsg", "Invalid username or password, please try again");
		return "changePassword";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("message", "Logout Succeed, redirect to home page in");
		model.addAttribute("redirectPage", "/controller/list/1");
		return "message";
	}

}
