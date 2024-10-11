package DailyRecipe.DailyRecipe_study.Recipe.domain.dto;

import DailyRecipe.DailyRecipe_study.Recipe.domain.ListAndStringConverter;
import jakarta.persistence.Convert;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class UpdateRecipeRequestDTO {
    private UUID recipeId;
    private UUID userId;
    private String thumbnail;
    private String title;
    private String description;

    @Convert(converter = ListAndStringConverter.class)
    private List<Map<String, Object>> ingredient;
    @Convert(converter = ListAndStringConverter.class)
    private List<Map<String, Object>> instruction;
}
