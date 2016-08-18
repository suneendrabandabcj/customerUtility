package com.xcelenergy.electricityservice.services.registration;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xcelenergy.electricityservice.clients.restclient.CustomerServiceConsumer;
import com.xcelenergy.electricityservice.clients.soapclient.ServicePlanConsumer;
import com.xcelenergy.electricityservice.daos.registration.RegistrationDAO;
import com.xcelenergy.electricityservice.jms.MessageSender;
import com.xcelenergy.electricityservice.models.registration.Customer;
import com.xcelenergy.electricityservice.soapservice.ServicePlan;

public class RegistrationService {

	@Autowired
	RegistrationDAO regDAO;

	@Autowired
	CustomerServiceConsumer customerServiceConsumer;

	@Autowired
	ServicePlanConsumer servicePlanConsumer;

	@Autowired
	MessageSender messageSender;
	final static Logger logger = Logger.getLogger(RegistrationService.class);

	@Transactional
	public String saveCustomer(Customer customer) {
		int custId = regDAO.saveCustomer(customer);

		String messege = null;
		if (custId != 0) {
			logger.info("Customer Saved Sccessfully with id " + custId);

			Customer cust = customerServiceConsumer.getCustomerById(custId);

			logger.info("REST call successfully got the customer " + cust.toString());

			List<ServicePlan> servicePlans = servicePlanConsumer.getServicePlans();

			logger.info("SOAP call successfully got the Serviceplans ");

			messageSender.sendMessage(custId + ":" + servicePlans.get(0).getServiceId());

			messege = "Name " + servicePlans.get(2).getServiceName() + " & Validity "
					+ servicePlans.get(2).getValidity();

			return messege;
		} else {
			return messege;
		}
	}
}
