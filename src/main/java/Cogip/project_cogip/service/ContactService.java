package Cogip.project_cogip.service;

import Cogip.project_cogip.dto.ContactDto;
import Cogip.project_cogip.entities.Companies;
import Cogip.project_cogip.entities.Contact;
import Cogip.project_cogip.repository.CompanyRepository;
import Cogip.project_cogip.repository.ContactRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, CompanyRepository companyRepository) {
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
    }

    public void addContact(ContactDto contactDto) {
        Companies company = companyRepository.findById(contactDto.getCompany_id())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Contact newContact = new Contact();
        newContact.setName(contactDto.getName());
        newContact.setEmail(contactDto.getEmail());
        newContact.setPhone(contactDto.getPhone());
        newContact.setCompany(company);

        contactRepository.save(newContact);
    }

    public List<ContactDto> getAllContact() {
        return contactRepository.findAll()
                .stream()
                .map(contact -> new ContactDto(contact))
                .toList();

    }

    public ContactDto getContactById(int id) {
        return contactRepository.findById(id)
                .map(contact -> new ContactDto(contact))
                .orElseThrow(() -> new RuntimeException("contact not found"));
    }

    public void updateContactById(long id, ContactDto contactDto) {
        Contact newContact =  contactRepository.findById((int) id).orElseThrow(() -> new EntityNotFoundException("contact not found"));
        newContact.setName(contactDto.getName());
        newContact.setEmail(contactDto.getEmail());
        newContact.setPhone(contactDto.getPhone());
        contactRepository.save(newContact);
    }

    public void deleteContactById(int id) {
        contactRepository.deleteById(id);
    }
}
