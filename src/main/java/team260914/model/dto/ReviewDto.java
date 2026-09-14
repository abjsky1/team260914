package team260914.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team260914.model.entity.ReviewEntity;

@AllArgsConstructor @NoArgsConstructor @Data @Builder 
public class ReviewDto {
    // review 테이블
    private Integer rno;
    private String reviewer;
    private String content;
    private double rating;
    // 시간데이터
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 제품 PK
    private Integer bno;

    // DTO -> Entity
    public ReviewEntity toEntity(){
        return ReviewEntity .builder()
        .reviewer(this.reviewer)
        .content(this.content)
        .rating(this.rating)
        .build();
    } // toEntity end

    // Entity -> Dto
    public static ReviewDto from(ReviewEntity reviewEntity){
        return ReviewDto .builder()
        .rno(reviewEntity.getRno())
        .reviewer(reviewEntity.getReviewer())
        .content(reviewEntity.getContent())
        .rating(reviewEntity.getRating())
        .createdAt(reviewEntity.getCreatedAt())
        .updatedAt(reviewEntity.getUpdatedAt())
        // 일단 여기서 pk받음
        .bno(reviewEntity.getProductEntity().getBno())
        .build();
    }
}
