package se.yrgo.client;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.yrgo.domain.Customer;
import se.yrgo.services.customers.CustomerManagementService;

import java.util.List;

public class SimpleClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        CustomerManagementService customerManagementService = (CustomerManagementService) context.getBean("customerManagementService");

//      customerManagementService.newCustomer(new Customer("ABC123", "New Company", "Some notes"));

        List<Customer> customerList = customerManagementService.getAllCustomers();

        if (customerList != null) {
            for (Customer customer : customerList) {
                System.out.println("Customer ID: " + customer.getCustomerId());
                System.out.println("Company: " + customer.getCompanyName());
                System.out.println("Notes: " + customer.getNotes());
                System.out.println();
            }
        } else {
            System.out.println("No customers fuound");
        }
    }
}