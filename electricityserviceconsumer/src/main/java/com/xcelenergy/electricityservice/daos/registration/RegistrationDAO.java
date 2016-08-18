package com.xcelenergy.electricityservice.daos.registration;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xcelenergy.electricityservice.models.registration.Customer;


@Repository
public class RegistrationDAO{
	
	@Autowired
	private SessionFactory mySessionFactory;

	public int saveCustomer(Customer customer) {	
		Session session = mySessionFactory.openSession();	
		//Transaction trans = session.beginTransaction();
		int custId = (Integer) session.save(customer);	
		//trans.commit();
		return custId;
	}
}
