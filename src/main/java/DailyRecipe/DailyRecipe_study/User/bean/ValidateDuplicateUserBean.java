package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.domain.User;
import DailyRecipe.DailyRecipe_study.User.repository.UserRepository;

public class ValidateDuplicateUserBean {
    private final UserRepository userRepository;

    public ValidateDuplicateUserBean(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean exec(String name){
        User user = userRepository.findByName(name);
        if (user == null)return true;
        else return false;
    }
}
