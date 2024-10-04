package DailyRecipe.DailyRecipe_study.Recipe.bean.small;

import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.DeleteRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.repository.RecipeDAORepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteRecipeDAOBean {
    private final RecipeDAORepository recipeDAORepository;

    public DeleteRecipeDAOBean(RecipeDAORepository recipeDAORepository){
        this.recipeDAORepository = recipeDAORepository;
    }

    public boolean exec(DeleteRecipeRequestDTO deleteRecipeRequestDTO){
        recipeDAORepository.deleteById(deleteRecipeRequestDTO.getRecipeId());
        return true;
    }
}
