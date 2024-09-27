package DailyRecipe.DailyRecipe_study.User.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Data
public class SaveUserResponseDTO {
    private UUID id;
    private String name;
}
