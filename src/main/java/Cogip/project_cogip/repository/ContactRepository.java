package Cogip.project_cogip.repository;

import Cogip.project_cogip.entities.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
    List<Contact> findAllByCompanyId(int companyId);
    List<Contact> findAll();

    List<Contact> id(Long id);
}
