package com.guestbook.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guestbook.dao.guestbookDao;
import com.guestbook.vo.guestbookVo;


@Controller
public class GuestBookController {
	
	
	@Autowired
	private guestbookDao dao;
	
	@RequestMapping("/deleteform")
	public String deleteform(@RequestParam("no") int no,Model model) {
		System.out.println(no);
		model.addAttribute("no",no);			
		return "guestbook/deleteform";
	}
	
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<guestbookVo> list=dao.getlist();
		System.out.println(list);
		model.addAttribute("list",list);			
		return "guestbook/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute guestbookVo vo ) {
		dao.delete(vo);				
		return "redirect:/list";
	}
	
	@RequestMapping("/add")
	public String add(@ModelAttribute guestbookVo vo) {
		dao.insert(vo);	
		return "redirect:/list";
	}

}
