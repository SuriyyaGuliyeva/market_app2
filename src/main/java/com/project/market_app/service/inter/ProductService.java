package com.project.market_app.service.inter;

import com.project.market_app.dto.AddProductDto;
import com.project.market_app.dto.ProductInfoDto;
import com.project.market_app.dto.UpdateProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductInfoDto> productList();

    ProductInfoDto productInfo(Long id);

    void addProduct(AddProductDto addProductDto);

    void updateProduct(UpdateProductDto updateProductDto);

    void deleteProduct(Long id);

}
