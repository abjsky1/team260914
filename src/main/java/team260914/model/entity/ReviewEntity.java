package team260914.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table (name = "review")
@AllArgsConstructor @NoArgsConstructor @Data @Builder 
public class ReviewEntity extends BaseTime{

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer rno;

    @Column 
    private String reviewer;

    @Column 
    private String content;

    @Column 
    private double rating;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "bno")
    private ProductEntity productEntity;
    
}
