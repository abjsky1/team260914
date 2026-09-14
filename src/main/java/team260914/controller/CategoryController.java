package team260914.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team260914.service.CategoryService;

@RestController 
@RequiredArgsConstructor         
@RequestMapping ("/api/categories")
@CrossOrigin (value = "http://localhost:5173")
public class CategoryController {

    private final CategoryService categoryServicel;


//--------------------------------------------------------------------------------------
//  [카테고리 등록 기능]




//--------------------------------------------------------------------------------------
//  [카테고리 전체 조회 기능]





//--------------------------------------------------------------------------------------
//  [카테고리 삭제 기능]





//--------------------------------------------------------------------------------------


}
