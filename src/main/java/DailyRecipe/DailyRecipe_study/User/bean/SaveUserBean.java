package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.SaveUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class SaveUserBean {
    private final UserRepository userRepository;

    public SaveUserBean(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public boolean exec(SaveUserRequestDTO saveUserRequestDTO){
        UserDAO userDAO = userRepository.findByName(saveUserRequestDTO.getName());
        if (userDAO ==null){
            userDAO = new UserDAO();
            userDAO.setName(saveUserRequestDTO.getName());
            userDAO.setPassword(saveUserRequestDTO.getPassword());
            userRepository.save(userDAO);
            return true;
        }
        else return false;
    }
}
