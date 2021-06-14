package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.BullEntity;
import com.example.repository.BullRepository;

public class BullController {
	@Autowired
	BullRepository repos;

	/* 一覧画面（初期画面）への遷移  */
	@GetMapping
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BullEntity> list = repos.findAll();
		mav.setViewName("bull/list");
		mav.addObject("data", list);
		return mav;
	}
	
	/* 新規画面への遷移  */
	@GetMapping("/add")
	ModelAndView add() {
		ModelAndView mav = new ModelAndView();
		BullEntity data = new BullEntity();
		mav.addObject("formModel", data);
		mav.setViewName("bull/new");
		return mav;
	}
	
	/* 編集画面への遷移  */
	@GetMapping("/edit")
	ModelAndView edit(@RequestParam Date createDate) {
		ModelAndView mav = new ModelAndView();
		BullEntity data = repos.findById(createDate);
		mav.addObject("formModel", data);
		mav.setViewName("bull/new");
		return mav;
	}
	
	/* 更新処理  */
	@PostMapping()
	@Transactional(readOnly=false)
	public ModelAndView save(@ModelAttribute("formModel") BullEntity user) {
		repos.saveAndFlush(user);
		return new ModelAndView("redirect:users/list");
	}
	
	/* 削除処理  */
	@PostMapping("/delete")
	@Transactional(readOnly=false)
	public ModelAndView delete(@RequestParam Date createDate) {
		repos.deleteById(createDate);
		return new ModelAndView("redirect:users/list");
	}
	
	/* 詳細画面への遷移  */
	@GetMapping("/show")
	ModelAndView show(@RequestParam Date createDate) {
		ModelAndView mav = new ModelAndView();
		BullEntity data = repos.findById(createDate);
		mav.addObject("formModel", data);
		mav.setViewName("bull/new");
		return mav;
	}
}
