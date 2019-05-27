package com.example.thedemotest.thedemotest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	@RequestMapping("/")
	public String renderIndex() {
		return "index.html";
	}
}
