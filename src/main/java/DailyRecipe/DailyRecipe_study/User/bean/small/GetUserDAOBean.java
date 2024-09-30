package DailyRecipe.DailyRecipe_study.User.bean.small;


import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import DailyRecipe.DailyRecipe_study.User.repository.UserDAORepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserDAOBean {
    private final UserDAORepository userDAORepository;
    public GetUserDAOBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }

    //id로 찾기
    public UserDAO exec(UUID id){
        return userDAORepository.findById(id).orElse(null);
    }

    //name으로 찾기
    public UserDAO exec(String userName){
        return userDAORepository.findByUserName(userName);
    }

    //name, password로 찾기
    public UserDAO exec(String userName, String password){
        return userDAORepository.findByUserNameAndPassword(userName, password);
    }
}
