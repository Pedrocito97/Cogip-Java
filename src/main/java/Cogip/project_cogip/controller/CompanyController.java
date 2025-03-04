package Cogip.project_cogip.controller;

import Cogip.project_cogip.dto.CompanyDto;
import Cogip.project_cogip.dto.CompanyGetDto;
import Cogip.project_cogip.dto.ContactDto;
import Cogip.project_cogip.dto.InvoicesDto;
import Cogip.project_cogip.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public String createCompany(@RequestBody CompanyDto companyDto) {
        companyService.CreateCompany(companyDto);
        return "the company has been created successfully, those are the informations : "+companyDto.toString();
    }

    @GetMapping
    public List<CompanyGetDto> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public CompanyGetDto getCompanyById(@PathVariable int id){
        return companyService.getCompanyById(id);
    }

    @PutMapping("/{id}")
    public String updateCompanyById(@RequestBody CompanyDto companyDto, @PathVariable int id){
        return companyService.updateCompanyById(companyDto, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCompanyById(@PathVariable int id){
        return companyService.deleteById(id);
    }

    @GetMapping("/{id}/invoices")
    public List<InvoicesDto> getAllInvoicesByCompanyId(@PathVariable int id){
        return companyService.getAllInvoicesByCompanyId(id);
    }

    @GetMapping("/{id}/contact")
    public List<ContactDto> getAllContactByCompanyId(@PathVariable int id){
        return companyService.getAllContactByCompanyId(id);
    }

}
