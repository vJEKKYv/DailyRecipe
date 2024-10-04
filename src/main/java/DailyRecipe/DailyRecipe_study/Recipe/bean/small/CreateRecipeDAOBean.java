package DailyRecipe.DailyRecipe_study.Recipe.bean.small;

import DailyRecipe.DailyRecipe_study.Recipe.bean.SaveRecipeBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.SaveRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.User.bean.small.SaveUserDAOBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateRecipeDAOBean {

    public RecipeDAO exec(SaveRecipeRequestDTO saveRecipeRequestDTO){
        UUID id = UUID.randomUUID();
        return RecipeDAO.builder().recipeId(id)
                .userId(saveRecipeRequestDTO.getUserId())
                .thumbnail(saveRecipeRequestDTO.getThumbnail())
                .title(saveRecipeRequestDTO.getTitle())
                .description(saveRecipeRequestDTO.getDescription())
                .ingredient(saveRecipeRequestDTO.getIngredient())
                .instruction(saveRecipeRequestDTO.getInstruction())
                .createdAt(saveRecipeRequestDTO.getCreatedAt())
                .build();
    }
}
