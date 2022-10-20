package com.stussy.stussyclone20220930h.service.admin;

import com.stussy.stussyclone20220930h.domain.Product;
import com.stussy.stussyclone20220930h.dto.admin.CategoryResponseDto;
import com.stussy.stussyclone20220930h.dto.admin.ProductRegisterReqDto;
import com.stussy.stussyclone20220930h.repository.admin.ProductManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManagementServiceImpl implements ProductManagementService {

    private final ProductManagementRepository productManagementRepository;

    @Override
    public List<CategoryResponseDto> getCategoryList() throws Exception {
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<CategoryResponseDto>();
        productManagementRepository.getCategoryList().forEach(category -> {
            categoryResponseDtos.add(category.toDto());
        });
        return categoryResponseDtos;
    }

    @Override
    public void registerMst(ProductRegisterReqDto productRegisterReqDto) throws Exception{

    }

}