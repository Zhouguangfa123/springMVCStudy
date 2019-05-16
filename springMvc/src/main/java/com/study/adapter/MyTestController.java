package com.study.adapter;

import org.springframework.web.servlet.ModelAndView;

public class MyTestController implements MyController{

	@Override
	public ModelAndView my_test() throws Exception {
		
		ModelAndView mv = new ModelAndView("test");
		mv.addObject("name", "tom");
		
		return mv;
	}

}
