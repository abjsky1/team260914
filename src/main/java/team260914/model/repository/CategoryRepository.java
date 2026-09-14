package team260914.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team260914.model.entity.CategoryEntity;

@Repository 
public interface  CategoryRepository extends JpaRepository<CategoryEntity,Integer>{

}
