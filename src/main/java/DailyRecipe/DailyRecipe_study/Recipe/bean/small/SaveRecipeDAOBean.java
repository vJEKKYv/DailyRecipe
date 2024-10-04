package DailyRecipe.DailyRecipe_study.Recipe.bean.small;

import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.SaveRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.repository.RecipeDAORepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveRecipeDAOBean {
    private final RecipeDAORepository recipeDAORepository;

    public SaveRecipeDAOBean(RecipeDAORepository recipeDAORepository){
        this.recipeDAORepository = recipeDAORepository;
    }

    public UUID exec(RecipeDAO recipeDAO){
        return recipeDAORepository.save(recipeDAO).getRecipeId();
    }
}
