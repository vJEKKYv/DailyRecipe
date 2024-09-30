package DailyRecipe.DailyRecipe_study.User.bean.small;

import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.SignupUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.repository.UserDAORepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserDAOBean {
    private final UserDAORepository userDAORepository;

    public CreateUserDAOBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }
    public UserDAO exec(SignupUserRequestDTO signupUserRequestDTO){
        return UserDAO.builder()
                .id(UUID.randomUUID())
                .userName(signupUserRequestDTO.getUserName())
                .password(signupUserRequestDTO.getPassword())
                .build();
    }
}
