package com.ycc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Pagecontroller {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String serveIndexPage() {
		return "index";
	}
	
}
