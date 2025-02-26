package Cogip.project_cogip.controller;

import Cogip.project_cogip.dto.ContactDto;
import Cogip.project_cogip.entities.Contact;
import Cogip.project_cogip.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public String addContact(@RequestBody ContactDto contact) {
        contactService.addContact(contact);
        return "Added contact successfully";
    }

    @GetMapping
    public List<ContactDto> getAllContacts() {
        return contactService.getAllContact();
    }

    @GetMapping("/{id}")
    public ContactDto getContactById(@PathVariable int id) {
        return contactService.getContactById(id);
    }

    @PutMapping("/{id}")
    public String updateContact(@PathVariable long id, @RequestBody ContactDto contact) {
        contactService.updateContactById(id, contact);
        return "contact updated successfully";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        contactService.deleteContactById(id);
        return ResponseEntity.ok("contact deleted successfully");
    }
}
