package com.project.market_app.service.impl;

import com.project.market_app.dto.AddBrandDto;
import com.project.market_app.dto.BrandInfoDto;
import com.project.market_app.dto.UpdateBrandDto;
import com.project.market_app.model.Brand;
import com.project.market_app.repository.BrandRepository;
import com.project.market_app.service.inter.BrandService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandInfoDto> brandList() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandInfoDto> brandDtos = brands.stream()
                .map(brand -> modelMapper.map(brand, BrandInfoDto.class)).collect(Collectors.toList());

        return brandDtos;
    }

    @Override
    public BrandInfoDto brandInfo(Long id) {
        Brand brand = brandRepository.brandInfo(id);
        BrandInfoDto brandInfoDto = modelMapper.map(brand, BrandInfoDto.class);

        return brandInfoDto;
    }

    @Override
    public void addbrand(AddBrandDto addBrandDto) {
        Brand brand = modelMapper.map(addBrandDto, Brand.class);
        brandRepository.save(brand);
    }

    // Bu, brand-in update metodudur. Bu kodun duzgunluyunden emin deyilem.
    // Hemcinin run etdikde swagger faylda menden id ve name yazmagi teleb edir. Sualim odur ki, id teleb etmesi duzgundurmu?
    @Override
    public void updateBrand(UpdateBrandDto updateBrandDto) {
        Brand oldBrand = brandRepository.findById(updateBrandDto.getId()).get();
        oldBrand.setName(updateBrandDto.getName());

        brandRepository.save(oldBrand);
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

}
