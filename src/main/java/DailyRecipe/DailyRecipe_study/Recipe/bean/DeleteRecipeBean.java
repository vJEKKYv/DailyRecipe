package DailyRecipe.DailyRecipe_study.Recipe.bean;

import DailyRecipe.DailyRecipe_study.Recipe.bean.small.DeleteRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.bean.small.GetRecipeDAOBean;
import DailyRecipe.DailyRecipe_study.Recipe.domain.dto.DeleteRecipeRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class DeleteRecipeBean {
    private final DeleteRecipeDAOBean deleteRecipeDAOBean;
    private final GetRecipeDAOBean getRecipeDAOBean;

    public DeleteRecipeBean(DeleteRecipeDAOBean deleteRecipeDAOBean, GetRecipeDAOBean getRecipeDAOBean){
        this.deleteRecipeDAOBean = deleteRecipeDAOBean;
        this.getRecipeDAOBean = getRecipeDAOBean;
    }
    public boolean exec(DeleteRecipeRequestDTO deleteRecipeRequestDTO){
        if (getRecipeDAOBean.exec(deleteRecipeRequestDTO.getId())==null)    return false;
        else    return deleteRecipeDAOBean.exec(deleteRecipeRequestDTO);
    }

}
