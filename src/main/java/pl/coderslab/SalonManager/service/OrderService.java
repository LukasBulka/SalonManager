package pl.coderslab.SalonManager.service;

import org.springframework.stereotype.Service;
import pl.coderslab.SalonManager.model.Order;
import pl.coderslab.SalonManager.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}
