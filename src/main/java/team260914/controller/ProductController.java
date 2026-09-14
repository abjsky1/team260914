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
}
