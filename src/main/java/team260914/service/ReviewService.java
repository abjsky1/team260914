package team260914.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import team260914.model.dto.ReviewDto;
import team260914.model.entity.ProductEntity;
import team260914.model.entity.ReviewEntity;
import team260914.model.repository.ProductRepository;
import team260914.model.repository.ReviewRepository;

@Service 
@RequiredArgsConstructor 
public class ReviewService {
    
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;


//--------------------------------------------------------------------------------------
//  [제품별 리뷰 조회 기능]
    public List<ReviewDto> 제품별리뷰조회(int bno){
        // 다 꺼내와서 비교 
        List<ReviewEntity> reviewEntities = reviewRepository.findAll();

        // 찾는 bno가 있으면 reviewEntity를 담을 배열 선언
        List<ReviewDto> list = reviewEntities.stream().map((reviewEntity)->{return ReviewDto.from(reviewEntity);}).toList();
        

        return list;
    }



//--------------------------------------------------------------------------------------
//  [제품 리뷰 등록 기능]
    public boolean 제품리뷰등록(ReviewDto reviewDto){
        ProductEntity productEntity =  productRepository.findById(reviewDto.getBno()).orElse(null);
        if(productEntity.getBno() >= 1){
            ReviewEntity reviewEntity = reviewDto.toEntity();
            // reviewEntity에 productEntity 저장
            reviewEntity.setProductEntity(productEntity);
            ReviewEntity savedEntity = reviewRepository.save(reviewEntity);
            if(savedEntity.getRno() >=1 ){ return true; }
        }
        return false;
    }


//--------------------------------------------------------------------------------------
//  [제품 리뷰 삭제 기능]
    public boolean 제품리뷰삭제(int rno){
        ReviewEntity reviewEntity = reviewRepository.findById(rno).orElse(null);
        // 저장리뷰 pk가 있고 제품pk가 있을때 삭제
        if(reviewEntity.getProductEntity().getBno() >= 1){
            reviewRepository.deleteById(rno);
            return true;
        }
        return false;
    }




//--------------------------------------------------------------------------------------

}
