package DailyRecipe.DailyRecipe_study.Recipe.bean.small;

import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.repository.UserDAORepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CheckUserIdBean {
    private final UserDAORepository userDAORepository;

    public CheckUserIdBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }
    public UUID exec(UUID userId){
        UserDAO userDAOForCheck = userDAORepository.findById(userId).orElse(null);
        if (userDAOForCheck == null)    return null;
        else return userDAOForCheck.getId();
    }
}
