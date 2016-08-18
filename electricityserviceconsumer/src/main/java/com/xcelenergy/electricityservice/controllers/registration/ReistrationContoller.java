package com.xcelenergy.electricityservice.controllers.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xcelenergy.electricityservice.models.registration.Customer;
import com.xcelenergy.electricityservice.services.registration.RegistrationService;

@Controller
public class ReistrationContoller {

	@Autowired
	RegistrationService registrationService;

	@RequestMapping("/registration")
	public String registratation(@ModelAttribute("customer") Customer customer, Model model) {

		String messege = registrationService.saveCustomer(customer);
		
		if (messege != null) {
			model.addAttribute("planinfo",messege);
			return "success";
		} else
			return "fail";
	}
}