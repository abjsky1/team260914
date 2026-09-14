package team260914.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team260914.service.ProductService;


@RestController 
@RequiredArgsConstructor         
@RequestMapping ("/api/products")
public class ProductController {

    private final ProductService productService;


//--------------------------------------------------------------------------------------
//  [제품 등록 기능]




//--------------------------------------------------------------------------------------
//  [제품 전체 조회 기능]





//--------------------------------------------------------------------------------------
//  [제품 수정 기능]





//--------------------------------------------------------------------------------------
//  [제품 삭제 기능]





//--------------------------------------------------------------------------------------


}
