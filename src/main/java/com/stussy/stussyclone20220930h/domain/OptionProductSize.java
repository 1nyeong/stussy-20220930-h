package com.stussy.stussyclone20220930h.domain;


import com.stussy.stussyclone20220930h.dto.admin.ProductSizeOptionRespDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OptionProductSize {
    private int size_id;
    private String size_name;

    public ProductSizeOptionRespDto toDto() {
        return ProductSizeOptionRespDto.builder()
                .sizeId(size_id)
                .sizeName(size_name)
                .build();
    }
}
