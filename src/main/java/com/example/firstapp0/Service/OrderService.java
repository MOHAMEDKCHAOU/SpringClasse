package com.example.firstapp0.Service;

import com.example.firstapp0.Entity.Order0;
import com.example.firstapp0.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order0> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order0 getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order0 createOrder(Order0 order) {
        return orderRepository.save(order);
    }

    public Order0 updateOrder(int id, Order0 order) {
        order.setId(id);
        return orderRepository.save(order);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
