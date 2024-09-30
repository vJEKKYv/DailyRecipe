package DailyRecipe.DailyRecipe_study.User.repository;

import DailyRecipe.DailyRecipe_study.User.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDAORepository extends JpaRepository<UserDAO, UUID> {
    public UserDAO findByName(String name);
}
