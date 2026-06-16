package com.inventory.app.Controllers;

import com.inventory.app.DTO.InventoryDTO.CreateInventoryDTO;
import com.inventory.app.DTO.InventoryDTO.InventoryDTO;
import com.inventory.app.Services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryDTO create(@RequestBody CreateInventoryDTO dto){
        return  inventoryService.createInventory(dto);
    }

    @GetMapping
    public List<InventoryDTO> fetchInventories(){
        return inventoryService.fetchInventory();
    }

    @GetMapping("/{id}")
    public InventoryDTO fetchInventoryById(
            @PathVariable Long id
    ){
        return  inventoryService.fetchInventoryById(id);
    }

}
