package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.DuplicateUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateDuplicateUserBean {
    private final UserRepository userRepository;
    public ValidateDuplicateUserBean(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public boolean exec(DuplicateUserRequestDTO duplicateUserRequestDTO){
        UserDAO userDAO = userRepository.findByName(duplicateUserRequestDTO.getName());
        if (userDAO == null)return true;
        else return false;
    }
}
