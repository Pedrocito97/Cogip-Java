package Cogip.project_cogip.repository;

import Cogip.project_cogip.dto.InvoicesDto;
import Cogip.project_cogip.entities.Invoices;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoicesRepository extends CrudRepository<Invoices, Integer> {
    List<Invoices> findAllByCompany_Id(int id);
    List<Invoices> findAll();
}
