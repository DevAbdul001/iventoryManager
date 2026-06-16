package com.inventory.app.Services;

import com.inventory.app.DTO.InventoryDTO.CreateInventoryDTO;
import com.inventory.app.DTO.InventoryDTO.InventoryDTO;
import com.inventory.app.Models.Inventory;
import com.inventory.app.Models.Product;
import com.inventory.app.Repositories.InventoryRepository;
import com.inventory.app.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    public InventoryRepository inventoryRepository;
    public ProductService productService;
    public ProductRepository productRepository;


    public InventoryService(InventoryRepository inventoryRepository, ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }

    private InventoryDTO toDTO(Inventory inventory) {
        return new InventoryDTO(
                inventory.getId(),
                inventory.getProduct().getId(),
                inventory.getProduct().getName(),
                inventory.getQuantity()
        );
    }


    public InventoryDTO createInventory( CreateInventoryDTO dto){
        Product product = productRepository.findById(dto.productId())
                .orElseThrow(()-> new RuntimeException("Product not found"));

        Inventory inventory = new Inventory(
                product,
                dto.quantity()
        );

        String productName = product.getName();

        inventoryRepository.save(inventory);
        return  new InventoryDTO(
                inventory.getId(),
                inventory.getProduct().getId(),
                productName,
                inventory.getQuantity()

        );
    }

    public List<InventoryDTO> fetchInventory() {
        return inventoryRepository.findAllWithProduct()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public InventoryDTO fetchInventoryById(Long id){
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Inventory doesnt exist"));

        return  InventoryDTO.fromEntity(inventory);
    }

  public void  deleteInventory(Long id){
        inventoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Inventory doest exist"));

        inventoryRepository.deleteById(id);
  }
}
