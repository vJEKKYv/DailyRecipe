package DailyRecipe.DailyRecipe_study.Recipe.service;


import DailyRecipe.DailyRecipe_study.Recipe.bean.UpdateRecipeBean;
import DailyRecipe.DailyRecipe_study.Recipe.bean.DeleteRecipeBean;
import DailyRecipe.DailyRecipe_study.Recipe.bean.SaveRecipeBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.UpdateRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.DeleteRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.SaveRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.repository.RecipeDAORepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RecipeService {
    private final RecipeDAORepository recipeDAORepository;
    private final SaveRecipeBean saveRecipeBean;
    private final DeleteRecipeBean deleteRecipeBean;
    private final UpdateRecipeBean updateRecipeBean;


    public RecipeService(RecipeDAORepository recipeDAORepository, SaveRecipeBean saveRecipeBean,
                         DeleteRecipeBean deleteRecipeBean, UpdateRecipeBean updateRecipeBean){
        this.recipeDAORepository = recipeDAORepository;
        this.saveRecipeBean = saveRecipeBean;
        this.deleteRecipeBean = deleteRecipeBean;
        this.updateRecipeBean = updateRecipeBean;
    }

    //레시피 저장
    public UUID saveRecipe(SaveRecipeRequestDTO saveRecipeRequestDTO){
        return saveRecipeBean.exec(saveRecipeRequestDTO);
    }

    //레시피 수정
    public UUID updateRecipe(UpdateRecipeRequestDTO updateRecipeRequestDTO){
        return updateRecipeBean.exec(updateRecipeRequestDTO);
    }

    //레시피 삭제
    public boolean deleteRecipe(DeleteRecipeRequestDTO deleteRecipeRequestDTO){
        return deleteRecipeBean.exec(deleteRecipeRequestDTO);
    }
}
