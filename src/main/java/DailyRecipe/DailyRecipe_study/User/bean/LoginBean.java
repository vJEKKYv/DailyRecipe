package DailyRecipe.DailyRecipe_study.User.bean;

import DailyRecipe.DailyRecipe_study.User.domain.User;
import DailyRecipe.DailyRecipe_study.User.domain.dto.SaveUserResponseDTO;
import DailyRecipe.DailyRecipe_study.User.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class LoginBean {
    private final UserRepository userRepository;

    public LoginBean(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public SaveUserResponseDTO exec(String name, String password){
        /**
         유저 정보를 레포지토리에서 이름으로 가져온다.
         정보가 없으면 이름이 틀렸다. 그냥 null로 반환
         정보가 있으면 비밀번호를 비교한다. 비밀번호가 맞으면 아이디와 이름을 넣어서 반환
         비밀번호가 틀리면 아이디만 넣어서 반환 X
         일단 비밀번호 틀린 것도 null 반환 하게 함
         **/
        User user = userRepository.findByName(name);
        SaveUserResponseDTO saveUserResponseDTO = new SaveUserResponseDTO();
        if (user == null)   return null;

        else if (user.getPassword().equals(password)){
            saveUserResponseDTO.setId(user.getId());
            saveUserResponseDTO.setName(user.getName());
            return saveUserResponseDTO;
        }
        else{
            /**
             saveUserResponseDTO.setId(user.getId());
             return saveUserResponseDTO;
             **/
            return null;
        }
    }
}
