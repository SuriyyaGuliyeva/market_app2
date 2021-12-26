package com.project.market_app.controller;

import com.project.market_app.dto.AddProductDto;
import com.project.market_app.dto.ProductInfoDto;
import com.project.market_app.dto.UpdateProductDto;
import com.project.market_app.service.inter.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // list of product
    @GetMapping("")
    public List<ProductInfoDto> productList() {
        List<ProductInfoDto> products = productService.productList();
        return products;
    }

    // product info
    @GetMapping("/{id}")
    public ProductInfoDto productInfo(@PathVariable("id") Long id) {
        ProductInfoDto productInfo = productService.productInfo(id);
        return productInfo;
    }

    // add product
    @PostMapping("/add")
    public void addProduct(@RequestBody AddProductDto productDto) {
        productService.addProduct(productDto);
    }

    // update product
    @PutMapping("/update")
    public void updateProduct(@RequestBody UpdateProductDto productDto) {
        productService.updateProduct(productDto);
    }

    // delete product
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
