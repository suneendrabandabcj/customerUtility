package com.cmsenergy.electricityservice.jms;

import java.util.Arrays;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.cmsenergy.electricityservice.daos.CustomerDAO;
import com.cmsenergy.electricityservice.daos.MessegeDAO;

public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message m) {
		TextMessage message = (TextMessage) m;
		MessegeDAO msgDAO = new MessegeDAO();
		CustomerDAO customerDao = new CustomerDAO();
		try {
			
			String[] msg = message.getText().split(":");
			System.out.println(Arrays.toString(msg));
			customerDao.updateCustomer(Integer.parseInt(msg[0]), Integer.parseInt(msg[1]));
			//msgDAO.updateCustomer(Integer.parseInt(messege[0]), Integer.parseInt(messege[1]));
			System.out.println("service plan updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}