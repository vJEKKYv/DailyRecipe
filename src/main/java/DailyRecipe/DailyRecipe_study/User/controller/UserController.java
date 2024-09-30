package DailyRecipe.DailyRecipe_study.User.controller;

import DailyRecipe.DailyRecipe_study.User.domain.dto.DuplicateUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.LoginUserDTO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.SaveUserRequestDTO;
import DailyRecipe.DailyRecipe_study.User.domain.dto.TotalUserResponseDTO;
import DailyRecipe.DailyRecipe_study.User.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//할거면 하나로 확실히 지키면서 가기. 왔다갔다 하면 헷갈림. 전체적 통일성 필요
@RestController
@RequestMapping(value = "/auth")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/test")
    public ResponseEntity<Map<String, Object>> test(){
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("is_success", true);
        requestMap.put("message", "테스트 성공");
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @PostMapping(value = "/duplicate")
    public ResponseEntity<Map<String, Object>> duplicate(@RequestBody DuplicateUserRequestDTO duplicateUserRequestDTO){
        boolean check = userService.validateDuplicateUser(duplicateUserRequestDTO);
        Map<String, Object> requestMap = new HashMap<>();

        requestMap.put("is_success", check);
        requestMap.put("message", check ? "사용할 수 있는 아이디입니다. " : "이미 있는 아이디입니다. ");
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody SaveUserRequestDTO saveUserRequestDTO){
        boolean check = userService.saveUser(saveUserRequestDTO);
        Map<String, Object> requestMap = new HashMap<>();

        requestMap.put("is_success", check);
        requestMap.put("message", check ? "계정이 성공적으로 생성되었습니다. " : "계정 생성에 실패하였습니다. ");
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginUserDTO loginUserDTO){
        TotalUserResponseDTO totalUserResponseDTO = userService.login(loginUserDTO);
        Map<String, Object> requestMap = new HashMap<>();

        requestMap.put("is_success", totalUserResponseDTO != null);
        requestMap.put("message", totalUserResponseDTO != null ? "로그인에 성공했습니다. " : "아이디 혹은 비밀번호가 다릅니다. ");
        requestMap.put("user_id", totalUserResponseDTO !=null ? totalUserResponseDTO.getId() : null);
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<Map<String, Object>> logout() {
        Map<String, Object> requestMap = new HashMap<>();
        boolean check = userService.logout();

        requestMap.put("is_success", check);
        requestMap.put("message", check ? "로그아웃에 성공했습니다. " : "로그아웃에 실패했습니다. ");

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
