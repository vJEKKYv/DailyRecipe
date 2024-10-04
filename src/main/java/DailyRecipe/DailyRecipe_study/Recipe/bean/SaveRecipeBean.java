package DailyRecipe.DailyRecipe_study.Recipe.bean;

import DailyRecipe.DailyRecipe_study.Recipe.bean.small.SaveRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.SaveRecipeRequestDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveRecipeBean {
    private final SaveRecipeDAOBean saveRecipeDAOBean;

    public SaveRecipeBean(SaveRecipeDAOBean saveRecipeDAOBean){
        this.saveRecipeDAOBean = saveRecipeDAOBean;
    }

    public UUID exec(SaveRecipeRequestDTO saveRecipeRequestDTO){
        return saveRecipeDAOBean.exec(saveRecipeRequestDTO);
    }
}
