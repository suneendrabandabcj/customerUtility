package com.bootcampjava.tests;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.bootcampjava.electricityservice.clients.restclient.CustomerClient;
import com.bootcampjava.electricityservice.models.registration.Customer;


public class CustomerServiceTest {
	
	private static CustomerClient custClient = Mockito.mock(CustomerClient.class);
	private static  Customer customer;

	
	@Test
	public void testgetCustomerDetailsById(){
		
		customer = new Customer();
		customer.setCid(7);
		customer.setFirstname("ssss");
		customer.setLastname("ssss");
		customer.setUsername("ssss");
		customer.setPassword("ssss");
		
		when(custClient.getCustomerById(7)).thenReturn(customer);
		
		Customer cust = custClient.getCustomerById(7);
		assertSame(customer, cust);
		
	}
	
}
