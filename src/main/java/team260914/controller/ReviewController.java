package team260914.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team260914.service.ReviewService;

@RestController 
@RequiredArgsConstructor         
@RequestMapping ("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;


//--------------------------------------------------------------------------------------
//  [제품별 리뷰 조회 기능]




//--------------------------------------------------------------------------------------
//  [제품 리뷰 등록 기능]





//--------------------------------------------------------------------------------------
//  [제품 리뷰 삭제 기능]





//--------------------------------------------------------------------------------------


}
