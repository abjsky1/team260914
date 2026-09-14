package team260914.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Table (name = "product")
@NoArgsConstructor @AllArgsConstructor @Data @Builder 
public class ProductEntity extends BaseTime {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer bno;

    private String name;

    
    private String price;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "cno")
    private CategoryEntity categoryEntity;

    @OneToMany (mappedBy = "productEntity" ,cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<ReviewEntity> reviewEntities = new ArrayList<>();

}
