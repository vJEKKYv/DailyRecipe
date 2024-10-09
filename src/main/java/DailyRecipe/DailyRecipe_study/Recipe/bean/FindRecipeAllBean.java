package DailyRecipe.DailyRecipe_study.Recipe.bean;

import DailyRecipe.DailyRecipe_study.Recipe.bean.small.FindRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.controller.RecipeController;
import DailyRecipe.DailyRecipe_study.Recipe.domain.RecipeDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindRecipeAllBean {
    private final FindRecipeDAOBean findRecipeDAOBean;

    public FindRecipeAllBean(FindRecipeDAOBean findRecipeDAOBean){
        this.findRecipeDAOBean = findRecipeDAOBean;
    }

    public List<RecipeDAO> exec(){
        return findRecipeDAOBean.exec();
    }
}
