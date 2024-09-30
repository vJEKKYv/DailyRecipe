package DailyRecipe.DailyRecipe_study.User.service;

import DailyRecipe.DailyRecipe_study.User.bean.LoginBean;
import DailyRecipe.DailyRecipe_study.User.bean.SaveUserBean;
import DailyRecipe.DailyRecipe_study.User.bean.ValidateDuplicateUserBean;
import DailyRecipe.DailyRecipe_study.User.domain.dto.DuplicateUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.LoginUserDTO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.SignupUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.TotalUserResponseDTO;
import DailyRecipe.DailyRecipe_study.User.repository.UserDAORepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAORepository userDAORepository;
    private final ValidateDuplicateUserBean validateDuplicateUserBean;
    private final SaveUserBean saveUserBean;
    private final LoginBean loginBean;

    public UserService(UserDAORepository userDAORepository, ValidateDuplicateUserBean validateDuplicateUserBean,
                       SaveUserBean saveUserBean, LoginBean loginBean){
        this.userDAORepository = userDAORepository;
        this.validateDuplicateUserBean = validateDuplicateUserBean;
        this.saveUserBean = saveUserBean;
        this.loginBean = loginBean;
    }

    //중복검사
    public boolean validateDuplicateUser(DuplicateUserRequestDTO duplicateUserRequestDTO){
        return validateDuplicateUserBean.exec(duplicateUserRequestDTO);
    }

    //회원가입
    public boolean saveUser(SignupUserRequestDTO signupUserRequestDTO){
        return saveUserBean.exec(signupUserRequestDTO);
    }

    //로그인
    public TotalUserResponseDTO login(LoginUserDTO loginUserDTO){
        return loginBean.exec(loginUserDTO);
    }

    //로그아웃
    public boolean logout(){
        /**
         * 로그아웃은 세션 반환 후 세션 반환에 성공하면 true, 실패하면 false를 기록하는 식으로 동작한다고 한다.
         * 하지만 현재 세션을 구현 하지 않았으므로 지금은 logout의 함수 동작이 별도로 없다.
         * 일단 true를 반환하는 것으로 처리 하고 후에 세션에 관한 함수를 추가 한 후 동작을 수정한다.
         */
        return true;
    }
}
