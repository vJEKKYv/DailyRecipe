package DailyRecipe.DailyRecipe_study.Recipe.bean.small;

import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.repository.RecipeDAORepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindRecipeDAOBean {
    private final RecipeDAORepository recipeDAORepository;

    public FindRecipeDAOBean(RecipeDAORepository recipeDAORepository){
        this.recipeDAORepository = recipeDAORepository;
    }

    public List<RecipeDAO> exec(){
        return recipeDAORepository.findAll();
    }
}
