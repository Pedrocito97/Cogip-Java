package Cogip.project_cogip.repository;

import Cogip.project_cogip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
