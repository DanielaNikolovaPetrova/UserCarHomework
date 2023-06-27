package DanielaPetrova.UserCarProject.repository;

import DanielaPetrova.UserCarProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
