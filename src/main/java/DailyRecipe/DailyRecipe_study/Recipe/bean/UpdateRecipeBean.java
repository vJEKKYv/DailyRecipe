package DailyRecipe.DailyRecipe_study.Recipe.bean;

import DailyRecipe.DailyRecipe_study.Recipe.bean.small.CheckUserIdBean;
import DailyRecipe.DailyRecipe_study.Recipe.bean.small.GetRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.bean.small.SaveRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.UpdateRecipeRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateRecipeBean {
    private final GetRecipeDAOBean getRecipeDAOBean;
    private final CheckUserIdBean checkUserIdBean;
    private final SaveRecipeDAOBean saveRecipeDAOBean;

    public UpdateRecipeBean(GetRecipeDAOBean getRecipeDAOBean, CheckUserIdBean checkUserIdBean,
                            SaveRecipeDAOBean saveRecipeDAOBean){
        this.getRecipeDAOBean = getRecipeDAOBean;
        this.checkUserIdBean = checkUserIdBean;
        this.saveRecipeDAOBean = saveRecipeDAOBean;
    }
    @Transactional
    public UUID exec(UpdateRecipeRequestDTO updateRecipeRequestDTO){
        RecipeDAO recipeDAO = getRecipeDAOBean.exec(updateRecipeRequestDTO.getRecipeId());
        if (recipeDAO == null)  return null;
        else if (updateRecipeRequestDTO.getUserId() != checkUserIdBean.exec(updateRecipeRequestDTO.getUserId())) {
            return  null;
        } else {
            recipeDAO.setUserId(updateRecipeRequestDTO.getUserId());
            recipeDAO.setThumbnail(updateRecipeRequestDTO.getThumbnail());
            recipeDAO.setTitle(updateRecipeRequestDTO.getTitle());
            recipeDAO.setDescription(updateRecipeRequestDTO.getDescription());
            recipeDAO.setIngredient(updateRecipeRequestDTO.getIngredient());
            recipeDAO.setInstruction(updateRecipeRequestDTO.getInstruction());
            return  saveRecipeDAOBean.exec(recipeDAO);
        }
    }
}
