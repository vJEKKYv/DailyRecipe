package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.bean.small.CreateUserDAOBean;
import DailyRecipe.DailyRecipe_study.User.bean.small.GetUserDAOBean;
import DailyRecipe.DailyRecipe_study.User.bean.small.SaveUserDAOBean;
import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.SignupUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.repository.UserDAORepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveUserBean {
    private final GetUserDAOBean getUserDAOBean;
    private final CreateUserDAOBean createUserDAOBean;
    private final SaveUserDAOBean saveUserDAOBean;

    public SaveUserBean(GetUserDAOBean getUserDAOBean, CreateUserDAOBean createUserDAOBean,
                        SaveUserDAOBean saveUserDAOBean){
        this.getUserDAOBean = getUserDAOBean;
        this.createUserDAOBean = createUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
    }
    public UUID exec(SignupUserRequestDTO signupUserRequestDTO){
        UserDAO userDAO = getUserDAOBean.exec(signupUserRequestDTO.getUserName());
        if (userDAO ==null){
            userDAO = createUserDAOBean.exec(signupUserRequestDTO);
            return saveUserDAOBean.exec(userDAO);
        }
        else return null;
    }
}
