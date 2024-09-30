package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.domain.User;
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
        User user = userRepository.findByName(duplicateUserRequestDTO.getName());
        if (user == null)return true;
        else return false;
    }
}
