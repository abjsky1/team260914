package team260914.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team260914.model.entity.CategoryEntity;
import team260914.model.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer>{

}
