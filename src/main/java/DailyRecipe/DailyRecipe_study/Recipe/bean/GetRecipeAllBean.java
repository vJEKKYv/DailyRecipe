package DailyRecipe.DailyRecipe_study.Recipe.bean;

import DailyRecipe.DailyRecipe_study.Recipe.bean.small.GetRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetRecipeAllBean {
    private final GetRecipeDAOBean getRecipeDAOBean;

    public GetRecipeAllBean(GetRecipeDAOBean getRecipeDAOBean){
        this.getRecipeDAOBean = getRecipeDAOBean;
    }

    public List<RecipeDAO> exec(){
        return getRecipeDAOBean.exec();
    }
}
