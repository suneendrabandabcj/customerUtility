

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.xcelenergy.electricityservice.clients.restclient.CustomerServiceConsumer;
import com.xcelenergy.electricityservice.models.registration.Customer;


public class CustomerServiceTests {

	private static CustomerServiceConsumer customerService;
	private static Customer customer;
	
	@Test
	public void test() {
		
		customerService = Mockito.mock(CustomerServiceConsumer.class);
		customer = new Customer();
		customer.setCid(31);
		customer.setFirstname("s");
		customer.setLastname("a");
		customer.setPassword("a");
		customer.setUsername("a");
		
		when(customerService.getCustomerById(31)).thenReturn(customer);
		
		Customer cust = customerService.getCustomerById(31);
		assertSame(customer, cust);
	}

}
