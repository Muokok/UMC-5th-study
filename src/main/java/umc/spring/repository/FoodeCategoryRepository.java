package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.FoodCategory;

public interface FoodeCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
