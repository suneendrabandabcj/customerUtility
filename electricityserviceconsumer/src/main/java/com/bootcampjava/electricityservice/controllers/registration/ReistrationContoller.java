package com.bootcampjava.electricityservice.controllers.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcampjava.electricityservice.models.registration.Customer;
import com.bootcampjava.electricityservice.services.registration.RegistrationService;

@Controller
public class ReistrationContoller {

	@Autowired
	RegistrationService regSercice;

	@RequestMapping("/registration")
	public String registratation(@ModelAttribute("customer") Customer customer, Model model) {

		String messege = regSercice.saveCustomer(customer);
		
		if (messege != null) {
			model.addAttribute("planinfo",messege);
			return "success";
		} else
			return "fail";
	}
}