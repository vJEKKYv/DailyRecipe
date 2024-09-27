package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.domain.User;
import DailyRecipe.DailyRecipe_study.User.repository.UserRepository;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class SaveUserBean {
    private final UserRepository userRepository;

    public SaveUserBean(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public boolean exec(String name, String password){
        User user = userRepository.findByName(name);
        if (user==null){
            user = new User();
            user.setName(name);
            user.setPassword(password);
            userRepository.save(user);
            return true;
        }
        else return false;
    }
}
