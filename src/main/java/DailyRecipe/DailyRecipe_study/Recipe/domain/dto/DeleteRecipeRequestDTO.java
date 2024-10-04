package DailyRecipe.DailyRecipe_study.Recipe.domain.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteRecipeRequestDTO {
    private UUID id;
}
