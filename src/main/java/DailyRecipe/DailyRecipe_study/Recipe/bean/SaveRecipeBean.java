package DailyRecipe.DailyRecipe_study.Recipe.bean;

import DailyRecipe.DailyRecipe_study.Recipe.bean.small.CheckUserIdBean;
import DailyRecipe.DailyRecipe_study.Recipe.bean.small.CreateRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.bean.small.SaveRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.SaveRecipeRequestDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveRecipeBean {
    private final CheckUserIdBean checkUserIdBean;
    private final CreateRecipeDAOBean createRecipeDAOBean;
    private final SaveRecipeDAOBean saveRecipeDAOBean;

    public SaveRecipeBean(SaveRecipeDAOBean saveRecipeDAOBean, CreateRecipeDAOBean createRecipeDAOBean,
                          CheckUserIdBean checkUserIdBean){
        this.createRecipeDAOBean = createRecipeDAOBean;
        this.saveRecipeDAOBean = saveRecipeDAOBean;
        this.checkUserIdBean = checkUserIdBean;
    }

    public UUID exec(SaveRecipeRequestDTO saveRecipeRequestDTO){
        if (saveRecipeRequestDTO.getUserId() !=checkUserIdBean.exec(saveRecipeRequestDTO.getUserId())){
            return null;
        }
        RecipeDAO recipeDAO = createRecipeDAOBean.exec(saveRecipeRequestDTO);
        return saveRecipeDAOBean.exec(recipeDAO);
    }
}
