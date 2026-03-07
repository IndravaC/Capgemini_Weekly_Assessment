package com.hibernate.dao;

import com.hibernate.entity.Order;

public interface OrderDAO {

 String saveOrder(Order order);

 String updateOrder(Order order);

 String deleteOrderById(int id);

 Order getOrderById(int id);

}