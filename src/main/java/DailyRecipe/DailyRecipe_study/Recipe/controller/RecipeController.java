package DailyRecipe.DailyRecipe_study.Recipe.controller;


import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.UpdateRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.DeleteRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.SaveRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/auth")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @PostMapping(value = "/recipes")
    public ResponseEntity<Map<String, Object>> saveRecipe(@RequestBody SaveRecipeRequestDTO saveRecipeRequestDTO){
        UUID id = recipeService.saveRecipe(saveRecipeRequestDTO);
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("is_success", id!=null);
        requestMap.put("message", id!=null ? "레시피 등록에 성공했습니다. " : "레시피 등록에 실패했습니다. ");
        requestMap.put("Recipe_id", id);
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @PutMapping(value = "/recipes")
    public ResponseEntity<Map<String, Object>> updateRecipe(@RequestBody UpdateRecipeRequestDTO updateRecipeRequestDTO){
        UUID id = recipeService.updateRecipe(updateRecipeRequestDTO);

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("is_success", id != null);
        requestMap.put("message", id != null ? "레시피 수정에 성공했습니다. " : "레시피 수정에 실패했습니다. ");
        requestMap.put("Recipe_id", id);
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @DeleteMapping(value = "/recipes")
    public ResponseEntity<Map<String , Object>> deleteRecipe(@RequestBody DeleteRecipeRequestDTO deleteRecipeRequestDTO){
        boolean check = recipeService.deleteRecipe(deleteRecipeRequestDTO);

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("is_success", check);
        requestMap.put("message", check ? "레시피 삭제에 성공했습니다. " : "레시피 삭제에 실패했습니다. ");
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @GetMapping(value = "/recipes/all")
    public ResponseEntity<Map<String, Object>> getRecipeAll(){
        List<RecipeDAO> recipeDAOList = recipeService.getRecipeAll();

        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("is_success", recipeDAOList!=null);
        requestMap.put("message", recipeDAOList!=null? "전체 레시피 조회에 성공했습니다. " : "전체 레시피 조회에 실패했습니다. ");
        requestMap.put("Recipes", recipeDAOList);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @GetMapping(value = "/recipes/detail")
    public ResponseEntity<Map<String, Object>> getRecipeById(@RequestParam("recipe_id") UUID id){
        RecipeDAO recipeDAO = recipeService.getRecipeById(id);

        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("is_success", recipeDAO!=null);
        requestMap.put("message", recipeDAO!=null? "상세 레시피 조회에 성공했습니다. " : "상세 레시피 조회에 실패했습니다. ");
        requestMap.put("Recipes", recipeDAO);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

}
