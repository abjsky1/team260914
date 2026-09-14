package team260914.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team260914.model.entity.ProductEntity;

@NoArgsConstructor @AllArgsConstructor @Builder @Data 
public class PostProductDto {
    private Integer bno;
    private String name;
    private Integer price;

    //카테고리 번호
    private Integer cno;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
            .name(this.name)
            .price(this.price)
            // cno 는 서비스에서 
            .build();
    }

    public static PostProductDto from(ProductEntity productEntity){
        return PostProductDto.builder()
            .bno(productEntity.getBno())
            .name(productEntity.getName())
            .price(productEntity.getPrice())
            .cno(productEntity.getCategoryEntity().getCno())
            .build();
    }
}
