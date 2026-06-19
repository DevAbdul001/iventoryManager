package com.inventory.app.Controllers;

import com.inventory.app.DTO.ProductDTO.CreateProductDTO;
import com.inventory.app.DTO.ProductDTO.ProductDTO;
import com.inventory.app.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody CreateProductDTO dto){
        return productService.createProduct(dto);
    }

    @GetMapping
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public ProductDTO getProductById(
            @PathVariable Long productId
    ){
        return  productService.getProductById(productId);
    }

    @PatchMapping("/{productId}")
    public ProductDTO updateProduct(
            @PathVariable Long productId,
            @RequestBody BigDecimal price
    ){
        return productService.updateProduct(productId, price);
    }


    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(
            @PathVariable Long productId
    ){
        productService.deleteProduct(productId);
    }
}
