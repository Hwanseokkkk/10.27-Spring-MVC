package kr.kwangan2.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/link/*")
public class LinkController {
	
	@RequestMapping("/viewLink")
	public String viewLink() {
		return "viewLink";
		
	}

}
