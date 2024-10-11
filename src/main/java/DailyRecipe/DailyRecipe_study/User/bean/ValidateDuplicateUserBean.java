package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.bean.small.GetUserDAOBean;
import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.DuplicateUserRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class ValidateDuplicateUserBean {
    private final GetUserDAOBean getUserDAOBean;

    public ValidateDuplicateUserBean(GetUserDAOBean getUserDAOBean){
        this.getUserDAOBean = getUserDAOBean;
    }
    public boolean exec(DuplicateUserRequestDTO duplicateUserRequestDTO){
        UserDAO userDAO = getUserDAOBean.exec(duplicateUserRequestDTO.getUserName());
        return userDAO == null;
    }
}
