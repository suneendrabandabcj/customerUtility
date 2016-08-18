package com.cmsenergy.electricityservice.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cmsenergy.electricityservice.models.Customer;
import com.cmsenergy.electricityservice.util.JdbcUtil;

@Repository
public class CustomerDAO {
	
	JdbcUtil jdbcutil = new JdbcUtil();
		
	
	/**
	 * return Customer for given customer ID
	 * @param id
	 * @return
	 */
	public  Customer getCustomerById(int id){
		
		Customer cust = new Customer();
		Connection con = jdbcutil.createMySqlConnection();
		try {
			Statement st = con.createStatement();
			System.out.println(id);
			ResultSet rs = st.executeQuery("select * from customer where id ="+id);
			
				while(rs.next()){
					cust.setCid(rs.getInt(1));
					cust.setFirstname(rs.getString(2));
					cust.setLastname(rs.getString(3));
					cust.setUsername(rs.getString(4));
					cust.setPassword(rs.getString(5));
					}		
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cust;			
			
	}
	
	
	/**
	 * 
	 * Update Customer Service plan
	 * @param custId
	 * @param serviceId
	 * @return
	 */
	public boolean updateCustomer(int custId, int serviceId) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("contextservlet.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("mySessionFactory");
		
		Session session = sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("update Customer set serviceid = :serviceId where id = :custId");
		query.setParameter("serviceId", serviceId);
		query.setParameter("custId", custId);
		int result = query.executeUpdate();
		tx.commit();
		if (result == 1)
			return true;
		else
			return false;
	}
	
}
