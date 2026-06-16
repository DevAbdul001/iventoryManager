package com.inventory.app.Controllers;

import com.inventory.app.DTO.OrderDTO.CreateOrderDTO;
import com.inventory.app.DTO.OrderDTO.OrderDTO;
import com.inventory.app.Services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO create(
            @RequestBody CreateOrderDTO dto
            ){
       return orderService.createOrder(
               dto.userId(),
               dto.total(),
               String.valueOf(dto.total())
       ) ;
    }

    @GetMapping
    public List<OrderDTO> fetchAll(){
       return orderService.fetchOrders();
    }

    @GetMapping("/{orderId}")
    public OrderDTO fetchOrderById(@PathVariable Long id){
        return orderService.fetchOrderById(id);
    }

    @PatchMapping("/update/{orderId}/{status}")
    public OrderDTO updateOrderStatus(
            @PathVariable String status,
            @PathVariable Long orderId
    ){
        return orderService.updateOrderStatus(status, orderId);
    }

    @DeleteMapping("/delete/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(
            @PathVariable Long orderId
    ){
        orderService.deleteOrder(orderId);
    }
}
