package DailyRecipe.DailyRecipe_study.Recipe.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RecipeDAO {
    @Id
    @Column(updatable = false, nullable = false)
    private UUID recipeId;
    private UUID userId;
    private String thumbnail;
    private String title;
    private String description;
    private String createdAt;

    @Convert(converter = ListAndStringConverter.class)
    private List<Map<String, Object>> ingredient;
    @Convert(converter = ListAndStringConverter.class)
    private List<Map<String, Object>> instruction;
}
