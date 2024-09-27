package DailyRecipe.DailyRecipe_study.User.controller;

import DailyRecipe.DailyRecipe_study.User.domain.User;
import DailyRecipe.DailyRecipe_study.User.domain.dto.SaveUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.SaveUserResponseDTO;
import DailyRecipe.DailyRecipe_study.User.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/auth/test")
    public ResponseEntity<Map<String, Object>> test(){
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("is_success", true);
        requestMap.put("message", "테스트 접근 성공");
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @PostMapping(value = "/auth/duplicate")
    public ResponseEntity<Map<String, Object>> duplicate(@RequestBody SaveUserRequestDTO saveUserRequestDTO){
        boolean check = userService.validateDuplicateUser(saveUserRequestDTO.getName());
        Map<String, Object> requestMap = new HashMap<>();

        requestMap.put("is_success", check);
        requestMap.put("message", check ? "사용할 수 있는 아이디입니다. " : "이미 있는 아이디입니다. ");
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @PostMapping(value = "/auth/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody SaveUserRequestDTO saveUserRequestDTO){
        boolean check = userService.saveUser(saveUserRequestDTO.getName(), saveUserRequestDTO.getPassword());
        Map<String, Object> requestMap = new HashMap<>();

        requestMap.put("is_success", check);
        requestMap.put("message", check ? "계정이 성공적으로 생성되었습니다. " : "계정 생성에 실패하였습니다. ");
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody SaveUserRequestDTO saveUserRequestDTO){
        SaveUserResponseDTO saveUserResponseDTO = userService.login(saveUserRequestDTO.getName(), saveUserRequestDTO.getPassword());
        Map<String, Object> requestMap = new HashMap<>();

        requestMap.put("is_success", saveUserResponseDTO != null);
        requestMap.put("message", saveUserResponseDTO != null ? "로그인에 성공했습니다. " : "아이디 혹은 비밀번호가 다릅니다. ");
        requestMap.put("user_id", saveUserResponseDTO !=null ? saveUserRequestDTO.getId() : null);
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @PostMapping(value = "/auth/logout")
    public ResponseEntity<Map<String, Object>> logout() {
        Map<String, Object> requestMap = new HashMap<>();
        boolean check = userService.logout();

        requestMap.put("is_success", check);
        requestMap.put("message", check ? "로그아웃에 성공했습니다. " : "로그아웃에 실패했습니다. ");

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
