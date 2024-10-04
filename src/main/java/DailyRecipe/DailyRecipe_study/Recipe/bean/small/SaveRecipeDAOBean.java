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

    public UUID exec(SaveRecipeRequestDTO saveRecipeRequestDTO){
        RecipeDAO recipeDAO = null;
        UUID id = UUID.randomUUID();
        RecipeDAO.builder().recipeId(id)
                .userId(saveRecipeRequestDTO.getUserId())
                .thumbnail(saveRecipeRequestDTO.getThumbnail())
                .title(saveRecipeRequestDTO.getTitle())
                .description(saveRecipeRequestDTO.getDescription())
                .ingredient(saveRecipeRequestDTO.getIngredient())
                .instruction(saveRecipeRequestDTO.getInstruction())
                .createdAt(saveRecipeRequestDTO.getCreatedAt())
                .build();
        recipeDAORepository.save(recipeDAO);
        return  id;
    }
    public UUID exec(RecipeDAO recipeDAO){
        return recipeDAORepository.save(recipeDAO).getRecipeId();
    }
}
