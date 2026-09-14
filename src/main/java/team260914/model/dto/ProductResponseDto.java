package team260914.model.dto;

import team260914.model.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder @Data 
public class ProductResponseDto {
    private Integer bno;
    private String name;
    private Integer price;

    //카테고리 번호
    private Integer cno;

    private String categoryname;

  

    public static ProductResponseDto from(ProductEntity productEntity){
        return ProductResponseDto.builder()
            .bno(productEntity.getBno())
            .name(productEntity.getName())
            .price(productEntity.getPrice())
            .cno(productEntity.getCategoryEntity().getCno())
            .categoryname(productEntity.getCategoryEntity().getName())
            .build();
    }
}
