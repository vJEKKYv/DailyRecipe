package DailyRecipe.DailyRecipe_study.Recipe.bean.small;

import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.repository.RecipeDAORepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetRecipeDAOBean {
    private final RecipeDAORepository recipeDAORepository;

    public GetRecipeDAOBean(RecipeDAORepository recipeDAORepository){
        this.recipeDAORepository = recipeDAORepository;
    }

    public RecipeDAO exec(UUID id){
        return recipeDAORepository.findById(id).orElse(null);
    }

    public List<RecipeDAO> exec(){
        return recipeDAORepository.findAll();
    }
}
