package kr.kwangan2.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fileupload/*")
public class FileuploadFormController {

	@RequestMapping("/fileuploadForm")
	public String fileupload() {
		return "fileuploadForm";

	}

}
