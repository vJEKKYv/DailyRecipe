package DailyRecipe.DailyRecipe_study.User.domain.dto;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
public class SaveUserRequestDTO {
    private UUID id;
    private String name;
    private String password;
}
