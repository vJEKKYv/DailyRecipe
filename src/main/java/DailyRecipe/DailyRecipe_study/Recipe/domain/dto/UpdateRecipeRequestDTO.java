package DailyRecipe.DailyRecipe_study.Recipe.domain.dto;

import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
public class UpdateRecipeRequestDTO {
    private UUID recipeId;
    private UUID userId;
    private String thumbnail;
    private String title;
    private String description;
    private String ingredient;
    private String instruction;
}
