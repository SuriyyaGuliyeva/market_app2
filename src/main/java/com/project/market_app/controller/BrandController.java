package com.project.market_app.controller;

import com.project.market_app.dto.AddBrandDto;
import com.project.market_app.dto.BrandInfoDto;
import com.project.market_app.dto.UpdateBrandDto;
import com.project.market_app.service.inter.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    // list of brand
    @GetMapping("")
    public List<BrandInfoDto> brandList() {
        List<BrandInfoDto> brands = brandService.brandList();
        return brands;
    }

    // brand info
    @GetMapping("/{id}")
    public BrandInfoDto brandInfo(@PathVariable("id") Long id) {
        return brandService.brandInfo(id);
    }

    // add brand
    @PostMapping("/add")
    public void addBrand(@Valid @RequestBody AddBrandDto brandDto) {
        brandService.addbrand(brandDto);
    }

    // update brand
    @PutMapping("/update")
    public void updateBrand(@Valid @RequestBody UpdateBrandDto brandDto) {
        brandService.updateBrand(brandDto);
    }

    // delete brand
    @DeleteMapping("/delete/{id}")
    public void deleteBrand(@PathVariable("id") Long id) {
        brandService.deleteBrand(id);
    }

}
