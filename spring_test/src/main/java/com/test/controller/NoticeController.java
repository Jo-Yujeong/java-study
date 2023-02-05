package com.test.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.dto.NoticeDTO;
import com.test.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	NoticeService service;
	
	@RequestMapping("/list")
	public ModelAndView list() throws Exception{
		List<NoticeDTO> list = service.list();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeList", list);
		mav.setViewName("list");
		
		return mav;
	}
	
	@GetMapping("/writeForm")
	public String writeForm() throws Exception{
		return "writeForm";
	}
	
	@PostMapping("/write")
	public String write(NoticeDTO dto) throws Exception{
		int n = service.write(dto);
		return "redirect:list";
	}
	
	@GetMapping("/retrieve")
	public ModelAndView findByNo(String no) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		service.increaseCnt(service.findByNo(Integer.parseInt(no)));
		mav.addObject("notice", service.findByNo(Integer.parseInt(no)));
		mav.setViewName("retrieve");
		return mav;
	}
	
	@PostMapping("/update")
	public String update(NoticeDTO dto) throws Exception{
		int n = service.update(dto);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(NoticeDTO dto) throws Exception{
		int n = service.delete(dto);
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public ModelAndView findBySearch(@RequestParam HashMap<String, String> map) throws Exception{
		ModelAndView mav = new ModelAndView();

		if(map.isEmpty()) {
			mav.addObject("noticeList", service.list());
		} else {
			mav.addObject("noticeList", service.findBySearch(map));
		}
		mav.setViewName("list");
		
		return mav;
	}
}
