/*
 * @(#)MainPageAction.java 2014-7-4
 * 
 * Copy Right@ 纽海信息技术有限公司
 */ 

package com.coderme.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderme.bean.Article;
import com.coderme.service.ArticleService;

/**
 * <pre>
 * @author zhangtengfei
 *
 *
 * 创建日期: 2014-7-4
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */

@Controller
@RequestMapping("/mainPage")
public class MainPageAction {
	@Resource
	private ArticleService articleService;
	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model) {
		
		List<Article> texts = new ArrayList<Article>();
		try {
			texts = articleService.findAllArticle();
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
		model.addAttribute("textList", texts);
		return "mainPage";
	}
}
