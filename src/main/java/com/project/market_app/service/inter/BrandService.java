package com.project.market_app.service.inter;

import com.project.market_app.dto.AddBrandDto;
import com.project.market_app.dto.BrandInfoDto;
import com.project.market_app.dto.UpdateBrandDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    BrandInfoDto brandInfo(Long id);

    List<BrandInfoDto> brandList();

    void addbrand(AddBrandDto addBrandDto);

    void updateBrand(UpdateBrandDto updateBrandDto);

    void deleteBrand(Long id);
}
