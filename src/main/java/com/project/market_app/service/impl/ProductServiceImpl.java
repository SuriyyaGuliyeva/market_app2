package com.project.market_app.service.impl;

import com.project.market_app.dto.AddProductDto;
import com.project.market_app.dto.BrandInfoDto;
import com.project.market_app.dto.ProductInfoDto;
import com.project.market_app.dto.UpdateProductDto;
import com.project.market_app.model.Brand;
import com.project.market_app.model.Product;
import com.project.market_app.repository.ProductRepository;
import com.project.market_app.service.inter.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductInfoDto> productList() {
        List<Product> products = productRepository.productList();

        // burada info ve add-de etdiyimiz kimi brand-i map etmeliyik.
        List<ProductInfoDto> productsDto = products.stream()
                .map(product -> modelMapper.map(product, ProductInfoDto.class)).collect(Collectors.toList());

        return productsDto;
    }

    @Override
    public ProductInfoDto productInfo(Long id) {
        Product product = productRepository.productInfo(id);
        ProductInfoDto productInfoDto = modelMapper.map(product, ProductInfoDto.class);

        // product objectin icinde olan brand-i productinfodto-da olan brand-e map edirik
        productInfoDto.setBrandInfo(modelMapper.map(product.getBrand(), BrandInfoDto.class));
        return productInfoDto;
    }

    @Override
    public void addProduct(AddProductDto addProductDto) {
        Product product = modelMapper.map(addProductDto, Product.class);

        product.setBrand(modelMapper.map(addProductDto.getBrandInfo(), Brand.class));
        productRepository.save(product);
    }

    @Override
    public void updateProduct(UpdateProductDto updateProductDto) {
        Product oldProduct = productRepository.findById(updateProductDto.getId()).get();

        oldProduct.setName(updateProductDto.getName());
        oldProduct.setBalance(updateProductDto.getBalance());
        oldProduct.setBrand(modelMapper.map(updateProductDto.getBrandInfo(), Brand.class));
        oldProduct.setPrice(updateProductDto.getPrice());
        oldProduct.setDiscountPrice(updateProductDto.getDiscountPrice());
        oldProduct.setBarcode(updateProductDto.getBarcode());

        productRepository.save(oldProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteProductById(id);
    }

}
