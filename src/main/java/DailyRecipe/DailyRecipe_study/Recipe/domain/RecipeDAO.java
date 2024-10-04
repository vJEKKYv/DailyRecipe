package DailyRecipe.DailyRecipe_study.Recipe.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.net.URL;
import java.sql.Date;
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
    private String ingredient;
    private String instruction;
    private String createdAt;
}
