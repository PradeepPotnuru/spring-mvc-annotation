package com.pradeep.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pradeep.model.Login;
import com.pradeep.model.Student;

@Controller
public class HelloWorldController {
	@RequestMapping(value = "/admissionForm", method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		Student userForm = new Student();
		model.put("userForm", userForm);

		List<String> professionList = new ArrayList<String>();
		professionList.add("Developer");
		professionList.add("Designer");
		professionList.add("IT Manager");
		professionList.add("IT Lead");
		model.put("professionList", professionList);

		return "AdmissionForm";
	}

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public ModelAndView loginForm(@ModelAttribute("userLogin") Login userLogin,ModelMap model) {
		
			model.addAttribute("userName", userLogin.getUserName());
			model.addAttribute("passWord", userLogin.getPassWord());
			return new ModelAndView("test");

		}

	

	@RequestMapping(value = "/submitForm", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") Student userForm, Map<String, Object> model) {
		/*
		 * if(result.hasErrors()){ System.out.println(result.toString()); return
		 * "AdmissionForm"; }
		 */
		return "SuccessForm";
	}

}

