package com.inventory.app.Services;

import com.inventory.app.DTO.OrderDTO.CreateOrderDTO;
import com.inventory.app.DTO.OrderItemDTO.CreateOrderItemDTO;
import com.inventory.app.DTO.OrderItemDTO.OrderItemDTO;
import com.inventory.app.Models.Order;
import com.inventory.app.Models.OrderItem;
import com.inventory.app.Models.Product;
import com.inventory.app.Repositories.OrderItemRepository;
import com.inventory.app.Repositories.OrderRepository;
import com.inventory.app.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderItemService(OrderItemRepository orderItemRepository, ProductRepository productRepository, OrderRepository orderRepository){
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    private OrderItemDTO toDTO(OrderItem orderItem){
        return new OrderItemDTO(
                orderItem.getOrderId(),
                orderItem.getProductId(),
                orderItem.getPrice(),
                orderItem.getQuantity(),
                orderItem.getItem().getName(),
                orderItem.getItem().getImg_url()
        );
    }

    public OrderItemDTO create(CreateOrderItemDTO dto){
        Order order = orderRepository.findById(dto.orderId())
                .orElseThrow(()-> new RuntimeException("Order doesnt exist"));

        Product product = productRepository.findById(dto.productId())
                .orElseThrow(()-> new RuntimeException("Product doesnt exists"));

        OrderItem orderItem = new OrderItem(
                product,
                order,
                dto.quantity()
                );
        orderItemRepository.save(orderItem);

        return new OrderItemDTO(
                orderItem.getOrderId(),
                orderItem.getProductId(),
                orderItem.getPrice(),
                orderItem.getQuantity(),
                product.name,
                product.getImg_url()
        );
    }

    public List<OrderItemDTO> fetch(Long orderId){
        return orderItemRepository.findAllWithProducts(orderId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public OrderItemDTO fetchById(Long id)
    {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order Item not found"));

        return OrderItemDTO.fromEntity(orderItem);
    }

    public void delete(Long id){
        orderItemRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order Item doesnt exist"));

        orderItemRepository.deleteById(id);
    }
}



