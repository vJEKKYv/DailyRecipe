package DailyRecipe.DailyRecipe_study.Recipe.bean.small;

import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.repository.RecipeDAORepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetRecipeDAOByUserIdBean {
    private final RecipeDAORepository recipeDAORepository;

    public GetRecipeDAOByUserIdBean(RecipeDAORepository recipeDAORepository){
        this.recipeDAORepository = recipeDAORepository;
    }

    public List<RecipeDAO> exec(UUID userId){
        return recipeDAORepository.findByUserId(userId);
    }
}
