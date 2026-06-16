package com.inventory.app.Services;

import com.inventory.app.DTO.OrderDTO.OrderDTO;
import com.inventory.app.Models.Order;
import com.inventory.app.Models.User;
import com.inventory.app.Repositories.OrderRepository;
import com.inventory.app.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(
            OrderRepository orderRepository,
            UserRepository userRepository, UserRepository userRepository1
    ){
        this.orderRepository = orderRepository;
        this.userRepository = userRepository1;
    }

    public OrderDTO createOrder(Long userId, BigDecimal total, String status){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User doesnt exist"));

            Order order = new Order (user, total, status);
            orderRepository.save(order);
            return new OrderDTO(
                    order.getId(),
                    order.getUserId(),
                    order.getTotal(),
                    order.getStatus()
            );
    }

    public List<OrderDTO> fetchOrders(){
       List<Order> orders = orderRepository.findAll();

       return  orders.stream()
               .map(order-> new OrderDTO(
                       order.getId(),
                       order.getUserId(),
                       order.getTotal(),
                       order.getStatus()
               )).toList();

    }

    public OrderDTO fetchOrderById(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order doesnt exist"));
        return new OrderDTO(
                order.getId(),
                order.getUserId(),
                order.getTotal(),
                order.getStatus()
        );
    }

    public OrderDTO updateOrderStatus(String status, Long id){
        List<String> allowedStatus = List.of(
                "Pending",
                "Confirmed",
                "Cancelled"
        );

        if(!allowedStatus.contains(status)){
            throw new IllegalArgumentException("Invalid status");
        }

        Order updatedOrder = orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order doesnt exist"));
        updatedOrder.setStatus(status);

        orderRepository.save(updatedOrder);
        return new OrderDTO(
                updatedOrder.getId(),
                updatedOrder.getUserId(),
                updatedOrder.getTotal(),
                updatedOrder.getStatus()
        );

    }

    public void deleteOrder(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order doesnt exist"));
        orderRepository.deleteById(id);
    }


}
