package DailyRecipe.DailyRecipe_study.Recipe.service;


import DailyRecipe.DailyRecipe_study.Recipe.bean.*;
import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.UpdateRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.DeleteRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.SaveRecipeRequestDTO;
import DailyRecipe.DailyRecipe_study.Recipe.repository.RecipeDAORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {
    private final RecipeDAORepository recipeDAORepository;
    private final SaveRecipeBean saveRecipeBean;
    private final DeleteRecipeBean deleteRecipeBean;
    private final UpdateRecipeBean updateRecipeBean;
    private final GetRecipeAllBean getRecipeAllBean;
    private final GetRecipeByIdBean getRecipeByIdBean;
    private final GetRecipeByUserIdBean getRecipeByUserIdBean;


    public RecipeService(RecipeDAORepository recipeDAORepository, SaveRecipeBean saveRecipeBean,
                         DeleteRecipeBean deleteRecipeBean, UpdateRecipeBean updateRecipeBean,
                         GetRecipeAllBean getRecipeAllBean, GetRecipeByIdBean getRecipeByIdBean,
                         GetRecipeByUserIdBean getRecipeByUserIdBean){
        this.recipeDAORepository = recipeDAORepository;
        this.saveRecipeBean = saveRecipeBean;
        this.deleteRecipeBean = deleteRecipeBean;
        this.updateRecipeBean = updateRecipeBean;
        this.getRecipeAllBean = getRecipeAllBean;
        this.getRecipeByIdBean = getRecipeByIdBean;
        this.getRecipeByUserIdBean = getRecipeByUserIdBean;
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

    //전체 조회
    public List<RecipeDAO> getRecipeAll(){
        return  getRecipeAllBean.exec();
    }

    //ID 조회
    public RecipeDAO getRecipeById(UUID id){
        return getRecipeByIdBean.exec(id);
    }

    //UserId 조회
    public List<RecipeDAO> getRecipeByUserId(UUID userId){
        return getRecipeByUserIdBean.exec(userId);
    }
}
