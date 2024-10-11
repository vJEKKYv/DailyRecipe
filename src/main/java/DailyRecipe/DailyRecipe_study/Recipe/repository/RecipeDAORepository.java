package DailyRecipe.DailyRecipe_study.Recipe.repository;

import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeDAORepository extends JpaRepository <RecipeDAO, UUID>{
    public List<RecipeDAO> findByUserId(UUID userId);
}
