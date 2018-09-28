package com.tradepost.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tradepost.entity.User;
import com.tradepost.service.UserService;

@Controller
public class UploadController {

	@Autowired
	private UserService userService;

	static long count = 1;
	
	@RequestMapping(value = "/articleimgupload", method = RequestMethod.POST)
	public ModelAndView fileUpload(HttpSession session, Model model, @RequestParam("file") MultipartFile file, HttpServletResponse response, HttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView();
		String fileName = "aimg" + (count++) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		@SuppressWarnings("deprecation")
		String realPath = request.getRealPath("/resources/imgs/articleimg");
		String filePath = "/Users/soap/Documents/workspace-sts-3.9.2.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/UsedVideoGamesTradePost/resources/imgs/articleimg";
		String path = filePath + File.separator + fileName;
		System.out.println(realPath);

		file.transferTo(new File(path));
		
		String head = "/Users/soap/Documents/workspace-sts-3.9.2.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/UsedVideoGamesTradePost";
		int size = head.length();
		
		mav.addObject("uploadarticleimg", path.substring(size));
		mav.setViewName("/post");
		
		return mav;
	}
	
	@RequestMapping(value = "/headimgupload", method = RequestMethod.POST)
	public String headimgUpload(HttpSession session, Model model, @RequestParam("headimgfile") MultipartFile headimgfile, HttpServletResponse response, HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = "himg" + (count++) + headimgfile.getOriginalFilename().substring(headimgfile.getOriginalFilename().lastIndexOf("."));
		@SuppressWarnings("deprecation")
		String realPath = request.getRealPath("/resources/imgs/headimg");
		String filePath = "/Users/soap/Documents/workspace-sts-3.9.2.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/UsedVideoGamesTradePost/resources/imgs/headimg";
		String path = filePath + File.separator + fileName;
		System.out.println(realPath);

		headimgfile.transferTo(new File(path));
		
		String head = "/Users/soap/Documents/workspace-sts-3.9.2.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/UsedVideoGamesTradePost";
		int size = head.length();
		
		
		User user = (User) session.getAttribute("user");
		userService.changeHeadimg(user.getUsername(), path.substring(size));
		user.setHeadimg(path.substring(size));
				
		return ("redirect:/" + ("userdetail/" + user.getUid()));
	}
}
