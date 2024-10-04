package DailyRecipe.DailyRecipe_study.Recipe.bean.small;

import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.DeleteRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.repository.RecipeDAORepository;

public class DeleteRecipeDAOBean {
    private final RecipeDAORepository recipeDAORepository;

    public DeleteRecipeDAOBean(RecipeDAORepository recipeDAORepository){
        this.recipeDAORepository = recipeDAORepository;
    }

    public boolean exec(DeleteRecipeRequestDTO deleteRecipeRequestDTO){
        recipeDAORepository.deleteById(deleteRecipeRequestDTO.getId());
        return true;
    }
}
