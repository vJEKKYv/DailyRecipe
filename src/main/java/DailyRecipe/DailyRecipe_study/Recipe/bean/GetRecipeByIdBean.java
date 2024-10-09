package DailyRecipe.DailyRecipe_study.Recipe.bean;

import DailyRecipe.DailyRecipe_study.Recipe.bean.small.GetRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetRecipeByIdBean {
    private final GetRecipeDAOBean getRecipeDAOBean;

    public GetRecipeByIdBean(GetRecipeDAOBean getRecipeDAOBean){
        this.getRecipeDAOBean = getRecipeDAOBean;
    }

    public RecipeDAO exec(UUID id){
        return getRecipeDAOBean.exec(id);
    }
}
