package team260914.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team260914.service.CategoryService;

@RestController 
@RequiredArgsConstructor         
@RequestMapping ("/api/categories")
public class CategoryController {

    private final CategoryService categoryServicel;

}
