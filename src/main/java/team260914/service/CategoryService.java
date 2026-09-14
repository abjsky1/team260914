package team260914.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import team260914.model.dto.CategoryDto;
import team260914.model.entity.CategoryEntity;
import team260914.model.repository.CategoryRepository;

@Service 
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

//--------------------------------------------------------------------------------------
//  [카테고리 등록 기능] categoryWrite()

public boolean categoryWrite( CategoryDto categoryDto ){
    CategoryEntity categoryEntity = categoryDto.toEntity();
    CategoryEntity savedEntity = categoryRepository.save( categoryEntity );
    if( savedEntity.getCno() >= 1 ) return true;
    return false;
}

//--------------------------------------------------------------------------------------
//  [카테고리 전체 조회 기능] categoryRead()

public List<CategoryDto> categoryRead( ){
    List<CategoryEntity> categoryEntities = categoryRepository.findAll();
    List<CategoryDto> categoryDtos = new ArrayList<>();
    categoryEntities.forEach( (categoryEntity) -> {
        CategoryDto categoryDto = CategoryDto.from(categoryEntity);
        categoryDtos.add(categoryDto);
    });
    return categoryDtos;
}

//--------------------------------------------------------------------------------------
//  [카테고리 삭제 기능] categoryDelete()

public boolean categoryDelete( Integer cno ){
    Optional<CategoryEntity> optional = categoryRepository.findById(cno);
    if( optional.isPresent() ){ categoryRepository.delete(optional.get());
        return true;
    }
    return false;
}

//--------------------------------------------------------------------------------------

}
