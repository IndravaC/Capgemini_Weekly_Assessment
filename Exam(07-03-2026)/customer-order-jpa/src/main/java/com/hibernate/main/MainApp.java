package com.hibernate.main;

import java.time.LocalDate;
import java.util.List;

import com.hibernate.dao.CustomerDAO;
import com.hibernate.dao.OrderDAO;
import com.hibernate.daoimpl.CustomerDAOImpl;
import com.hibernate.daoimpl.OrderDAOImpl;
import com.hibernate.entity.Customer;
import com.hibernate.entity.Order;

public class MainApp {

 public static void main(String[] args) {

  CustomerDAO customerDAO = new CustomerDAOImpl();
  OrderDAO orderDAO = new OrderDAOImpl();

  System.out.println("INSERTING MULTIPLE CUSTOMERS");

  Order o1 = new Order("ORD101","Laptop",1,75000,LocalDate.now());
  Customer c1 = new Customer("Rahul Sharma","rahul@gmail.com","Male",9876543210L,LocalDate.now());
  c1.setOrder(o1);

  Order o2 = new Order("ORD102","Mobile",2,40000,LocalDate.now());
  Customer c2 = new Customer("Priya Singh","priya@gmail.com","Female",9876501234L,LocalDate.now());
  c2.setOrder(o2);

  Order o3 = new Order("ORD103","Headphones",3,9000,LocalDate.now());
  Customer c3 = new Customer("Amit Das","amit@gmail.com","Male",9876512345L,LocalDate.now());
  c3.setOrder(o3);

  customerDAO.saveCustomer(c1);
  customerDAO.saveCustomer(c2);
  customerDAO.saveCustomer(c3);

  System.out.println("Customers Inserted Successfully");



  System.out.println("\nINSERT NEW CUSTOMER WITH ORDER");

  Order newOrder = new Order("ORD104","Tablet",1,30000,LocalDate.now());
  Customer newCustomer = new Customer("Sneha Roy","sneha@gmail.com","Female",9876522222L,LocalDate.now());
  newCustomer.setOrder(newOrder);

  System.out.println(customerDAO.saveCustomer(newCustomer));



  System.out.println("\nUPDATE CUSTOMER DETAILS");

  Customer updateCustomer = customerDAO.getCustomerById(1);

  updateCustomer.setCustomerName("Rahul Verma");
  updateCustomer.setPhone(9999999999L);

  System.out.println(customerDAO.updateCustomer(updateCustomer));



  System.out.println("\nDELETE CUSTOMER BY ID");

  System.out.println(customerDAO.deleteCustomerById(3));



  System.out.println("\nFETCH CUSTOMER BY ID");

  Customer customer = customerDAO.getCustomerById(2);

  System.out.println("Customer Name: "+customer.getCustomerName());
  System.out.println("Email: "+customer.getEmail());
  System.out.println("Phone: "+customer.getPhone());



  System.out.println("\nFETCH ALL CUSTOMERS");

  List<Customer> customers = customerDAO.getAllCustomers();

  for(Customer c : customers)
  {
   System.out.println(c.getId()+" "+c.getCustomerName()+" "+c.getEmail());
  }



  System.out.println("\nUPDATE ORDER DETAILS");

  Order order = orderDAO.getOrderById(1);

  order.setProductName("Gaming Laptop");
  order.setPrice(90000);

  System.out.println(orderDAO.updateOrder(order));



  System.out.println("\nFETCH ORDER BY ID");

  Order fetchedOrder = orderDAO.getOrderById(1);

  System.out.println("Order Number: "+fetchedOrder.getOrderNumber());
  System.out.println("Product: "+fetchedOrder.getProductName());
  System.out.println("Price: "+fetchedOrder.getPrice());



  System.out.println("\n----- JPQL QUERY: FETCH CUSTOMER BY EMAIL -----");

  Customer emailCustomer = customerDAO.getCustomerByEmail("rahul@gmail.com");

  System.out.println("Customer Found: "+emailCustomer.getCustomerName());

 }

}