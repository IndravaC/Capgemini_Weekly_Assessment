package com.hibernate.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.dao.OrderDAO;
import com.hibernate.entity.Order;
import com.hibernate.util.JPAUtil;

public class OrderDAOImpl implements OrderDAO {

 @Override
 public String saveOrder(Order order) {

  EntityManager em = JPAUtil.getEntityManager();
  EntityTransaction tx = em.getTransaction();

  tx.begin();
  em.persist(order);
  tx.commit();

  em.close();

  return "Order Saved";
 }

 @Override
 public String updateOrder(Order order) {

  EntityManager em = JPAUtil.getEntityManager();
  EntityTransaction tx = em.getTransaction();

  tx.begin();
  em.merge(order);
  tx.commit();

  em.close();

  return "Order Updated";
 }

 @Override
 public String deleteOrderById(int id) {

  EntityManager em = JPAUtil.getEntityManager();
  EntityTransaction tx = em.getTransaction();

  tx.begin();

  Order order = em.find(Order.class,id);
  em.remove(order);

  tx.commit();
  em.close();

  return "Order Deleted";
 }

 @Override
 public Order getOrderById(int id) {

  EntityManager em = JPAUtil.getEntityManager();

  Order order = em.find(Order.class,id);

  em.close();

  return order;
 }

}