package DailyRecipe.DailyRecipe_study.User.domain.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TotalUserResponseDTO {
    private UUID id;
    private String name;
}
