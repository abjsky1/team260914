package team260914.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team260914.model.entity.CategoryEntity;

@NoArgsConstructor @AllArgsConstructor @Builder @Data 
public class CategoryDto {
    
    private Integer cno;
    private String name;

    // @Builder.Default
    // public List<ProductDto> productDtos = new ArrayList<>();

    public CategoryEntity toEntity( ){
        return CategoryEntity.builder()
            .cno(this.cno)
            .name(this.name)
            .build();
    }

    public static CategoryDto from( CategoryEntity entity ){
        return CategoryDto.builder()
            .cno(entity.getCno())
            .name(entity.getName())
            .build();
     }
}   


