package team260914.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team260914.model.dto.PostProductDto;
import team260914.model.dto.ProductResponseDto;
import team260914.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController 
@RequiredArgsConstructor         
@RequestMapping ("/api/products")
@CrossOrigin (value = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;


//--------------------------------------------------------------------------------------
//  [제품 등록 기능] --현준
    @PostMapping("")
    public PostProductDto productSave(@RequestBody PostProductDto postProductDto) {
        
        return productService.productSave(postProductDto);
    }

//--------------------------------------------------------------------------------------
//  [제품 전체 조회 기능] --현준
    @GetMapping("")
    public List<ProductResponseDto> productfindAll() {
        return productService.productfindAll();
    }
    




//--------------------------------------------------------------------------------------
//  [제품 수정 기능]





//--------------------------------------------------------------------------------------
//  [제품 삭제 기능]





//--------------------------------------------------------------------------------------


}
