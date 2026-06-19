package com.inventory.app.Controllers;


import com.inventory.app.DTO.OrderDTO.CreateOrderDTO;
import com.inventory.app.DTO.OrderItemDTO.CreateOrderItemDTO;
import com.inventory.app.DTO.OrderItemDTO.OrderItemDTO;
import com.inventory.app.Repositories.OrderItemRepository;
import com.inventory.app.Services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderItem")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemService orderItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItemDTO create(@RequestBody CreateOrderItemDTO dto){
        return orderItemService.create(dto);
    }

    @GetMapping("/{orderId}")
    public List<OrderItemDTO> fetch(
            @PathVariable Long orderId
    ){
        return  orderItemService.fetch(orderId);
    }

    @GetMapping("/{itemId}")
    public OrderItemDTO fetchById(
            @PathVariable Long itemId
    ){
        return orderItemService.fetchById(itemId);
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long itemId
    ){
        orderItemService.delete(itemId);
    }

}

