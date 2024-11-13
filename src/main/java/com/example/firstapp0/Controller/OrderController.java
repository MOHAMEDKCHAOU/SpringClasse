package com.example.firstapp0.Controller;

import com.example.firstapp0.Entity.Order0;
import com.example.firstapp0.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order0> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order0 getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order0 createOrder(@RequestBody Order0 order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order0 updateOrder(@PathVariable int id, @RequestBody Order0 order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}
