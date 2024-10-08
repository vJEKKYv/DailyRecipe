package DailyRecipe.DailyRecipe_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DailyRecipeStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyRecipeStudyApplication.class, args);
	}
	//2024-09-30 레시피 부분 아직 안함. 기존 있던 유저 부분 수정ING
	//2024-10-01 RecipeDAO 구성 및 Repository 연결 - DAO 구성 미완. 구조 파악 필요.
	//2024-10-02 RecipeController, Service 구조 작성. 내부 구현은 아직 안함.
	//2024-10-03 구현 x 이제 시작 합니다..
		// 구현 완료. but 재료와 조리법 List<Map<String, Object>> 형식으로 변경 필요
	//2024-10-05 금일 구현 X. 금일 안에 재료와 조리법 Converter 이용한 구조 변경 구현 예정
		// Converter 구현 완료, recipe 생성, 수정 시 userId 체크 하도록 변경
	//2024-10-06 아직 구현 x. 전체 조회 구현 예정.
	//2024-10-07 오늘 구현 x. 어제 안 한 구현 내용  api 명세에 따라 하나씩 구현 예정
	//2024-10-08 오늘도..구현..X... 오늘은 진짜 합니다..
}
