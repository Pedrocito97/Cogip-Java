package Cogip.project_cogip.repository;

import Cogip.project_cogip.entities.Companies;
import Cogip.project_cogip.entities.Types;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Types, Integer> {

    Optional<Types> findById(long id);


}
