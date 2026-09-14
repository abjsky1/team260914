package team260914.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import team260914.model.dto.PostProductDto;
import team260914.model.dto.ProductResponseDto;
import team260914.model.entity.CategoryEntity;
import team260914.model.entity.ProductEntity;
import team260914.model.repository.CategoryRepository;
import team260914.model.repository.ProductRepository;

@Service 
@RequiredArgsConstructor 
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


//--------------------------------------------------------------------------------------
//  [제품 등록 기능] --현준
    public PostProductDto productSave(PostProductDto postProductDto){
        // cno 넣어야 해서 category 엔티티 가져오기
        CategoryEntity categoryEntity = categoryRepository.findById(postProductDto.getCno()).orElse(null);
        
        //받은 DTO 엔티티로 변환 후 저장
        ProductEntity productEntity = postProductDto.toEntity();
        
        // 상품 엔티티에 카테고리 번호 부여
        productEntity.setCategoryEntity(categoryEntity);

        // 저장
        ProductEntity saveProductEntity = productRepository.save(productEntity);
       
        //해당엔티티 DTO 변환
        PostProductDto productDto = PostProductDto.from(saveProductEntity);

    
        return productDto;

    }

//--------------------------------------------------------------------------------------
//  [제품 전체 조회 기능] --현준
    public List<ProductResponseDto> productfindAll(){
        List<ProductEntity> productEntities = productRepository.findAll();
        
        List<ProductResponseDto> productResponseDtos = productEntities.stream().map((productEntity) -> {return ProductResponseDto.from(productEntity);}).toList();

        return productResponseDtos;
    }




//--------------------------------------------------------------------------------------
//  [제품 수정 기능]





//--------------------------------------------------------------------------------------
//  [제품 삭제 기능]





//--------------------------------------------------------------------------------------

}
