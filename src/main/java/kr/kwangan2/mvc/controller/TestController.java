package kr.kwangan2.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kwangan2.mvc.domain.PersonDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/test/*", method = { RequestMethod.GET, RequestMethod.POST }) // localhost:8080/test/
@Log4j
public class TestController {

	@RequestMapping(value = "/test1", method = { RequestMethod.GET }) // get 요청 8080/test/test1
	public void test1() {

		log.info("testGet() 호출!");
	}

	@RequestMapping(value = "/test2", method = { RequestMethod.POST }) // post 요청8080/test/test2
	public void test2() {
		log.info("testPost() 호출!");

	}

	@RequestMapping(value = "/personParam")
	public void testPersonDTO(@RequestParam("name") String n, @RequestParam("age") int a) {
		log.info(n + ":" + a);
	}

	@RequestMapping(value = "/personDTO")
	public void testPersonDTO(PersonDTO personDTO) {
		log.info(personDTO);
	}

	@RequestMapping(value = "/fileupload")
	public void testFileUpload(@RequestParam("uploadFile")ArrayList<String> listUploadFiles) {
		log.info(listUploadFiles);

	}
	
	@RequestMapping(value="/personDTOList")
	public void testPersonDTOList(PersonDTO personDTO) {
		log.info(personDTO);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("/initBinder")
	public void binder(PersonDTO personDTO) {
		log.info(personDTO);
	}
	
	@GetMapping("/getModelInfo")
	public String getModelInfo(Model model, @ModelAttribute("addr") String addr) {
		model.addAttribute("name", "아기상어");
		model.addAttribute("age", "3");
		log.info(addr);
		return "getModelInfo";
	}
	
	@GetMapping("/getInfo")
	public String getInfo(Model model, String name, int age) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "redirect:/";
		
	}
	@GetMapping("/getJson")
	public @ResponseBody PersonDTO getJson() {
		log.info("getJson.............");
		PersonDTO dto2 = new PersonDTO();
		dto2.setAge(3);
		dto2.setName("아기상어");
		dto2.setBirth(new Date());
		
		PersonDTO dto3 = new PersonDTO();
		dto3.setAge(36);
		dto3.setName("아빠상어");
		dto3.setBirth(new Date());
		
		PersonDTO dto = new PersonDTO();
		dto.setAge(33);
		dto.setName("엄마상어");
		dto.setBirth(new Date());
		ArrayList<PersonDTO> personDTOList = new ArrayList<PersonDTO>();
		personDTOList.add(dto2);
		personDTOList.add(dto3);
		
		
		dto.setPersonDTOList(personDTOList);
		return dto;
	}
	@GetMapping("modelAndView") //2.5버전처럼 코딩...
	public ModelAndView modelAndView(Model model) {
		model.addAttribute("name","할머니상어");
		model.addAttribute("age",80);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAndView");
//		mav.setStatus(HttpStatus.OK);
		return mav;
	}
	
	@GetMapping("/realUploadForm")
	public String realUploadForm() {
		return "realUploadForm";
	}
	@PostMapping("/realfileupload")
	public void realfileupload(ArrayList<MultipartFile> uploadFile) {
		uploadFile.forEach(file->{
			log.info("업로드 할 때의 파일명 : "+file.getOriginalFilename());
			log.info("업로드 할 때의 파일크기 : "+file.getSize());
			
		});
		
	}

}// class