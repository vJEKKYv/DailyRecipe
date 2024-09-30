package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.bean.small.GetUserDAOBean;
import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.LoginUserDTO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.TotalUserResponseDTO;
import DailyRecipe.DailyRecipe_study.User.repository.UserDAORepository;
import org.springframework.stereotype.Component;

@Component
public class LoginBean {
    private final GetUserDAOBean getUserDAOBean;

    public LoginBean(GetUserDAOBean getUserDAOBean){
        this.getUserDAOBean = getUserDAOBean;
    }
    public TotalUserResponseDTO exec(LoginUserDTO loginUserDTO){
        UserDAO userDAO = getUserDAOBean.exec(loginUserDTO.getUserName(), loginUserDTO.getPassword());
        if (userDAO == null)   return null;
        else {
            TotalUserResponseDTO totalUserResponseDTO = new TotalUserResponseDTO();
            totalUserResponseDTO.setId(userDAO.getId());
            totalUserResponseDTO.setUserName(userDAO.getUserName());
            return totalUserResponseDTO;
        }
    }

}
