package DailyRecipe.DailyRecipe_study.User.repository;

import DailyRecipe.DailyRecipe_study.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByName(String name);
}
