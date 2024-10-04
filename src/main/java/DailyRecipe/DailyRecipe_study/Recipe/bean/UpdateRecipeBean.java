package DailyRecipe.DailyRecipe_study.Recipe.bean;

import DailyRecipe.DailyRecipe_study.Recipe.bean.small.GetRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.bean.small.SaveRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.UpdateRecipeRequestDTO;
import jakarta.transaction.Transactional;

public class UpdateRecipeBean {
    private final GetRecipeDAOBean getRecipeDAOBean;
    private final SaveRecipeDAOBean saveRecipeDAOBean;

    public UpdateRecipeBean(GetRecipeDAOBean getRecipeDAOBean, SaveRecipeDAOBean saveRecipeDAOBean){
        this.getRecipeDAOBean = getRecipeDAOBean;
        this.saveRecipeDAOBean = saveRecipeDAOBean;
    }
    @Transactional
    public boolean exec(UpdateRecipeRequestDTO updateRecipeRequestDTO){
        RecipeDAO recipeDAO = getRecipeDAOBean.exec(updateRecipeRequestDTO.getRecipeId());
        if (recipeDAO == null)  return false;
        else {
            recipeDAO.setUserId(updateRecipeRequestDTO.getUserId());
            recipeDAO.setThumbnail(updateRecipeRequestDTO.getThumbnail());
            recipeDAO.setTitle(updateRecipeRequestDTO.getTitle());
            recipeDAO.setDescription(updateRecipeRequestDTO.getDescription());
            recipeDAO.setIngredient(updateRecipeRequestDTO.getIngredient());
            recipeDAO.setInstruction(updateRecipeRequestDTO.getInstruction());
            saveRecipeDAOBean.exec(recipeDAO);
            return true;
        }
    }
}
