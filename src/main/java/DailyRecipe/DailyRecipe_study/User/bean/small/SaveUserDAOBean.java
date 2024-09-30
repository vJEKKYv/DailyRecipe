package DailyRecipe.DailyRecipe_study.User.bean.small;

import DailyRecipe.DailyRecipe_study.User.bean.SaveUserBean;
import DailyRecipe.DailyRecipe_study.User.controller.UserController;
import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.repository.UserDAORepository;
import org.springframework.stereotype.Component;

@Component
public class SaveUserDAOBean {
    private final UserDAORepository userDAORepository;

    public SaveUserDAOBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }
    public void exec(UserDAO userDAO){
        userDAORepository.save(userDAO);
    }
}
