package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.SaveUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.repository.UserDAORepository;
import org.springframework.stereotype.Component;

@Component
public class SaveUserBean {
    private final UserDAORepository userDAORepository;

    public SaveUserBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }
    public boolean exec(SaveUserRequestDTO saveUserRequestDTO){
        UserDAO userDAO = userDAORepository.findByName(saveUserRequestDTO.getName());
        if (userDAO ==null){
            userDAO = new UserDAO();
            userDAO.setName(saveUserRequestDTO.getName());
            userDAO.setPassword(saveUserRequestDTO.getPassword());
            userDAORepository.save(userDAO);
            return true;
        }
        else return false;
    }
}
