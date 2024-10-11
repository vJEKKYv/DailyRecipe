package DailyRecipe.DailyRecipe_study.Recipe.bean;

import DailyRecipe.DailyRecipe_study.Recipe.bean.small.DeleteRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.bean.small.GetRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.DeleteRecipeRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class DeleteRecipeBean {
    private final GetRecipeDAOBean getRecipeDAOBean;
    private final DeleteRecipeDAOBean deleteRecipeDAOBean;

    public DeleteRecipeBean(GetRecipeDAOBean getRecipeDAOBean, DeleteRecipeDAOBean deleteRecipeDAOBean){
        this.deleteRecipeDAOBean = deleteRecipeDAOBean;
        this.getRecipeDAOBean = getRecipeDAOBean;
    }
    public boolean exec(DeleteRecipeRequestDTO deleteRecipeRequestDTO){
        if (getRecipeDAOBean.exec(deleteRecipeRequestDTO.getRecipeId())==null)    return false;

        else    return deleteRecipeDAOBean.exec(deleteRecipeRequestDTO);
    }
}