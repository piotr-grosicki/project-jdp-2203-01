package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private ProductDto bagStub = new ProductDto("bag", 1L, BigDecimal.TEN,true,"Red and hot");

    // private final DbService service;
    //  private final ProductMapper productMapper;


    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        //  List<Product> products = service.getAllProducts();
        //  return ResponseEntity.ok( productMapper.mapToProductDtoList(products));
        return ResponseEntity.ok(getListOfProducts());
    }

    private List<ProductDto> getListOfProducts() {
        List<ProductDto> productList = new ArrayList<>();

        productList.add(bagStub);
        return productList;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        // Product product = productMapper.mapToProduct(productDto);
        //  service.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) { //throws ProductNotFoundException {
        // return ResponseEntity.ok(productMapper.mapToProductDto(service.getProduct(productId)));
        return ResponseEntity.ok(bagStub);
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        // Product product = productMapper.mapToProduct(productDto);
        //  Product savedProduct = service.saveProduct(product);
        // return ResponseEntity.ok(productMapper.mapToProductDto(savedProduct));
        return ResponseEntity.ok(bagStub);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {//throws ProductNotFoundException {
        // service.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

}
