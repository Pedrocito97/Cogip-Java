package Cogip.project_cogip.repository;

import Cogip.project_cogip.entities.Companies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Companies, Integer> {

    List<Companies> findCompaniesByTypeId(long id);
}
