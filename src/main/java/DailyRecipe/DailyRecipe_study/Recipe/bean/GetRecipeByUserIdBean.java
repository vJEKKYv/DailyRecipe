package DailyRecipe.DailyRecipe_study.Recipe.bean;

import DailyRecipe.DailyRecipe_study.Recipe.bean.small.GetRecipeDAOByUserIdBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetRecipeByUserIdBean {
    private final GetRecipeDAOByUserIdBean getRecipeDAOByUserIdBean;

    public GetRecipeByUserIdBean(GetRecipeDAOByUserIdBean getRecipeDAOByUserIdBean){
        this.getRecipeDAOByUserIdBean = getRecipeDAOByUserIdBean;
    }

    public List<RecipeDAO> exec(UUID userId){
        return getRecipeDAOByUserIdBean.exec(userId);
    }
}
