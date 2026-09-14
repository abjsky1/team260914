package team260914.service;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import team260914.model.dto.PostProductDto;
import team260914.model.dto.ProductResponseDto;
import team260914.model.dto.ProductUpdateDto;
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
@Transactional 
public boolean productUpdate(@RequestBody ProductUpdateDto productUpdateDto){
    
    Optional<ProductEntity> optional1 = productRepository.findById(productUpdateDto.getBno()); 

    Optional<CategoryEntity> optional2 = categoryRepository.findById(productUpdateDto.getCno());

    if (optional1.isPresent()) {
        ProductEntity productEntity = optional1.get();

        if(optional2.isPresent()){

            productEntity.setName(productUpdateDto.getName());
            productEntity.setPrice(productUpdateDto.getPrice());
            
            CategoryEntity categoryEntity = optional2.get();
            productEntity.setCategoryEntity(categoryEntity);
            return true;

        }
        
    }
    return false;
}




//--------------------------------------------------------------------------------------
//  [제품 삭제 기능]
public boolean productDelete(Integer bno){

    Optional<ProductEntity> optional = productRepository.findById(bno);

    if (optional.isPresent()) {
        ProductEntity productEntity = optional.get();
        productRepository.delete(productEntity);
        return true;
    }
    return false;
}




//--------------------------------------------------------------------------------------

}
