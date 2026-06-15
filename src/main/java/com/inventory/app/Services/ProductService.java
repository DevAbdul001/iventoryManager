package com.inventory.app.Services;

import com.inventory.app.DTO.ProductDTO.CreateProductDTO;
import com.inventory.app.DTO.ProductDTO.ProductDTO;
import com.inventory.app.Models.Product;
import com.inventory.app.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

   public ProductService(ProductRepository productRepository){
       this.productRepository = productRepository;
   }

   public ProductDTO createProduct(CreateProductDTO dto){
       Product product = new Product(
               dto.name(),
               dto.description(),
               dto.img_url(),
               dto.price()
       );
       productRepository.save(product);

       return new ProductDTO(
               product.getId(),
               product.getName(),
               product.getDescription(),
               product.getImg_url(),
               product.getPrice()
       );
   }

   public List<ProductDTO> getProducts(){
       List<Product> products = productRepository.findAll();

       return  products.stream()
               .map(product -> new ProductDTO(
                       product.getId(),
                       product.getName(),
                       product.getDescription(),
                       product.getImg_url(),
                       product.getPrice()
               )).toList();
   }

   public ProductDTO getProductById(Long id){
       Product product = productRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Product not found"));

       return  new ProductDTO(
               product.getId(),
               product.getName(),
               product.getDescription(),
               product.getImg_url(),
               product.getPrice()
       );
   }

   public ProductDTO updateProduct(Long id, BigDecimal price){
       Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));

       product.setPrice(price);
       Product updatedProduct = productRepository.save(product);

       return new ProductDTO(
               updatedProduct.getId(),
               updatedProduct.getName(),
               updatedProduct.getDescription(),
               updatedProduct.getImg_url(),
               updatedProduct.getPrice()
       );
   }

   public void deleteProduct(Long id){
       Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
       productRepository.delete(product);
   }
}
