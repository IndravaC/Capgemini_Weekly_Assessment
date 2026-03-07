package com.hibernate.daoimpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.dao.CustomerDAO;
import com.hibernate.entity.Customer;
import com.hibernate.util.JPAUtil;

public class CustomerDAOImpl implements CustomerDAO {

 @Override
 public String saveCustomer(Customer customer) {

  EntityManager em = JPAUtil.getEntityManager();
  EntityTransaction tx = em.getTransaction();

  tx.begin();
  em.persist(customer);
  tx.commit();

  em.close();

  return "Customer Saved Successfully";
 }

 @Override
 public String updateCustomer(Customer customer) {

  EntityManager em = JPAUtil.getEntityManager();
  EntityTransaction tx = em.getTransaction();

  tx.begin();
  em.merge(customer);
  tx.commit();

  em.close();

  return "Customer Updated";
 }

 @Override
 public String deleteCustomerById(int id) {

  EntityManager em = JPAUtil.getEntityManager();
  EntityTransaction tx = em.getTransaction();

  tx.begin();

  Customer c = em.find(Customer.class,id);
  em.remove(c);

  tx.commit();
  em.close();

  return "Customer Deleted";
 }

 @Override
 public Customer getCustomerById(int id) {

  EntityManager em = JPAUtil.getEntityManager();
  Customer c = em.find(Customer.class,id);
  em.close();

  return c;
 }

 @Override
 public List<Customer> getAllCustomers() {

  EntityManager em = JPAUtil.getEntityManager();

  List<Customer> list =
   em.createQuery("FROM Customer",Customer.class).getResultList();

  em.close();

  return list;
 }

 @Override
 public Customer getCustomerByEmail(String email) {

  EntityManager em = JPAUtil.getEntityManager();

  Customer customer =
   em.createQuery(
    "SELECT c FROM Customer c WHERE c.email = :email",
    Customer.class)
    .setParameter("email", email)
    .getSingleResult();

  em.close();

  return customer;
 }

}