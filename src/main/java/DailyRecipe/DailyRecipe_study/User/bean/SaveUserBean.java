package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.domain.User;
import DailyRecipe.DailyRecipe_study.User.domain.dto.SaveUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.repository.UserRepository;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class SaveUserBean {
    private final UserRepository userRepository;

    public SaveUserBean(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public boolean exec(SaveUserRequestDTO saveUserRequestDTO){
        User user = userRepository.findByName(saveUserRequestDTO.getName());
        if (user==null){
            user = new User();
            user.setName(saveUserRequestDTO.getName());
            user.setPassword(saveUserRequestDTO.getPassword());
            userRepository.save(user);
            return true;
        }
        else return false;
    }
}
