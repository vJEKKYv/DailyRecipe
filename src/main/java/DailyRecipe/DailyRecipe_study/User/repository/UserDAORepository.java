package DailyRecipe.DailyRecipe_study.User.repository;

import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDAORepository extends JpaRepository<UserDAO, UUID> {
    public UserDAO findByUserName(String userName);
    public UserDAO findByUserNameAndPassword(String userName, String password);
}
