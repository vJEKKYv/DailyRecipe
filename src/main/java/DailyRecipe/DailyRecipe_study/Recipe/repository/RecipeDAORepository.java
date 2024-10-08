package DailyRecipe.DailyRecipe_study.Recipe.repository;

import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipeDAORepository extends JpaRepository <RecipeDAO, UUID>{
}
