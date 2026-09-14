package team260914.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team260914.model.dto.CategoryDto;
import team260914.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequiredArgsConstructor         
@RequestMapping ("/api/categories")
@CrossOrigin (value = "http://localhost:5173")
public class CategoryController {

    private final CategoryService categoryService;

//--------------------------------------------------------------------------------------
//  [카테고리 등록 기능] categoryWrite()

@PostMapping("")
public boolean categoryWrite( @RequestBody CategoryDto categoryDto ){
    return categoryService.categoryWrite( categoryDto );
}

//--------------------------------------------------------------------------------------
//  [카테고리 전체 조회 기능] categoryRead()

@GetMapping("")
public List<CategoryDto> categoryRead( ){
    return categoryService.categoryRead();
}

//--------------------------------------------------------------------------------------
//  [카테고리 삭제 기능] categoryDelete()

@DeleteMapping("")
public boolean categoryDelete(@RequestParam( name = "cno") Integer cno ){
    return categoryService.categoryDelete(cno);
}

//--------------------------------------------------------------------------------------

}
