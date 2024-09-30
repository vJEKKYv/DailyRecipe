package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.DuplicateUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.repository.UserDAORepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateDuplicateUserBean {
    private final UserDAORepository userDAORepository;
    public ValidateDuplicateUserBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }
    public boolean exec(DuplicateUserRequestDTO duplicateUserRequestDTO){
        UserDAO userDAO = userDAORepository.findByName(duplicateUserRequestDTO.getName());
        if (userDAO == null)return true;
        else return false;
    }
}
