package com.tradepost.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tradepost.entity.Article;
import com.tradepost.entity.Comment;
import com.tradepost.entity.User;
import com.tradepost.service.ArticleService;
import com.tradepost.service.CommentService;
import com.tradepost.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ArticleController {
		
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
		
	@RequestMapping(value = "/list/{currentPage}", method = RequestMethod.GET)
	public String getArticleList(HttpSession session, Model model, @PathVariable("currentPage") int currentPage) {
		
		if(session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			session.setAttribute("user", userService.getUserByID(user.getUid()));
		}
		List<Article> list = articleService.getArticleList();
		int pageSize = 10;
		int articleTotal = list.size();
		if(articleTotal == 0) return "articleList";
		int pageTotal = (articleTotal % pageSize == 0) ? (articleTotal / pageSize) : (articleTotal / pageSize + 1);
		if(currentPage > pageTotal) currentPage = pageTotal;
		List<Article> articleList = new ArrayList<Article>();
		int start = (currentPage - 1) * pageSize;
		int end = ((start + pageSize)>=articleTotal)? articleTotal : (start + pageSize);
		for(int i = start; i < end; i++) {
			articleList.add(list.get(i));
		}
		model.addAttribute("pageTotal", pageTotal);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("articleList", articleList);
		return "articleList";
	}
	
	@RequestMapping(value = "/articledetail/{aid}", method = RequestMethod.GET)
	public String getArticleDetail(Model model, @PathVariable("aid") Integer aid) {
		Article article = articleService.getArticleByID(aid);
		List<Comment> commentList = commentService.getCommentByAid(aid);
		model.addAttribute("article", article);
		model.addAttribute("author", userService.getUserByID(article.getUser().getUid()));
		model.addAttribute("commentList", commentList);
		return "articleDetail";
	}
	
	@RequestMapping(value = "/searchbykeyword", method = RequestMethod.POST)
	public String searchByKeyword(Model model, @RequestParam("keyword") String keyword) {
		List<Article> list = articleService.searchArticleByKey(keyword);
		model.addAttribute("searchArticleList", list);
		model.addAttribute("searchKeyword", keyword);
		return "search";
	}
	
	@RequestMapping(value="/searchbytag", method = RequestMethod.POST)
	public String searchByTag(Model model, @RequestParam("tagname") String tagname) {
		List<Article> list = articleService.searchArticleByTag(tagname);
		model.addAttribute("searchArticleList", list);
		model.addAttribute("searchKeyword", tagname);
		return "search";
	}
	
	@RequestMapping(value="/addarticle", method = RequestMethod.POST)
	public String addArticle(Model model, HttpSession session,
				@RequestParam(value = "title") String title,
				@RequestParam(value = "content") String content,
				@RequestParam(value = "uploadarticleimg", required = false) String uploadarticleimg,
				@RequestParam(value = "label") String label) {
		User user = (User) session.getAttribute("user");
//		User user = userService.getUserByID(1);
		
		if(user == null) {
			model.addAttribute("message", "You can post your games after you login, redirect to home page in");
			model.addAttribute("redirectPage", "/controller/list/1");
			return "message";
		}
		if(StringUtils.isEmpty(title)) {
			model.addAttribute("message", "Title cannot be blank, redirect to home page in");
			model.addAttribute("redirectPage", "/controller/list/1");
			return "message";
		}
		
		if(uploadarticleimg.equals("")) {
			articleService.addArticle(title, content, label, new Timestamp(new Date().getTime()), user, user.getUsername());
			model.addAttribute("message", "Successfully post, redirect to home page in");
			model.addAttribute("redirectPage", "/controller/list/1");
			return "message";
			
		}
		articleService.addArticle(title, content, label, uploadarticleimg, new Timestamp(new Date().getTime()), user, user.getUsername());
		model.addAttribute("message", "Successfully post, redirect to home page in");
		model.addAttribute("redirectPage", "/controller/list/1");
		
		return "message";
	}
	
	@RequestMapping(value="/post", method = RequestMethod.GET)
	public String post() {
		return "post";
	}
	
	@RequestMapping(value="/userdeletearticle/{aid}", method = RequestMethod.GET)
	public String articleDelete(HttpSession session, @PathVariable("aid") Integer aid) {
		User user = (User) session.getAttribute("user");
		articleService.deleteArticleByID(aid);
		return ("redirect:/" + ("userdetail/" + user.getUid()));
	}
	
//	@RequestMapping(value="/delete", method = RequestMethod.GET)
//	public String delete(HttpSession session) {
//		User user = (User) session.getAttribute("user");
//		int aid = 120;
//		articleService.deleteArticleByID(aid);
//		return ("redirect:/" + ("userdetail/" + user.getUid()));
//	}

}
