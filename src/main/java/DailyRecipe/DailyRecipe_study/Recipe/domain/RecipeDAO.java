package DailyRecipe.DailyRecipe_study.Recipe.domain;


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
    private UUID recipeId;
    private UUID userId;
    private String thumbnail;
    private String title;
    private String description;
    private Map<String, String> ingredient;
    private Map<String, String> instruction;
    private Date createdAt;
}
