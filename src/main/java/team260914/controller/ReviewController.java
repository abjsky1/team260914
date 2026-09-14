package team260914.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team260914.model.dto.ReviewDto;
import team260914.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequiredArgsConstructor         
@RequestMapping ("/api/reviews")
@CrossOrigin (value = "http://localhost:5173")
public class ReviewController {

    private final ReviewService reviewService;


//--------------------------------------------------------------------------------------
//  [제품별 리뷰 조회 기능]
    @GetMapping("")
    public List<ReviewDto> 제품별리뷰조회(@RequestParam (name = "bno") int bno) {
        return reviewService.제품별리뷰조회(bno);
    }


//--------------------------------------------------------------------------------------
//  [제품 리뷰 등록 기능]
    @PostMapping("")
    public boolean 제품리뷰등록(@RequestBody ReviewDto reviewDto) {
        return reviewService.제품리뷰등록(reviewDto);
    }
    
//--------------------------------------------------------------------------------------
//  [제품 리뷰 삭제 기능]
    @DeleteMapping ("")
    public boolean 제품리뷰삭제(@RequestParam (name = "rno")int rno){
        return reviewService.제품리뷰삭제(rno);
    }


//--------------------------------------------------------------------------------------


}
